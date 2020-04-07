package com.seata.account.service;

import com.account.bean.SeataAccount;
import com.seata.account.dao.AccountDao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author yulong
 * @create 2020/3/27
 */
@RestController
public class AccountServiceImpl {

    @Resource
    private AccountDao accountDao;

   @PostMapping("/create")
    public String createAccount(@RequestBody SeataAccount account) {

        SeataAccount seataAccount = new SeataAccount();
        seataAccount.setName("王五");
        seataAccount.setAge("18");
        seataAccount.setPhone("131");
        seataAccount.setAccountNo("622122");
        seataAccount.setIdNo(UUID.randomUUID().toString().toUpperCase().substring(1,18));
        int account1 = accountDao.createAccount(seataAccount);
       System.out.println(1/0);

        return account+"";


    }
}
