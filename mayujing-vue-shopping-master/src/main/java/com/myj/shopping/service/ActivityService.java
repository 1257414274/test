/*
 * 英才汇硕信息科技有限公司 拥有本软件版权 2021 并保留所有权利。
 * Copyright 2021, YCHS Information&Science Techology Co.,Ltd,
 * All right reserved.
 */
package com.myj.shopping.service;

import com.myj.shopping.model.Activity;
import com.myj.shopping.model.vo.PageResp;
import com.myj.shopping.utils.bean.CommonQueryBean;

/**
 * @author mayujing
 * @version 1.0
 */
public interface ActivityService {
    int addActivity(Activity activity);

    int delActivity(Activity activity);

    int modifyActivity(Activity activity);

    PageResp<Activity> queryActivityList(Activity activity, CommonQueryBean commonQueryBean);
}
