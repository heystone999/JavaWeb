package com.stone.filter;

import com.alibaba.fastjson.JSONObject;
import com.stone.pojo.Result;
import com.stone.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

//        获取请求url
        String url = req.getRequestURL().toString();
        log.info("请求的url: {}", url);

//        判断请求URL是否包含token？包含 登录 放行
        if (url.contains("login")) {
            log.info("登录操作 放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
//        获取请求头中的token
        String jwt = req.getHeader("token");

//        判断token是否存在 error
        if (!StringUtils.hasLength(jwt)) {
            log.info("Header中token为空, 返回NOT_LOGIN");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换obj->json  用阿里fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

//        解析token error
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析token失败 返回NOT_LOGIN");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换obj->json  用阿里fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
//        放行
        log.info("token合法 放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
