package com.example.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Field;
import com.example.service.FieldRepository;
@RestController 
@RequestMapping(value="/search")
public class SearchCotroller {
	
	@Autowired
	private FieldRepository fieldRepository;
    @RequestMapping(value="/", method=RequestMethod.POST) 
    public List<Field> search(@RequestParam String name) { 
        // 处理"/search/"的POST请求，用来sousuo 
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
    	if(StringUtils.isEmpty(name)){
    		return null;
    	}
    	List<Field> list=fieldRepository.findUsers(name);
        return list;
    } 
}
