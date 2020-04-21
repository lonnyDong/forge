package com.strategy.enums;

/**
 * @author yulong
 * @create 2020/4/20
 */
public enum OrderType {

    /**
     * 普通订单
     */
    NORMAL("1"),

    /**
     * 团购订单
     */
    GROUP("2"),

    /**
     * 促销订单
     */
    SALES("3"),
    ;

    private String code;

    OrderType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
