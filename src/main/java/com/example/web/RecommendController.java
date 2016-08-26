package com.example.web;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Field;
import com.example.service.FieldRepository;
@RestController 
@RequestMapping(value="/recommend")
public class RecommendController {
	
	@Autowired
	private FieldRepository fieldRepository;
    @RequestMapping(value="/", method=RequestMethod.POST) 
    public void recommend(@RequestParam String name,String field) { 
        // 处理"/search/"的POST请求，用来sousuo 
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
    	if(!StringUtils.isEmpty(name)&&!StringUtils.isEmpty(field)){
        	Field entity=new Field();
        	entity.setName(name);
        	entity.setField(field);
        	entity.setCreatetime(new Date());
        	fieldRepository.save(entity);
    	}
    } 
}
