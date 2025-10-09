package com.myj.shopping.model.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeAddReq implements Serializable {
    //商品类型名称
    @NotBlank(message = "商品类型名称 不能为空")
    private String productTypeName;
}