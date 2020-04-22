package event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author yulong
 * @create 2020/4/20
 */
@SpringBootApplication
@EnableAsync
public class EventDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(EventDemoApplication.class, args);
    }


}
