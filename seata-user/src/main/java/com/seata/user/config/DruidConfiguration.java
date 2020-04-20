package com.seata.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Druid数据源配置
 * 
 * @Description
 * @author 张国豪
 */
@Configuration
public class DruidConfiguration {

//	@Value("${spring.datasource.druid.user}")
//	private String druidUser;
//
//	@Value("${spring.datasource.druid.password}")
//	private String druidPassword;

	@Bean(destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DruidDataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		Properties properties = new Properties();
		properties.setProperty("config.decrypt","true");
		properties.setProperty("config.decrypt.key","MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANhJs3Xt0I8BAvaR24TgKV54Y2YxYp3etll+9enyeeokZ0RSumjlmJC2nqBhhRi1mOcHLYd0croBHI03xbWsu5ECAwEAAQ==");

		druidDataSource.setConnectProperties(properties);
		try {
			druidDataSource.setFilters("config");
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return druidDataSource;
	}


	/**
	 * 注册一个StatViewServlet
	 * 
	 * @return
	 */
//	@Bean
//	public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
//		ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(
//				new StatViewServlet(), "/druid/*");
//
//		servletRegistrationBean.addInitParameter("loginUsername", druidUser);
//		servletRegistrationBean.addInitParameter("loginPassword", druidPassword);
//		servletRegistrationBean.addInitParameter("resetEnable", "false");
//		return servletRegistrationBean;
//	}

	/**
	 * 注册一个：filterRegistrationBean
	 * 
	 * @return
	 */
//	@Bean
//	public FilterRegistrationBean<WebStatFilter> druidStatFilter() {
//
//		FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(
//				new WebStatFilter());
//
//		// 添加过滤规则.
//		filterRegistrationBean.addUrlPatterns("/*");
//
//		// 添加不需要忽略的格式信息.
//		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//		return filterRegistrationBean;
//	}
}
