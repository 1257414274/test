package com.myj.shopping.model.http;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypePageReq implements Serializable {
    //商品类型名称
    private String productTypeName;
    //每页数量
    @NotNull(message = "每页数量 不能为空")
    private Integer pageSize;
    //页数
    @NotNull(message = "页数 不能为空")
    private Integer pageNum;
}