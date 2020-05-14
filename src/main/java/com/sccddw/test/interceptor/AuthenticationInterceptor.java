package com.sccddw.test.interceptor;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sccddw.test.annotation.PassToken;
import com.sccddw.test.annotation.UserLoginToken;
import com.sccddw.test.config.CommonException;
import com.sccddw.test.entity.bean.ResultCode;
import com.sccddw.test.entity.db.User;
import com.sccddw.test.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * description
 *
 * @author dell
 * date 2020/5/8 11:39
 * @version 1.0
 **/
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");// 从 http 请求头中取出 Authorization
        if(!(handler instanceof HandlerMethod)){// 如果不是映射到方法直接通过
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        if (method.isAnnotationPresent(UserLoginToken.class)) {//检查有没有需要用户权限的注解
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                if (token == null) {// 执行认证
                    throw new CommonException(ResultCode.JWT_ERRCODE_NULL);//签名不存在
                }
                String username;// 获取token中username
                try {
                    username = JwtUtil.returName(token);
                } catch (JWTDecodeException j) {
                    throw new CommonException(ResultCode.JWT_ERRCODE_NULL);//签名不存在
                }
                User query = new User();query.setUsername(username);
//                User user = userService.findByUsername(query);
//                if (user == null) {
//                    throw new CommonException(ResultCode.JWT_ERRCODE_NULL);//签名不存在
//                }
                try {
                    JwtUtil.validateToken(token);
                } catch (JWTVerificationException e) {
                    throw new CommonException(ResultCode.JWT_ERRCODE_NULL);//签名不存在
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
