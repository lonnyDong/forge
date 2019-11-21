package cn.com.service;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yulong
 * @create 2019/11/21
 */
@Service
public class OrderServiceHystrixImpl implements OrderService {


    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String create(@RequestBody Map<String, Object> HashMap) {

        LOGGER.error("创建订单失败进入熔断,参数：{}", JSONObject.toJSONString(HashMap));
        return "系统暂时不提供服务";
    }

    @Override
    public String getOrderDetail(@RequestParam(name = "orderId") Long orderId) {
        LOGGER.error("获取订单详情进入熔断,参数：{}", JSONObject.toJSONString(orderId));
        return "系统暂时不提供服务";
    }

    @Override
    public String productList() {
        LOGGER.error("获取产品列表详情进入熔断,返回缓存数据");

        return "缓存订单列表：1，2，3，4....";
    }


}
