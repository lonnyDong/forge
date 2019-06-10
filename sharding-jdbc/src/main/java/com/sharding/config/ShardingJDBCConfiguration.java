package com.sharding.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ShardingJDBCConfiguration {

	@Resource
	private DataSource dataSource;

	/**
	 * 设置数据源为sharding jdbc
	 * @return
	 */
//	@Bean
//	public SqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
//		SqlSessionFactoryBean sqlSessionFaction = new SqlSessionFactoryBean();
//		sqlSessionFaction.setDataSource(dataSource);
//		return sqlSessionFaction;
//	}

}