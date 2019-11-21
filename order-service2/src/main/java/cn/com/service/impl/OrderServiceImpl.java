package cn.com.service.impl;

import cn.com.bean.Order;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class OrderServiceImpl {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ApiOperation(value="获取订单", notes = "获取订单-有熔断")
	@RequestMapping(value = "/getOrder", method = RequestMethod.GET)
	public Order getOrder(@RequestParam(name = "uid") Long uid) {
		Order order = new Order();
		order.setId(RandomUtils.nextLong());
		order.setPrice(new BigDecimal("222"));
		order.setProductName("cup");
		order.setUid(uid);
		order.setRemark("第2个实例返回");
		return order;
	}

	@ApiOperation(value="创建订单", notes = "获取订单-有熔断")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String  create(@RequestBody Map<String,Object> HashMap) {
		LOGGER.info("create order: {}", JSONObject.toJSONString(HashMap));
		return "create order success";
	}

	@ApiOperation(value="获取订单详情", notes = "获取订单-有熔断")
	@PostMapping("/detail")
	public String  getOrderDetail(@RequestParam(name = "orderId") Long orderId) {
		LOGGER.info("detail: {}", orderId);
		return "return order detail";
	}

}
