package com.strategy;

import com.strategy.dto.OrderDto;
import com.strategy.enums.OrderType;
import com.strategy.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yulong
 * @create 2020/4/21
 */
@RunWith(SpringRunner.class)
@ComponentScan({"com.strategy"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Mytest {
    @Autowired
    OrderService orderServiceImpl;

    @Test
    public void test(){
        OrderDto orderDto = new OrderDto();
        orderDto.setType(OrderType.GROUP.getCode());
        String s = orderServiceImpl.handleOrder(orderDto);
        System.out.println("out:"+s);

    }

}
