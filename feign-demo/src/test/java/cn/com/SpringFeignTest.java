package cn.com;

//import cn.com.service.AccountService;
import cn.com.service.AccountService;
import cn.com.service.AliInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFeignTest {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AccountService accountService;

    @Test
    public void test2() {
        String bankInfo = accountService.getBankInfo();
        LOGGER.info("bankInfo:{}" , bankInfo);
    }


}