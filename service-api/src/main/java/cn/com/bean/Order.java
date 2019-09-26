package cn.com.bean;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Order {

	private Long id;
	private String orderId;
	private String productName;
	private BigDecimal price;
	private Long uid;
	private String remark;
	

}
