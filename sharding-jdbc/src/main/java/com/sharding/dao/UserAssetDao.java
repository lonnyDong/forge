package com.sharding.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sharding.bean.User;
import com.sharding.bean.UserAsset;

@Mapper
public interface UserAssetDao {

	long saveUserAsset(UserAsset userAsset);

	long updateUserAsset(UserAsset userAsset);

	UserAsset getUserAssetByUid(long uid);

}
