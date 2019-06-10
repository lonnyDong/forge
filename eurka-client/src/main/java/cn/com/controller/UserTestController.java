package cn.com.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.bean.User;
import cn.com.service.UserTestService;
import cn.com.utils.UniqueCodeUtils;

@RestController
public class UserTestController {

	@Autowired
	UserTestService userTestServiceImpl;

	@GetMapping(value = "/add")
	public void adduser() {
		User user = new User();
		user.setCreateTime(new Date());
		user.setEmail(UniqueCodeUtils.genSimplePWD() + "@ww.com");
		user.setIdNo(UUID.randomUUID().toString());
		user.setName("aaa" + UniqueCodeUtils.genUniqueID(9));
		user.setPassword(UniqueCodeUtils.genPWD());
		user.setPhone("17233" + UniqueCodeUtils.genSimplePWD());
		user.setRemark("remark");
		user.setStatus("status");
		user.setTradepwd(UniqueCodeUtils.genDifficultPWD());
		user.setUpdateTime(new Date());
		user.setUsername("name");
		userTestServiceImpl.addUser(user);
	}

}
