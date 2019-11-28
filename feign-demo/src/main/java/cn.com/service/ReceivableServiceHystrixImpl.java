package cn.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author yulong
 * @create 2019/11/26
 * 德方应收账款接口
 * 熔断处理类
 */


@Component
public class ReceivableServiceHystrixImpl implements ReceivableService {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String userLogin(Map<String, Object> HashMap) {
        LOGGER.info("调用德方登陆接口进入熔断....");
        return "对不起，第三方服务繁忙,请稍后重新登陆";
    }
}
