package cn.com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yulong
 * 将外部提供的接口文档 映射成本地接口
 *
 */
@FeignClient(name="orderServiceNo",url = "localhost:8583",fallback =OrderServiceHystrixImpl.class)
public interface OrderService {


    @PostMapping("/create")
    String  create(@RequestBody Map<String,Object> HashMap) ;


    @PostMapping("/detail")
    String  getOrderDetail(@RequestParam(name = "orderId") Long orderId);


    @GetMapping("/getOrder")
    String  productGetOrder(@RequestParam(name = "uid") Long uid);

    @GetMapping("/getProductList")
    String  getProductList();




}
