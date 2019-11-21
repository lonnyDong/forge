package cn.com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yulong
 * 将外部提供的接口文档 映射成本地接口
 *
 */
@FeignClient(name="nothing",url = "localhost:8588",fallback =OrderServiceHystrixImpl.class)
public interface OrderService {


    @PostMapping("/create")
    public String  create(@RequestBody Map<String,Object> HashMap) ;


    @PostMapping("/detail")
    public String  getOrderDetail(@RequestParam(name = "orderId") Long orderId);


    @PostMapping("/productList")
    public String  productList();






}
