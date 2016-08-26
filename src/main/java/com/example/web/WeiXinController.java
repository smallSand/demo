package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeiXinController {

	   @RequestMapping("/weixin")
	    public boolean index(String signature,String timestamp,String nonce,String echostr) {
		  return true;
	    }
}
