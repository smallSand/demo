package com.example.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.model.ImageInfo;

public interface ImageInfoRespository extends JpaRepository<ImageInfo, Long> {
	
	ImageInfo findById(Long id);
	
	@Query(" from  ImageInfo I group by I.title  order by I.readcount desc")
	List<ImageInfo> findImages(Pageable pageable);
	
	@Query(" from  ImageInfo I where I.title=:title")
	List<ImageInfo> findBySameTitle(@Param("title") String title);
	
	 @Transactional
	 @Modifying 
	 @Query("update ImageInfo a set a.readcount = a.readcount + 1  where a.title=:title") 
	  int increaseReadCount(@Param("title") String title); 
}
