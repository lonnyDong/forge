package event.service;

import event.events.OrderCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author yulong
 * @create 2020/4/22
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void createOrder() {
        //1.创建订单
        System.out.println("订单创建成功");
        //2.发布事件

        OrderCreateEvent orderCreateEvent = new OrderCreateEvent(this);
        applicationContext.publishEvent(orderCreateEvent);//ApplicationContext是我们的事件容器上层，我们发布事件，也可以通过此容器完成发布
        //applicationEventPublisher.publishEvent(orderCreateEvent);//也可以

    }



    @EventListener(OrderCreateEvent.class)
    public void sendSms() {

        System.out.println("订单创建...注解短信");
    }
}
