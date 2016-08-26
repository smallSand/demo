package com.example.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id; 
    @Column(nullable = false)
    private String guide; 
    @Column(nullable = false)
    private String  title;
/*	@Lob 
	@Basic(fetch=FetchType.LAZY) 
	@Column(name="IMAGE", columnDefinition="BLOB", nullable=true)*/
    @Column(nullable = false)
    private byte[]  image;
    @Column(nullable = false)
    private Date createtime;
    public Image(){}
    
	public Image(Long id, String guide, String title) {
		super();
		this.id = id;
		this.guide = guide;
		this.title = title;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGuide() {
		return guide;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
    
}
