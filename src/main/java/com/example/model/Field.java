package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.jdbc.core.RowMapper;
@Entity
public class Field implements RowMapper<Field> {
    @Id
    @GeneratedValue
    private Long id; 
    @Column(nullable = false)
    private String name; 
    @Column(nullable = false)
    private String  field;
    @Column(nullable = false)
    private Date createtime;
    public Field(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public Field mapRow(ResultSet rs, int rowNum) throws SQLException {
		Field field=new Field();
		field.setId(rs.getLong("id"));
		field.setName(rs.getString("name"));
		field.setField(rs.getString("field"));
		field.setCreatetime(rs.getDate("createtime"));
		return field;
	}
    
}
