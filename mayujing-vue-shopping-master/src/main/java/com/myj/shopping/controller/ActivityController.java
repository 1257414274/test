/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.controller;

import com.myj.shopping.model.Activity;
import com.myj.shopping.model.base.BaseResponse;
import com.myj.shopping.model.base.ErrorMessage;
import com.myj.shopping.model.http.ActivityAddReq;
import com.myj.shopping.model.http.ActivityDelReq;
import com.myj.shopping.model.http.ActivityPageReq;
import com.myj.shopping.model.http.ActivityUpdateReq;
import com.myj.shopping.model.vo.PageResp;
import com.myj.shopping.service.ActivityService;
import com.myj.shopping.utils.bean.CommonQueryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author mayujing
 * @version 1.0
 */
@RestController
@RequestMapping("/activity")
@Slf4j
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /*新增活动*/
    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    public BaseResponse addActivity(@Valid @RequestBody ActivityAddReq activityAddReq) {
        try {
            Activity activity = new Activity();
            BeanUtils.copyProperties(activityAddReq, activity);
            activityService.addActivity(activity);
        } catch (Exception e) {
            log.error("新增失败{}",e);
        }
        return BaseResponse.getOK();
    }

    // 活动删除
    @RequestMapping(value = "/delActivity", method = RequestMethod.POST)
    public BaseResponse delActivity(@Valid @RequestBody ActivityDelReq activityDelReq){
        try {
            Activity activity = new Activity();
            BeanUtils.copyProperties(activityDelReq,activity);
            if (activityService.delActivity(activity) == 0){
                return BaseResponse.error(ErrorMessage.ACTIVITY_DEL);
            }
        }catch(Exception e){
            log.error("活动删除发生异常：{}",e);
        }
        return BaseResponse.getOK();
    }

    // 活动修改
    @RequestMapping(value = "/modifyActivity", method = RequestMethod.POST)
    public BaseResponse modifyActivity(@Valid @RequestBody ActivityUpdateReq activityUpdateReq){
        try {
            log.info("活动信息修改：{}",activityUpdateReq);
            Activity activity = new Activity();
            BeanUtils.copyProperties(activityUpdateReq,activity);
            if (activityService.modifyActivity(activity) == 0){
                return BaseResponse.error(ErrorMessage.ACTIVITY_DEL);
            }
        }catch(Exception e){
            log.error("活动信息修改发生异常:{}",e);
        }
        return BaseResponse.getOK();
    }
    // 活动分页查询

    @RequestMapping(value = "/queryActivityList", method = RequestMethod.POST)
    public BaseResponse queryActivityList(@Valid @RequestBody ActivityPageReq activityPageReq){
        PageResp<Activity> pageResp = new PageResp<>();
        try {
            log.info("活动列表查询：{}", activityPageReq);
            Activity activity = new Activity();
            CommonQueryBean commonQueryBean = new CommonQueryBean();
            BeanUtils.copyProperties(activityPageReq,activity);
            BeanUtils.copyProperties(activityPageReq,commonQueryBean);
            pageResp = activityService.queryActivityList(activity, commonQueryBean);
        }catch(Exception e){
            log.error("活动列表查询发生异常：{}",e);
        }
        return BaseResponse.ok(pageResp);
    }
}
