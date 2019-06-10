package com.sharding.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sharding.bean.User;
import com.sharding.dao.UserDao;

@RestController
@RequestMapping("/user")
public class UserServiceImpl implements UserService{

	@Resource
	UserDao userDao;
	
	
	
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
		
	}
	
	
	@Override
	@GetMapping("/get")
	public User getUserById(@RequestParam("id") Long id) {
		User user = userDao.getUserById(id);
		return user;
	}

	
}
