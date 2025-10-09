package com.myj.shopping.dao;

import java.util.List;
import com.myj.shopping.model.User;

import com.myj.shopping.model.http.UserReq;
import com.myj.shopping.utils.bean.CommonQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * User数据库操作接口类
 * 
 **/

@Repository
public interface UserDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	User  selectByPrimaryKey ( @Param("id") Integer id );

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
	int insert( User record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( User record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<User> list4Page ( User record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	int count ( User record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<User> list ( User record);

	User findUserByName(UserReq userReq);
}