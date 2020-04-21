package com.strategy.service;

import com.strategy.dto.OrderDto;

/**
 * @author yulong
 * @create 2020/4/20
 */
public interface OrderService {

    String handleOrder(OrderDto orderDto);
}
