package com.sharding.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sharding.bean.User;
@Mapper
public interface UserDao {

	long saveUser(User user);

	long updateUser(User user);

	User getUserById(long uid);

}
