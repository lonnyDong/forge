package com.account.service;

import com.account.bean.SeataAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yulong
 * @create 2020/4/3
 */
@FeignClient(name="account-Center")
public interface AccountCenterService {

    @GetMapping("/create")
    String createAccount(@RequestBody SeataAccount account);

}
