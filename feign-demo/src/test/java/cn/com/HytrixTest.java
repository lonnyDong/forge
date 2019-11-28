package cn.com;

//import cn.com.service.AccountService;
import cn.com.service.AccountService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;

import java.util.concurrent.Future;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class HytrixTest {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test2() {
        String s = new CommandHelloWorld("Bob").execute();
//        Future<String> s = new CommandHelloWorld("Bob").queue();
//        Observable<String> s = new CommandHelloWorld("Bob").observe();

        System.out.println("s:"+s);
    }


    class CommandHelloWorld extends HystrixCommand<String> {

        private final String name;

        public CommandHelloWorld(String name) {
            super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
            this.name = name;
        }

        @Override
        protected String run() {
            return "Hello " + name + "!";
        }
    }

}