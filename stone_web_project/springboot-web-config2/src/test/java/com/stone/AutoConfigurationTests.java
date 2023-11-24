package com.stone;


import com.example.HeaderGenerator;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.stone.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootTest
public class AutoConfigurationTests {
    @Autowired
    private Gson gson;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testJson(){
        String json = gson.toJson(Result.success());
        System.out.println(json);
    }

    @Test
    public void testTokenParse(){
        System.out.println(applicationContext.getBean(TokenParser.class));
    }
    @Test
    public void testHeaderParse(){
        System.out.println(applicationContext.getBean(HeaderParser.class));
    }
    @Test
    public void testHeaderGenerator(){
        System.out.println(applicationContext.getBean(HeaderGenerator.class));
    }

}
