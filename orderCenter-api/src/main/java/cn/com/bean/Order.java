package cn.com.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yulong
 * @create 2019/11/21
 */
@Data
public class Order {

    private Long id;
    private BigDecimal price;
    private String productName;
    private Long uid;
    private String remark;

}
