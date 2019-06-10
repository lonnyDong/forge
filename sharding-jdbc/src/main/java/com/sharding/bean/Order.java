package com.sharding.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 订单号-业务主键
	 */
	private Long orderId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品编号
	 */
	private Long productId;
	/**
	 * 订单金额
	 */
	private BigDecimal amount;

	/**
	 * 商品单价
	 */
	private BigDecimal price;
	/**
	 * 商品数量
	 */
	private int count;

	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 交易时间
	 */
	private Date tradeTime;

	private Date createTime;

	private Date updateTime;

}
