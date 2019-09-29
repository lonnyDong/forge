package cn.com;

import cn.com.service.AccountService;
import cn.com.service.ThirdInterface;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.codec.StringDecoder;
import feign.jackson.JacksonDecoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrginalFeignTest {

//    @Autowired
//    AccountService accountService;

    @Test
    public void test() {

        String bankInfo = ThirdInterface.connect().getBankInfo("6216665000001788266");
        System.out.println("bankInfo:" + bankInfo);
    }

    @Test
    public void test2() {

        String bankInfo = ThirdInterface.connect().getBankInfo2("6216665000001788266",false);
        System.out.println("bankInfo2:" + bankInfo);
    }


//    @Test
//    public void test2() {
//        String bankInfo = accountService.getBankInfo("6216665000001788266");
//        System.out.println("bankInfo:" + bankInfo);
//    }


}