package cn.com.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.bean.Order;
import cn.com.bean.User;
import cn.com.service.OrderService;
import cn.com.service.UserTestService;
import cn.com.utils.UniqueCodeUtils;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserTestController {

	@Autowired
	UserTestService userTestServiceImpl;

	@Resource
	private OrderService orderServiceImpl;

	@ApiOperation(value = "增加用户", notes = "")
	@PutMapping(value = "/info")
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

	@ApiOperation(value = "获取用户信息")
	@GetMapping(value = "/info")
	public User getUser() {
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
		return user;
	}

	@ApiOperation(value = "获取订单", notes = "获取订单-有熔断")
	@GetMapping(value = "/order/detail")
	public Order getOrder() {
		return orderServiceImpl.getOrder(1L);
	}

	@ApiOperation(value = "测试没有实现的api ", notes = "测试没有实现的api")
	@GetMapping(value = "/unknownApi")
	public String getUnknownApi() {
		return orderServiceImpl.getUnknownApi();
	}



}
