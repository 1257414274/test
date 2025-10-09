/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.service.impl;

import com.myj.shopping.config.Constant;
import com.myj.shopping.dao.UserDao;
import com.myj.shopping.model.User;
import com.myj.shopping.model.base.BaseResponse;
import com.myj.shopping.model.base.ErrorMessage;
import com.myj.shopping.model.http.UserReq;
import com.myj.shopping.service.UserService;
import com.myj.shopping.utils.JWTUtil;
import com.myj.shopping.utils.MD5Util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.myj.shopping.utils.bean.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * @author mayujing
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;
    @Override
    public BaseResponse login(HttpServletRequest request, HttpServletResponse response, UserReq userReq) {
        Token token = new Token();
        User user =  userDao.findUserByName(userReq);
        if (user== null) {
            return BaseResponse.error(ErrorMessage.LOGIN_NO_USER);//当前用户不存在
        }

        String encrypt = MD5Util.encrypt(userReq.getPassword());

        // 修改点：添加密码不匹配时的返回逻辑
        if (!encrypt.equals(user.getPassword())) {
            return BaseResponse.error(ErrorMessage.LOGIN_PASS_ERROR); // 密码错误
        }
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("loginUser", user);

            String jwt = JWTUtil.generateJwt(claims);//生成JWT

            token.setToken(jwt);
            token.setUserId(user.getId());
            token.setLoginTime(System.currentTimeMillis());
            request.getSession().setAttribute(Constant.SESSION_KEY, user);

        return BaseResponse.ok(token);
    }
}
