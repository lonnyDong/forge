package cn.com.service.hystrix;

import java.util.Optional;

import org.springframework.stereotype.Component;

import cn.com.bean.Order;
import cn.com.service.OrderService;

@Component
public class OrderServiceHystrixImpl implements OrderService {

	@Override
	public Order getOrder(Long uid) {
		System.out.println("用户:" + uid + "获取订单详情进入熔断");
		Order order = new Order();
		return order;
	}

	private Optional<Order> getOrderList(Long uid) {
		System.out.println("用户:" + uid + "获取订单列表");
		Order order = new Order();
		return Optional.of(order);
	}

}
