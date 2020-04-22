package event.listeners;

import event.events.OrderCreateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yulong
 * @create 2020/4/22
 */
@Component
public class OrderEmailListener implements ApplicationListener<OrderCreateEvent> {


    @Override
    public void onApplicationEvent(OrderCreateEvent event) {

        System.out.println("订单创建 发送邮件");

    }
}
