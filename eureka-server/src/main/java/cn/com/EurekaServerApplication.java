package cn.com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * eurka 注册中心 
 * @author yulong
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
 
}