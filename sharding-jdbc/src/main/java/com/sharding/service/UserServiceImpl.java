package com.sharding.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sharding.bean.User;
import com.sharding.bean.UserAsset;
import com.sharding.dao.UserAssetDao;
import com.sharding.dao.UserCreditDao;
import com.sharding.dao.UserDao;

@RestController
@RequestMapping("/user")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;

	@Resource
	UserAssetDao userAssetDao;

	@Override
	@GetMapping("/save")
	public void saveUser() {
		User user = new User();
		user.setCreateTime(new Date());
		user.setEmail("email");
		user.setIdNo("idNo");
		user.setName("name");
		user.setPassword("password");
		user.setPhone("phone");
		user.setRemark("remark");
		user.setStatus("status");
		user.setTradepwd("tradepwd");
		user.setUpdateTime(new Date());
		user.setUsername("username");
		userDao.saveUser(user);
		System.out.println("saveUser:" + user.getId());

		UserAsset userAsset = new UserAsset();
		userAsset.setCreateTime(new Date());
		userAsset.setQuantityOfCar(2);
		userAsset.setQuantityOfRealEstate(2);
		userAsset.setUid(user.getId());
		userAsset.setUpdateTime(new Date());
		long saveUserAsset = userAssetDao.saveUserAsset(userAsset);
		System.out.println("saveUserAsset:" + saveUserAsset);

	}

	@Override
	@GetMapping("/get")
	public User getUserById(@RequestParam("id") Long id) {
		User user = userDao.getUserById(id);
		return user;
	}

}
