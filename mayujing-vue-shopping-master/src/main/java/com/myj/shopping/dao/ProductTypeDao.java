package com.myj.shopping.dao;

import java.util.List;
import com.myj.shopping.model.ProductType;

import com.myj.shopping.utils.bean.CommonQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * ProductType数据库操作接口类
 * 
 **/

@Repository
public interface ProductTypeDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	ProductType  selectByPrimaryKey ( @Param("id") Integer id );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Integer id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( ProductType record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( ProductType record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<ProductType> list4Page ( ProductType record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	int count ( ProductType record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<ProductType> list ( ProductType record);

}