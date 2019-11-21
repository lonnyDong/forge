package cn.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yulong
 * @create 2019/10/9
 */

@EnableSwagger2
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ActuatorApplicatioin {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplicatioin.class, args);
    }

}
