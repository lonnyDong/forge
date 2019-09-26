package com.sharding.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAsset {

	private Long id;

	private Long uid;
	/**
	 * 持有房产数量
	 */
	private int quantityOfRealEstate;

	/**
	 * 持有小汽车数量
	 */
	private int quantityOfCar;
	/**
	 * 备注
	 */
	private String remark;

	private Date createTime;

	private Date updateTime;

}
