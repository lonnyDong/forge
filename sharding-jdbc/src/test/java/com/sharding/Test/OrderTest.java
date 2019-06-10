package com.sharding.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.sharding.bean.Order;
import com.sharding.bean.User;
import com.sharding.service.OrderService;
@RunWith(SpringRunner.class)
@ComponentScan({ "com.sharding" })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrderTest {

	@Autowired
	OrderService orderServiceImpl;

	@Test
	public void getOrder() {

		Order orderByOrderId = orderServiceImpl.getOrderByOrderId(654901758245511168L);
		System.out.println(orderByOrderId);

	}
}
