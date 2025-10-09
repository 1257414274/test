package com.myj.shopping.model;

import java.util.Date;


/**
 * 
 * 
 * 
 **/
public class ProductType{


  /****/

  private Integer id;


  /**商品类型名称**/

  private String productTypeName;


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


  public void setProductTypeName(String productTypeName) { 
    this.productTypeName = productTypeName;
  }


  public String getProductTypeName() { 
    return this.productTypeName;
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
