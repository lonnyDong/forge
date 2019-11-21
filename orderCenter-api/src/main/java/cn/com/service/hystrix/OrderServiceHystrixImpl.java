package cn.com.service.hystrix;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.bean.Order;
import cn.com.service.OrderService;

@Component
public class OrderServiceHystrixImpl implements OrderService {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Override
	public Order getOrder(Long uid) {

		LOGGER.error("用户【{}】获取订单详情进入熔断", uid);
		Order order = new Order();
		return order;
	}

	@Override
	public String getUnknownApi() {
		LOGGER.error("getUnknownApi进入熔断");
		return "熔断返回getUnknownApi";
	}

	private Optional<Order> getOrderList(Long uid) {
		System.out.println("用户:" + uid + "获取订单列表");
		Order order = new Order();
		return Optional.of(order);
	}

}
