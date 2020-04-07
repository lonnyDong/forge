package com.seata;

import com.AccountApplication;
import com.account.service.AccountCenterService;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yulong
 * @create 2020/3/27
 */

@SpringBootTest(classes= AccountApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Autowired
    AccountCenterService accountCenterServiceImpl;

//
//    @Test
//    public void testUser4() {
//
//        accountCenterServiceImpl.createAccount(null);
//
//    }

}
