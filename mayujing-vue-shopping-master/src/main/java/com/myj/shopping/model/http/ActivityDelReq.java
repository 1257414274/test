/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.model.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author mayujing
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDelReq implements Serializable {
    @NotNull(message = "活动ID 不能为空")
    private Integer id;
}
