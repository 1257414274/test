/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.model.http;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mayujing
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityAddReq implements Serializable {
    //活动名称
    @NotBlank(message = "活动名称 不能为空")
    private String activityName;
    //活动开始时间
    @NotNull(message = "活动开始时间 不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//时间格式
    private Date activityStartTime;
    //活动结束时间
    @NotNull(message = "活动结束时间 不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//时间格式
    private Date activityEndTime;
}