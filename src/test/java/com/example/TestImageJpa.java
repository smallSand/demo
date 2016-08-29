package com.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.model.ImageInfo;
import com.example.service.ImageInfoRespository;
import com.example.service.ImageRepository;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class TestImageJpa {

	 @Autowired
	 private ImageInfoRespository imageInfoRespository;
	 @Test
	 public void test() throws Exception {
		 
		 Pageable pageable=new PageRequest(0,10);
		 
		 List<ImageInfo> images=imageInfoRespository.findImages(pageable);
		 
		 System.out.println(images.size());
	 }
	 @Test
	 public void testFindBySameTitle() throws Exception {
		 
		 
		 List<ImageInfo> images=imageInfoRespository.findBySameTitle("一切只是重新来过我只是丢了气魄");
		 
		 System.out.println(images.size());
	 }
}
