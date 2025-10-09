/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.service;

import com.myj.shopping.model.base.BaseResponse;
import com.myj.shopping.model.http.UserReq;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author mayujing
 * @version 1.0
 */
public interface UserService {
    BaseResponse login(HttpServletRequest request, HttpServletResponse response, UserReq userReq);
}
