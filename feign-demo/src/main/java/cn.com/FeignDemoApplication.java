package cn.com;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import feign.Logger;
import feign.Retryer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableHystrix
@EnableCircuitBreaker
@EnableSwagger2
@EnableFeignClients
//@EnableEurekaClient
@SpringBootApplication
@EnableHystrixDashboard
public class FeignDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignDemoApplication.class, args);
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.com.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("feignDemo")
                .description("feignDemo")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact(new Contact("Lonny", "", "springfor@163.com"))
                .version("1.0")
                .build();
    }

    @Bean
//	@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

//    @Bean
//    Retryer feignRetryer() {
//        return new Retryer.Default(10, 50, 2);
//    }


    @Bean
    public ServletRegistrationBean ServletRegistrationBeangetServlet() {

        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

        registrationBean.setLoadOnStartup(1);

        registrationBean.addUrlMappings("/hystrix.stream");

        registrationBean.setName("HystrixMetricsStreamServlet");

        return registrationBean;

    }


}