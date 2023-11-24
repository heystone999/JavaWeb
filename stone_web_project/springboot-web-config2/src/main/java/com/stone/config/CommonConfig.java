package com.stone.config;

import com.stone.service.DeptService;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    // 声明第三方Bean
    @Bean
    public SAXReader reader(DeptService deptService){
        System.out.println(deptService);
        return new SAXReader();
    }
}
