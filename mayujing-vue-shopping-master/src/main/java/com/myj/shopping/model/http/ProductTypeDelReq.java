package com.myj.shopping.model.http;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeDelReq implements Serializable {
    @NotNull(message = "商品类型ID 不能为空")
    private Integer id;
}