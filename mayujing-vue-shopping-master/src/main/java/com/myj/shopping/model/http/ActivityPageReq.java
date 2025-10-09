/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.model.http;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mayujing
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityPageReq implements Serializable {
    //活动名称
    private String activityName;
    //活动开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date activityStartTime;
    //活动结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date activityEndTime;
    // 每页数量
    private Integer pageSize;
    // 页数
    private Integer pageNum;
}
