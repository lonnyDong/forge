package cn.com;

//import cn.com.service.AccountService;
import cn.com.service.AliInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrginalFeignTest {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {

        String bankInfo = AliInterface.connect().getBankInfo("6216665000001788266");
        LOGGER.info("bankInfo:{}" , bankInfo);
    }

    @Test
    public void test2() {

        String bankInfo = AliInterface.connect().getBankInfo2("6216665000001788266",false);
        LOGGER.info("bankInfo2:{}", bankInfo);
    }


    @Test
    public void testMap() {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("_input_charset", "utf-8");
        parameters.put("cardNo", "6216665000001788266");
        parameters.put("cardBinCheck", true);
        String bankInfo = AliInterface.connect().getBankInfoMap(parameters);
        LOGGER.info("testMap:{}" , bankInfo);
    }


//    @Test
//    public void test2() {
//        String bankInfo = accountService.getBankInfo("6216665000001788266");
//        System.out.println("bankInfo:" + bankInfo);
//    }


}