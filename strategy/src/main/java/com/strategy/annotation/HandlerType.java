package com.strategy.annotation;

import com.strategy.enums.OrderType;

import java.lang.annotation.*;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 10:07 2019/2/2
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {

    OrderType value();

}