/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping;

import com.myj.shopping.exception.EnableExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author mayujing
 * @version 1.0
 */
@SpringBootApplication
@EnableExceptionHandler //当发生未捕获的异常时，能够按照预定的规则进行处理
@MapperScan("com.myj.shopping.dao")//指定mapper接口的所在包
@ServletComponentScan
public class MyjVueApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyjVueApplication.class, args);
    }
}
