package com.seata.user.service;

import com.account.bean.SeataAccount;
import com.account.service.AccountCenterService;
import com.seata.user.bean.SeataUser;
import com.seata.user.dao.UserDao;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yulong
 * @create 2020/3/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;



    @Autowired
    private AccountCenterService accountCenterServiceImpl;
    @GlobalTransactional
    @Override
    public void add(SeataUser seataUser) {
//
        userDao.add(seataUser);
        SeataAccount seataAccount = new SeataAccount();
        accountCenterServiceImpl.createAccount(seataAccount);
    }


    @Transactional(rollbackFor=Exception.class,propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updatePhone(SeataUser seataUser) {
        userDao.updatePhone(seataUser.getId(),seataUser.getPhone());
        System.out.println(19/0);
    }

    @Transactional(rollbackFor=Exception.class,propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateAge(SeataUser seataUser) {
        userDao.updateAge(seataUser.getId(),seataUser.getAge());
//        System.out.println(1/0);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public void updateUser() {
        SeataUser seataUser = new SeataUser();
        seataUser.setPhone("110");
        seataUser.setId(1);
        SeataUser seataUser2 = new SeataUser();
        seataUser2.setId(2);
        seataUser2.setAge("20");

        //更新age
        this.updateAge(seataUser2);
        //更新手机
        this.updatePhone(seataUser);




    }

}
