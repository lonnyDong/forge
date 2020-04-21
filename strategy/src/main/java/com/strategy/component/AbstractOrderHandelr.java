package com.strategy.component;

import com.strategy.dto.OrderDto;

/**
 * @author yulong
 * @create 2020/4/20
 */
public abstract  class AbstractOrderHandelr {

    public abstract String handle(OrderDto orderDto);



}
