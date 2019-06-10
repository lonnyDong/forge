package com.sharding.service;

import java.util.List;

import com.sharding.bean.Order;

public interface OrderService {

	void saveOrder();

	List<Order> getList();
	
    Order getOrderByOrderId(Long orderId);
}
