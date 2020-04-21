package com.strategy.component;

import com.strategy.annotation.HandlerType;
import com.strategy.enums.OrderType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: CipherCui
 * @Description: 处理器上下文，根据类型获取相应的处理器
 * @Date: Created in 10:07 2019/2/2
 */
@SuppressWarnings("unchecked")
@Component
public class OrderHandlerContext implements ApplicationContextAware {

    @Autowired
    ApplicationContext applicationContext;

    /**
     * key为PayWay，value为class
     */
    private static final Map<String, Class> handlerMap = new HashMap<>(8);

    public AbstractOrderHandelr getHandlerInstance(String payType) {
        Class clazz = handlerMap.get(payType);
        if (clazz == null) {
            throw new RuntimeException("暂不支持此支付方式" + payType);
        }
        return (AbstractOrderHandelr) applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 遍历带有PayTypeHandler注释的类
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(HandlerType.class);
        if (beans != null && beans.size() > 0) {
            for (Object serviceBean : beans.values()) {
                OrderType value = serviceBean.getClass().getAnnotation(HandlerType.class).value();
                Class<?> serviceBeanClass = serviceBean.getClass();
                String code = value.getCode();
                if (handlerMap.containsKey(code)) {
                    Class aClass = handlerMap.get(code);
                    if (serviceBeanClass != null && !serviceBeanClass.equals(aClass)) {
                        throw new RuntimeException("重复的加载的orderType" + code);
                    } else {
                        continue;
                    }
                }
                handlerMap.put(code, serviceBeanClass);
                //同类型异常校验
            }
        }
    }

}