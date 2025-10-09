/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.controller;

import com.myj.shopping.model.base.BaseResponse;
import com.myj.shopping.model.http.UserReq;
import com.myj.shopping.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author mayujing
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse login(HttpServletRequest request, HttpServletResponse response,@Validated @RequestBody UserReq userReq) {
        log.info("当前对应的用户为：{}",userReq.getUserName());
        return userService.login(request, response, userReq);
    }
}
