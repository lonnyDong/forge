package com.seata.user.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yulong
 * @create 2020/3/27
 */
@Data
public class SeataUser implements Serializable {
    private int id ;
    private String name ;
    private String age ;
    private String phone ;
    private String address;


}
