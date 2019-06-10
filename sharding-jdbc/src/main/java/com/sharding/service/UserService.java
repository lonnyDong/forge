package com.sharding.service;

import com.sharding.bean.User;

public interface UserService {
	void saveUser();

	User getUserById(Long id);
	
}
