package com.example.service;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Image;
public interface ImageRepository extends JpaRepository<Image, Long> {
	
	Image findById(Long id);
	
	@Query("select new Image(I.id,I.guide,I.title) from  Image I group by I.title  order by I.guide, I.title")
	List<Image> findImages(Pageable pageable);
	
	@Query("select new Image(I.id,I.guide,I.title) from  Image I where I.title=:title")
	List<Image> findBySameTitle(@Param("title") String title);
	
}
