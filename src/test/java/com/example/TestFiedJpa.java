package com.example;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.Field;
import com.example.service.FieldRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class TestFiedJpa {
	 @Autowired
	 private FieldRepository fieldRepository;
	 
	 @Test
	    public void test() throws Exception {
		List<Field> listall = fieldRepository.findAll();
		List<Field> fies = fieldRepository.findByName("刘松林");
		List<Field>  fields = fieldRepository.findByNameContaining("刘松林");
		
		List<Field>  dqw = fieldRepository.findByNameContaining("B");
		List<Field>  das = fieldRepository.findByNameContaining("d");
		
		System.out.println(listall);
		System.out.println(fies);
		System.out.println(fields);
	 }
	 

}
