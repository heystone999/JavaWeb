package com.stone.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo 拦截请求 放行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Demo 拦截请求 放行后");
    }

    @Override
    public void destroy() {
        System.out.println("destory 销毁方法");
    }
}
