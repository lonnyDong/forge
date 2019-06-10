package com.sharding.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.sharding.bean.User;
import com.sharding.service.UserService;
@RunWith(SpringRunner.class)
@ComponentScan({ "com.sharding" })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserTest {

	@Autowired
	UserService userServiceImpl;

	@Test
	public void getUser() {

		User userById = userServiceImpl.getUserById(66251L);
		System.out.println("user:" + userById);

	}
}
