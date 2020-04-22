package event.events;

import event.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yulong
 * @create 2020/4/21
 */
@RunWith(SpringRunner.class)
@ComponentScan({"event.events"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Mytest {

    @Resource
    private OrderService orderServiceImpl;

    @Test
    public void test(){
        orderServiceImpl.createOrder();
        System.out.println("out:");


    }

}
