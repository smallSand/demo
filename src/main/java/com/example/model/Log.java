package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Log {
    @Id
    @GeneratedValue
    private Long id; 
    @Column(nullable = false)
    private String URL; 
    @Column(nullable = false)
    private String  HTTP_METHOD;
    @Column(nullable = false)
    private String  IP;
    @Column(nullable = false)
    private String  CLASS_METHOD;
    @Column(nullable = false)
    private String  ARGS;
    public Log(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getHTTP_METHOD() {
		return HTTP_METHOD;
	}
	public void setHTTP_METHOD(String hTTP_METHOD) {
		HTTP_METHOD = hTTP_METHOD;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getCLASS_METHOD() {
		return CLASS_METHOD;
	}
	public void setCLASS_METHOD(String cLASS_METHOD) {
		CLASS_METHOD = cLASS_METHOD;
	}
	public String getARGS() {
		return ARGS;
	}
	public void setARGS(String aRGS) {
		ARGS = aRGS;
	}
}
