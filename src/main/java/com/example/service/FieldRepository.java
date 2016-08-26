package com.example.service;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.model.Field;

public interface FieldRepository extends JpaRepository<Field, Long>{
	@Override
	List<Field> findAll();
	
    @Query("from Field f where f.name like %:name% and state=1")
    List<Field> findUsers(@Param("name") String name);
    
    List<Field> findByNameLike(@Param("wd") String wd);
    
    
    List<Field> findByNameContaining(String name);
    
    List<Field>  findByName(String name);
    
    Field findById(Long id);
}
