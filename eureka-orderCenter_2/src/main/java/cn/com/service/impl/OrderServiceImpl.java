package cn.com.service.impl;

import java.math.BigDecimal;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import cn.com.bean.Order;
import io.swagger.annotations.ApiOperation;

@RestController
public class OrderServiceImpl {
	
//	@ApiOperation(value="获取订单", notes = "获取订单-有熔断")
//	@RequestMapping(value = "/getOrder", method = RequestMethod.GET)
//	public Order getOrder(@RequestParam(name = "uid") Long uid) {
//		Order order = new Order();
//		order.setId(RandomUtils.nextLong());
//		order.setPrice(new BigDecimal("222"));
//		order.setProductName("cup");
//		order.setUid(uid);
//		order.setRemark("第2个实例返回");
//		return order;
//	}

}
