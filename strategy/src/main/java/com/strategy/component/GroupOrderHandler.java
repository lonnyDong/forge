package com.strategy.component;

import com.strategy.annotation.HandlerType;
import com.strategy.dto.OrderDto;
import com.strategy.enums.OrderType;
import org.springframework.stereotype.Component;

/**
 * @author yulong
 * @create 2020/4/20
 */
@Component
@HandlerType(OrderType.GROUP)
public class GroupOrderHandler extends  AbstractOrderHandelr{


    @Override
    public String handle(OrderDto orderDto) {
        return "GROUP";
    }
}
