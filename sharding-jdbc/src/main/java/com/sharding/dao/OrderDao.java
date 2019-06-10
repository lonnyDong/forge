package com.sharding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sharding.bean.Order;


@Mapper
public interface OrderDao {

	void saveOrder(Order Order);

	long updateOrder(Order Order);

	Order getOrderById(long order_id);

	List<Order> selectOrders();
	

}
