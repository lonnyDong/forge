package cn.com;

import cn.com.service.OrderService;
import cn.com.web.FeignController;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 性能测试
 *
 * @author yulong
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContiPerfTest {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testHelloController() throws Exception {
        ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/order/getProductList").accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = perform.andReturn();
        System.out.println("res:" + mvcResult.getResponse().getContentAsString());

    }


    /**
     * 总共执行2000次数
     * 线程4个
     * 输出的文档\target\contiperf-report\index.html
     */
    @Test
    @PerfTest(invocations = 20, threads = 2,duration = 10000)
    public void test() {

        ResultActions perform = null;
        String res = null;
        try {
            perform = mvc.perform(MockMvcRequestBuilders.get("/order/getProductList").accept(MediaType.APPLICATION_JSON));
            MvcResult mvcResult = perform.andReturn();
            res = mvcResult.getResponse().getContentAsString();
        } catch (Exception e) {
            LOGGER.error(Thread.currentThread().getName() + " --- " + "Mock 构建异常");
        }
        LOGGER.info(Thread.currentThread().getName() + " --- " + res);
    }


}
