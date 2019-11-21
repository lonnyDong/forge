package cn.com.bean;

/**
 * @author yulong
 * @create 2019/9/30
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class Member implements Serializable {

    /***
     * 会员号：
     */
    private String no;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * age
     */
    private String age;



}
