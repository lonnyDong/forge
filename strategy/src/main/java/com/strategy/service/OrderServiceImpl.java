package com.strategy.service;

import com.strategy.component.AbstractOrderHandelr;
import com.strategy.component.OrderHandlerContext;
import com.strategy.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yulong
 * @create 2020/4/20
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderHandlerContext orderHandlerContext;

    @Override
    public String handleOrder(OrderDto orderDto) {

        AbstractOrderHandelr handler = orderHandlerContext.getHandlerInstance(orderDto.getType());

        String res =  handler.handle(orderDto);

        return res;
    }
}
