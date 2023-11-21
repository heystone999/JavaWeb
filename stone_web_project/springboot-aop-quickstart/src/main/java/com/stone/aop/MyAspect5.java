package com.stone.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Slf4j
@Component
//@Aspect
public class MyAspect5 {

    @Before("com.stone.aop.MyAspect1.pt()")
    public void before() {
        log.info("before ...5");
    }


    @After("com.stone.aop.MyAspect1.pt()")
    public void after() {
        log.info("after ...5");
    }

}
