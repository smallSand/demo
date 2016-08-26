package com.example.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.model.Field;
import com.example.service.FieldService;
@Service
public class FieldServiceImpl implements FieldService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Field> getFieldByKW(String kw) {
		List<Field> list=jdbcTemplate.query("select field from field ",new Field());
		return list;
	}
	

}
