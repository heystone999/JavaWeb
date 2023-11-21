package com.stone.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect6 {
//    @Pointcut("execution(public void com.stone.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Pointcut("execution(void com.stone.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Pointcut("execution(void delete(java.lang.Integer))")
//    @Pointcut("execution(void com.stone.service.DeptService.delete(java.lang.Integer))")
//    @Pointcut("execution(void com.stone.service.DeptService.*(java.lang.Integer))")
//    @Pointcut("execution(* com.*.service.DeptService.*(*))")
//    @Pointcut("execution(* com.stone.service.*Service.delete*(*))")
    @Pointcut("execution(* com.stone.service.DeptService.*(*))")
    public void pt() {
    }

    @Before("pt()")
    public void before() {
        log.info("MyAspect6 before ...");
    }


}
