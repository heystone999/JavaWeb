package com.stone.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.stone.pojo.Result;
import com.stone.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override //目标资源方法运行前运行，true放行，false不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        获取请求url
        String url = request.getRequestURL().toString();
        log.info("请求的url: {}", url);

//        判断请求URL是否包含token？包含 登录 放行
        if (url.contains("login")) {
            log.info("登录操作 放行");
            return true;
        }
//        获取请求头中的token
        String jwt = request.getHeader("token");

//        判断token是否存在 error
        if (!StringUtils.hasLength(jwt)) {
            log.info("Header中token为空, 返回NOT_LOGIN");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换obj->json  用阿里fastJSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
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
            response.getWriter().write(notLogin);
            return false;
        }
//        放行
        log.info("token合法 放行");
        return true;
    }

    @Override ////目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
    }

    @Override //视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion ...");
    }
}
