package event.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author yulong
 * @create 2020/4/22
 * 订单创建事件
 */
public class OrderCreateEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OrderCreateEvent(Object source) {
        super(source);
    }
}
