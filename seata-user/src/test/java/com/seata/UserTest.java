package com.seata;

import com.UserApplication;
import com.seata.user.bean.SeataUser;
import com.seata.user.dao.UserDao;
import com.seata.user.service.UserService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author yulong
 * @create 2020/3/27
 */

@SpringBootTest(classes= UserApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();
    @Autowired
    private UserDao userDao;



    @PerfTest(invocations = 10, threads = 1)
    @Test
    public void testUser() {
        SeataUser seataUser = new SeataUser();
        seataUser.setName("颤三"+ new Random().nextInt(9999));
        seataUser.setAge(new Random().nextInt(120));
        seataUser.setPhone("131");
        seataUser.setAddress("ddd");
        int add = userDao.add(seataUser);
        System.out.println(add);
    }


    @Test
    public void testUser2() {
        SeataUser seataUser = new SeataUser();
        seataUser.setName("颤三"+ new Random().nextInt(9999));
        seataUser.setPhone("22");
        userDao.updatePhone(1,"22222222222");

    }


    @Resource
    UserService userServiceImpl;

    @Test
    public void testUser3() {

        userServiceImpl.updateUser();

    }



}
