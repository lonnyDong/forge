package cn.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2 
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderServiceApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
    
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("cn.com.service"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("订单服务")
				.description("订单服务")
				.termsOfServiceUrl("http://blog.didispace.com/")
				.contact(new Contact("Lonny", "", "springfor@163.com"))
				.version("1.0")
				.build();
	}
}