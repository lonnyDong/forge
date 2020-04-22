package event.listeners;

import event.events.OrderCreateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author yulong
 * @create 2020/4/22
 */
@Component
public class OrderSmsListener implements ApplicationListener<OrderCreateEvent> {

    @Async //异步调用
    @Override
    public void onApplicationEvent(OrderCreateEvent event) {

        System.out.println("订单创建 发送短信");
        System.out.println(1/0);
        System.out.println("订单创建 发送短信完成");
    }
}
