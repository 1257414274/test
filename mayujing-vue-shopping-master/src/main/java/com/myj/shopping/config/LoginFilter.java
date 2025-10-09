/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.config;

import com.alibaba.fastjson.JSON;
import com.myj.shopping.model.base.BaseResponse;
import com.myj.shopping.model.base.ErrorMessage;
import com.myj.shopping.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @author mayujing
 * @version 1.0
 */
@Slf4j
@WebFilter(urlPatterns = "/*") //拦截所有请求
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //前置：强制转换为http协议的请求对象、响应对象 （转换原因：要使用子类中特有方法）
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        //1.获取请求url
        String url = request.getRequestURL().toString();

        log.info("请求路径：{}", url); //请求路径：http://localhost:8088/login
        // 定义不需要过滤的URL模式
        List<String> excludedPatterns = Arrays.asList("/login","/doc.html","/swagger", "/favicon", "/webjars", "/v2");
        //2.检查请求URL是否匹配不需要过滤的模式
        for (String pattern : excludedPatterns) {
            if (url.contains(pattern)) {
                // 如果匹配，则不执行过滤逻辑，直接放行
                filterChain.doFilter(request, response);
                return;
            }
        }
        if (session.getAttribute(Constant.SESSION_KEY) != null) {
            filterChain.doFilter(request, response);
            return;
        } else {
            //从请求头中获取token
            String tokenValue = request.getHeader("token");
            //判断token是否存在，如果不存在，返回错误结果（未登录）
            if (!StringUtils.hasLength(tokenValue)) {
                log.info("Token不存在,用户需要登录"); //返回接口调用方需要登录的错误码，接口调用方开始登录
                returnJson(response);
                return;
            } else {
                //存在就解析token，如果解析失败，返回错误结果（未登录）
                try {
                    Claims claims = JWTUtil.parseJWT(tokenValue);
                    //得到登录对象
                    Object loginUser = claims.get(Constant.SESSION_KEY);
                    if (loginUser != null) {
                        session.setAttribute(Constant.SESSION_KEY, loginUser);
                    }
                } catch (Exception e) {
                    log.info("令牌解析失败!");
                    returnJson(response);
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);
        return;
    }

    /**
     * 返回需要登录的约定格式的错误码，接口调用方根据错误码进行登录操作.
     */
    private void returnJson(ServletResponse response) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSON.toJSONString(BaseResponse.error(ErrorMessage.LOGIN_NO)));
        } catch (IOException e) {
            log.error("response error", e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
