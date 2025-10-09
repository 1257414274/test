/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.service;

import com.myj.shopping.model.ProductType;
import com.myj.shopping.model.vo.PageResp;
import com.myj.shopping.utils.bean.CommonQueryBean;

/**
 * @author mayujing
 * @version 1.0
 */
public interface ProductTypeService {
    /**
     * 商品类型新增
     * @return
     */
    int insertProductType(ProductType productType);

    int delProductType(ProductType productType);

    int modifyProductType(ProductType productType);

    PageResp<ProductType> queryProductTypeList(ProductType productType, CommonQueryBean commonQueryBean);
}
