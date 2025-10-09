package com.myj.shopping.model;

import java.util.Date;


/**
 * 
 * 
 * 
 **/
public class User{


  /****/

  private Integer id;


  /****/

  private String userName;


  /****/

  private String password;


  /**商户id，管理员可空**/

  private Integer storeId;


  /****/

  private Date createTime;


  /****/

  private Date updateTime;


  /****/

  private Integer delFlag;




  public void setId(Integer id) { 
    this.id = id;
  }


  public Integer getId() { 
    return this.id;
  }


  public void setUserName(String userName) { 
    this.userName = userName;
  }


  public String getUserName() { 
    return this.userName;
  }


  public void setPassword(String password) { 
    this.password = password;
  }


  public String getPassword() { 
    return this.password;
  }


  public void setStoreId(Integer storeId) { 
    this.storeId = storeId;
  }


  public Integer getStoreId() { 
    return this.storeId;
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
