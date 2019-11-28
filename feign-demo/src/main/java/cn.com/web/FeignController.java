package cn.com.web;

import cn.com.service.AccountService;
import cn.com.service.OrderService;
import cn.com.service.PayService;
import cn.com.service.ReceivableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yulong
 * @create 2019/9/27
 */
@RestController
public class FeignController {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    AccountService accountService;
    @Resource
    OrderService orderService;
    @Autowired
    PayService payService;

    @Resource
    ReceivableService receivableService;

    /**
     * 阿里测试接口
     * @return
     */
    @GetMapping(value = "/getBankInfo")
    public String hello() {
        String bankInfo = accountService.getBankInfo();
        return bankInfo;
    }

    @GetMapping(value = "/getBankInfo2")
    public String hello2() {
        String bankInfo = accountService.getBankInfo("utf-8", "6216665000001788266");
        return bankInfo;
    }


    /**
     * 德方测试接口
     * @return
     */
    @PostMapping(value = "/receivable/user/login")
    public String receivableLogin() {
        LOGGER.info("receivable login ...");

        Map<String, Object> map = new HashMap<>();
        map.put("username","user1");
        map.put("password","c7c4a8d09ca3762af61e59520943dc26494f8941b");
        map.put("code","xxx");
        map.put("codeKey","xxx");

        String loginRes = receivableService.userLogin(map);
        return loginRes;
    }



    @PostMapping(value = "/order/create")
    public String create(@RequestBody Map<String, Object> HashMap) {

        String create = orderService.create(HashMap);
        return "feignDemo create:" + create;
    }


    @PostMapping(value = "/order/detail")
    public String detail(@RequestParam(name = "orderId") Long orderId) {

        String orderDetail = orderService.getOrderDetail(orderId);
        return "feignDemo orderDetail:" + orderDetail;
    }

    @GetMapping(value = "/order/getOrder")
    public String getOrder(@RequestParam(name="uid")Long uid) {
        String s = orderService.productGetOrder(uid);
        return "list" + s;
    }

    @GetMapping(value = "/order/getProductList")
    public String getProductList() {
        String s = orderService.getProductList();
        return  s;
    }



}
