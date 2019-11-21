package cn.com.service;

import feign.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.bean.Order;
import cn.com.service.hystrix.OrderServiceHystrixImpl;

@FeignClient(value = "order-center",fallback=OrderServiceHystrixImpl.class)
public interface OrderService {

	@GetMapping("/getOrder")
	Order getOrder(@RequestParam(name = "uid") Long uid);

	@GetMapping("/getUnknownApi")
	String getUnknownApi();

}
