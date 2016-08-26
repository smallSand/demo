package com.example.web;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Image;
import com.example.service.ImageRepository;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

	@Autowired
	ImageRepository imageRepository;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public List<Image> search(int page, int size) {
		// 处理"/search/"的POST请求，用来sousuo
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		Pageable pageable = new PageRequest(page, size);
		List<Image> list = imageRepository.findImages(pageable);
		return list;
	}

	@RequestMapping(value = "/getImageByte", method = RequestMethod.GET)
	public void getImageByte(Long id, HttpServletRequest req, HttpServletResponse resp) {
		Image image = imageRepository.findById(id);
		byte[] data = image.getImage();
		try {
			OutputStream toClient = new BufferedOutputStream(resp.getOutputStream());
			toClient.write(data);
			toClient.flush();
			toClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/getAllImage", method = RequestMethod.POST)
	public List<Image> getAllImageByid(Long id, HttpServletRequest req, HttpServletResponse resp) {
		Image image = imageRepository.findById(id);
		String title =image.getTitle();
		List<Image> list =imageRepository.findBySameTitle(title);
		return list;
	}
	
}
