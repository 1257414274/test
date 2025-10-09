/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.service.impl;

import com.myj.shopping.dao.ActivityDao;
import com.myj.shopping.model.Activity;
import com.myj.shopping.model.vo.PageResp;
import com.myj.shopping.service.ActivityService;
import com.myj.shopping.utils.bean.CommonQueryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mayujing
 * @version 1.0
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public int addActivity(Activity activity) {
        return activityDao.insert(activity);
    }

    @Override
    public int delActivity(Activity activity) {
        if (activityDao.selectByPrimaryKey(activity.getId()).getDelFlag() == 0){
            activity.setDelFlag(1);
            return activityDao.updateByPrimaryKeySelective(activity);
        }
        return 0;
    }

    @Override
    public int modifyActivity(Activity activity) {
        if (activityDao.selectByPrimaryKey(activity.getId()).getDelFlag() == 0){
            return activityDao.updateByPrimaryKeySelective(activity);
        }
        return 0;
    }

    @Override
    public PageResp<Activity> queryActivityList(Activity activity, CommonQueryBean commonQueryBean) {
        if(commonQueryBean!=null && commonQueryBean.getPageNum()!=null && commonQueryBean.getPageSize()!=null){
            commonQueryBean.setStart((commonQueryBean.getPageNum()-1)*commonQueryBean.getPageSize());
        }
        List<Activity> activityResult = activityDao.list4Page(activity,commonQueryBean);
        //查询总条数
        int count = activityDao.count(activity);
        commonQueryBean.setTotal(count);
        commonQueryBean.setTotalPage(CommonQueryBean.calculateTotalPage(commonQueryBean));
        PageResp<Activity> pageResp = new PageResp<>();
        pageResp.setList(activityResult);
        pageResp.setPageNum(commonQueryBean.getPageNum());
        pageResp.setPageSize(commonQueryBean.getPageSize());
        pageResp.setTotalPage(commonQueryBean.getTotalPage());
        pageResp.setStart(commonQueryBean.getStart());
        pageResp.setTotal(commonQueryBean.getTotal());
        pageResp.setTotalPage(CommonQueryBean.calculateTotalPage(commonQueryBean));
        return pageResp;
    }
}
