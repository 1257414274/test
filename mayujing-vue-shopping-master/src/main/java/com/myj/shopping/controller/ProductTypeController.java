/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.controller;


import com.myj.shopping.model.ProductType;
import com.myj.shopping.model.base.BaseResponse;
import com.myj.shopping.model.base.ErrorMessage;
import com.myj.shopping.model.http.ProductTypeAddReq;
import com.myj.shopping.model.http.ProductTypeDelReq;
import com.myj.shopping.model.http.ProductTypePageReq;
import com.myj.shopping.model.http.ProductTypeUpdateReq;
import com.myj.shopping.model.vo.PageResp;
import com.myj.shopping.service.ProductTypeService;
import com.myj.shopping.utils.bean.CommonQueryBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mayujing
 * @version 1.0
 */
@RestController
@RequestMapping("/productType")
@Slf4j
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    //商品类型新增
    @RequestMapping(value = "/addProductType", method = RequestMethod.POST)
    public BaseResponse addProductType(@Valid @RequestBody ProductTypeAddReq productTypeAddReq) {
        log.info("商品类型新增:{}", productTypeAddReq);
        try {
            ProductType productType = new ProductType();
            BeanUtils.copyProperties(productTypeAddReq, productType);
            productTypeService.insertProductType(productType);
        } catch (Exception e) {
            log.error("商品类型新增发生异常：{}", e);
        }
        return BaseResponse.getOK();
    }

    //商品类型删除
    @RequestMapping(value = "/delProductType", method = RequestMethod.POST)
    public BaseResponse delProductType(@Valid @RequestBody ProductTypeDelReq productTypeDelReq) {
        log.info("商品类型删除：{}", productTypeDelReq);
        try {
            ProductType productType = new ProductType();
            BeanUtils.copyProperties(productTypeDelReq, productType);
            if (productTypeService.delProductType(productType) == 0) {
                return BaseResponse.error(ErrorMessage.PRODUCTTYPE_DEL);
            }
        } catch (Exception e) {
            log.error("商品类型删除发生异常：{}", e);
        }
        return BaseResponse.getOK();
    }

    //商品类型修改
    @RequestMapping(value = "/modifyProductType", method = RequestMethod.POST)
    public BaseResponse modifyProductType(@Valid @RequestBody ProductTypeUpdateReq productTypeUpdateReq) {
        log.info("商品类型修改：{}", productTypeUpdateReq);
        try {
            ProductType productType = new ProductType();
            BeanUtils.copyProperties(productTypeUpdateReq, productType);
            if (productTypeService.modifyProductType(productType) == 0) {
                return BaseResponse.error(ErrorMessage.PRODUCTTYPE_DEL);
            }
        } catch (Exception e) {
            log.error("商品类型修改发生异常:{}", e);
        }
        return BaseResponse.getOK();
    }

    //商品类型分页查询
    @RequestMapping(value = "/queryProductTypeList", method = RequestMethod.POST)
    public BaseResponse queryProductTypeList(@Valid @RequestBody ProductTypePageReq productTypePageReq) {
        PageResp<ProductType> productTypePageResp = new PageResp<>();
        log.info("商品类型列表查询：{}" + productTypePageReq);
        try {
            ProductType productType = new ProductType();
            CommonQueryBean commonQueryBean = new CommonQueryBean();
            BeanUtils.copyProperties(productTypePageReq, productType);
            BeanUtils.copyProperties(productTypePageReq, commonQueryBean);
            productTypePageResp = productTypeService.queryProductTypeList(productType, commonQueryBean);
        } catch (Exception e) {
            log.error("商品类型列表查询发生异常：{}", e);
        }
        return BaseResponse.ok(productTypePageResp);
    }
}
