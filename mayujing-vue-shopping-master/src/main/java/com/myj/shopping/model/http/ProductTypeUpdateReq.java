package com.myj.shopping.model.http;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeUpdateReq implements Serializable {
    @NotNull(message = "商品类型ID 不能为空")
    private Integer id;
    //商品类型名称
    @NotBlank(message = "商品类型名称 不能为空")
    private String productTypeName;
}