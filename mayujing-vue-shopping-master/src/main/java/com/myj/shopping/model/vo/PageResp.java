/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mayujing
 * @version 1.0
 */
@Data
public class PageResp<T> implements Serializable {
    private List<T> list;
    //每页数量
    private Integer pageSize;
    //页数
    private Integer pageNum;
    //起始
    private Integer start;
    /**
     *返回
     */
    //总数量
    private Integer total;
    //总页数
    private Integer totalPage;

}
