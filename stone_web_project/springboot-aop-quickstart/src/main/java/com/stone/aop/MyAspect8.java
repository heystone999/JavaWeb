package com.stone.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class MyAspect8 {
    @Pointcut("execution(* com.stone.service.DeptService.*(..))")
    public void pt() {
    }

    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("MyAspect8 before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("MyAspect8 before ...");

        String className = joinPoint.getTarget().getClass().getName();
        log.info("目标对象的类名: {}", className);

        String methodName = joinPoint.getSignature().getName();
        log.info("目标方法的方法名: {}", methodName);

        Object[] args = joinPoint.getArgs();
        log.info("目标方法运行时传入的参数: {}", Arrays.toString(args));

        Object result = joinPoint.proceed();
        log.info("目标方法运行的返回值: {}", result);

        log.info("MyAspect8 after ...");
        return result;
    }

}
