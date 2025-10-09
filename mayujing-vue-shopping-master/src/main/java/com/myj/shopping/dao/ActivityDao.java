package com.myj.shopping.dao;

import java.util.List;
import com.myj.shopping.model.Activity;

import com.myj.shopping.utils.bean.CommonQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * Activity数据库操作接口类
 * 
 **/

@Repository
public interface ActivityDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Activity  selectByPrimaryKey ( @Param("id") Integer id );

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
	int insert( Activity record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Activity record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Activity> list4Page ( Activity record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	int count ( Activity record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Activity> list ( Activity record);

}