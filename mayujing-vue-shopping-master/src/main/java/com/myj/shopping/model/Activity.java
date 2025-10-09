package com.myj.shopping.model;

import java.util.Date;


/**
 * 
 * 
 * 
 **/
public class Activity{


  /****/

  private Integer id;


  /**活动名称**/

  private String activityName;


  /**活动开始时间**/

  private Date activityStartTime;


  /**活动结束时间**/

  private Date activityEndTime;


  /**创建时间**/

  private Date createTime;


  /**更新时间**/

  private Date updateTime;


  /**是否删除**/

  private Integer delFlag;




  public void setId(Integer id) { 
    this.id = id;
  }


  public Integer getId() { 
    return this.id;
  }


  public void setActivityName(String activityName) { 
    this.activityName = activityName;
  }


  public String getActivityName() { 
    return this.activityName;
  }


  public void setActivityStartTime(Date activityStartTime) { 
    this.activityStartTime = activityStartTime;
  }


  public Date getActivityStartTime() { 
    return this.activityStartTime;
  }


  public void setActivityEndTime(Date activityEndTime) { 
    this.activityEndTime = activityEndTime;
  }


  public Date getActivityEndTime() { 
    return this.activityEndTime;
  }


  public void setCreateTime(Date createTime) { 
    this.createTime = createTime;
  }


  public Date getCreateTime() { 
    return this.createTime;
  }


  public void setUpdateTime(Date updateTime) { 
    this.updateTime = updateTime;
  }


  public Date getUpdateTime() { 
    return this.updateTime;
  }


  public void setDelFlag(Integer delFlag) { 
    this.delFlag = delFlag;
  }


  public Integer getDelFlag() { 
    return this.delFlag;
  }

}
