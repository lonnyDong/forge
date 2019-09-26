package com.sharding.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharding.bean.Order;
import com.sharding.dao.OrderDao;
import com.sharding.utils.IdWorker;

@RestController
@RequestMapping("/sharing")
public class OrderServiceImpl implements OrderService {

	@Resource
	OrderDao orderDao;

	@Override
	@GetMapping("/order/save")
	public void saveOrder() {
			int a = new java.util.Random().nextInt(10);
			Long id = IdWorker.getWorkID()+a;
			System.out.println("id:" + id + " 求余： " + id % 4);
			Order build = Order.builder().amount(new BigDecimal("60.00")).count(5).price(new BigDecimal("12"))
					.orderId(id).productId(new Long(new java.util.Random().nextInt(99999))).productName("book")
					.createTime(new Date()).updateTime(new Date()).tradeTime(new Date()).remark("mark").id(1L).build();

			orderDao.saveOrder(build);


	}

	@Override
	@GetMapping("/order/list")
	public List<Order> getList() {
		List<Order> list = orderDao.selectOrders();
		return list;
	}


	@Override
	public Order getOrderByOrderId(Long orderId) {
		Order orderById = orderDao.getOrderById(orderId);
		return orderById;
	}
}
