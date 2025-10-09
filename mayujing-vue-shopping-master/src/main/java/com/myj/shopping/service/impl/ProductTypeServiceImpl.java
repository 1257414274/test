/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.service.impl;

import com.myj.shopping.dao.ProductTypeDao;
import com.myj.shopping.model.ProductType;
import com.myj.shopping.model.vo.PageResp;
import com.myj.shopping.service.ProductTypeService;
import com.myj.shopping.utils.bean.CommonQueryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayujing
 * @version 1.0
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public int insertProductType(ProductType productType) {
        return productTypeDao.insert(productType);
    }

    @Override
    public int delProductType(ProductType productType) {
        if (productTypeDao.selectByPrimaryKey(productType.getId()).getDelFlag() == 0) {
            productType.setDelFlag(1);
            return productTypeDao.updateByPrimaryKeySelective(productType);
        }
        return 0;

    }

    @Override
    public int modifyProductType(ProductType productType) {
        if (productTypeDao.selectByPrimaryKey(productType.getId()).getDelFlag() == 0) {
            return productTypeDao.updateByPrimaryKeySelective(productType);
        }
        return 0;
    }

    @Override
    public PageResp<ProductType> queryProductTypeList(ProductType productType, CommonQueryBean commonQueryBean) {
        if(commonQueryBean!=null && commonQueryBean.getPageNum()!=null && commonQueryBean.getPageSize()!=null){
            commonQueryBean.setStart((commonQueryBean.getPageNum()-1)*commonQueryBean.getPageSize());
        }
        List<ProductType> productTypeResult = productTypeDao.list4Page(productType,commonQueryBean);
        //查询总条数
        int count = productTypeDao.count(productType);
        commonQueryBean.setTotal(count);
        commonQueryBean.setTotalPage(CommonQueryBean.calculateTotalPage(commonQueryBean));
        PageResp<ProductType> productTypePageResp = new PageResp<>();
        productTypePageResp.setList(productTypeResult);
        productTypePageResp.setPageNum(commonQueryBean.getPageNum());
        productTypePageResp.setPageSize(commonQueryBean.getPageSize());
        productTypePageResp.setTotalPage(commonQueryBean.getTotalPage());
        productTypePageResp.setStart(commonQueryBean.getStart());
        productTypePageResp.setTotal(commonQueryBean.getTotal());
        return productTypePageResp;
    }
}
