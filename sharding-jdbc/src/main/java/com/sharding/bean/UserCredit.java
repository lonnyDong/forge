package com.sharding.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户征信信息
 * 
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredit {

	private Long id;

	private Long uid;

	/**
	 * 总授信金额
	 */
	private String creditAmount;

	/**
	 * 总贷款金额
	 */
	private String loanAmount;

	/**
	 * 备注
	 */
	private String remark;

	private Date createTime;

	private Date updateTime;

}
