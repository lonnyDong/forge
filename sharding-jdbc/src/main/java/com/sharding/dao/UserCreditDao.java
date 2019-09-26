package com.sharding.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sharding.bean.UserCredit;

@Mapper
public interface UserCreditDao {

	long saveUserAsset(UserCredit userAsset);

	long updateUserAsset(UserCredit userAsset);

	UserCredit getUserAssetByUid(long uid);

}
