package com.example.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id; 
/*	@Lob 
	@Basic(fetch=FetchType.LAZY) 
	@Column(name="IMAGE", columnDefinition="BLOB", nullable=true)*/
    @Column(nullable = false)
    private byte[]  image;
    public Image(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
