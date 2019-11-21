package cn.com.web;

import cn.com.service.AccountService;
import cn.com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yulong
 * @create 2019/9/27
 */
@RestController
public class FeignController {

    @Autowired
    AccountService accountService;
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/hello")
    public String hello() {
        String bankInfo = accountService.getBankInfo();
        return bankInfo;
    }

    @GetMapping(value = "/hello2")
    public String hello2() {
        String bankInfo = accountService.getBankInfo("utf-8", "6216665000001788266");
        return bankInfo;
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

    @PostMapping(value = "/order/productList")
    public String productList() {
        String orderDetail = orderService.productList();
        return "list" + orderDetail;
    }

}
