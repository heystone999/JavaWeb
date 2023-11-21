package com.stone.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect7 {
    @Pointcut("@annotation(MyLog)")
    public void pt() {
    }

    @Before("pt()")
    public void before() {
        log.info("MyAspect7 before ...");
    }


}
