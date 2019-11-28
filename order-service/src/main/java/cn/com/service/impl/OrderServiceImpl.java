package cn.com.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import cn.com.bean.Order;
import io.swagger.annotations.ApiOperation;

/**
 * @author
 */
@RestController
public class OrderServiceImpl {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "获取订单", notes = "获取订单-有熔断")
    @RequestMapping(value = "/getOrder", method = RequestMethod.GET)
    public Order getOrder(@RequestParam(name = "uid") Long uid) {
        if(1==uid%2){
            System.out.println(1/0);
        }

        LOGGER.info("获取订单:");
        Order order = new Order();
        order.setId(RandomUtils.nextLong());
        order.setPrice(new BigDecimal("20"));
        order.setProductName("book");
        order.setUid(uid);
        order.setRemark("恭喜，获取订单成功");
        return order;
    }

    @ApiOperation(value = "获取订单列表", notes = "获取订单-有熔断")
    @GetMapping("/getProductList")
    public String getProductList() {
        Order order = new Order();
        order.setId(1L);
        Order order1 = new Order();
        order1.setId(1L);
        try {
           // Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.asList(order,order1).toString();
    }

}
