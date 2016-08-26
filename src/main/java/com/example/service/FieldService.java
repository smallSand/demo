package com.example.service;

import java.util.List;

import com.example.model.Field;
public interface FieldService {
	List<Field> getFieldByKW(String kw);
}
