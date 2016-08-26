package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.BlogProperties;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {
    
    @Autowired
    private BlogProperties blogProperties;
    
    @Test
    public void testBlog() throws Exception {
        Assert.assertEquals("My Blog",blogProperties.getName());
        Assert.assertEquals("Spring Boot",blogProperties.getTitle());
    }

}
