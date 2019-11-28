package cn.com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author yulong
 * @create 2019/11/26
 * 德方应收账款接口
 */


@FeignClient(name = "receivable", url = "http://receivable-dev.defangchain.com",fallback=ReceivableServiceHystrixImpl.class)
public interface ReceivableService {


    /**
     * 登陆接口
     */
    @PostMapping("/usermanage/user/login")
    String userLogin(@RequestBody Map<String, Object> HashMap);

















}
