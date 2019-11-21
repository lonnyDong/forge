package cn.com.service;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yulong
 * @create 2019/9/26
 * <p>
 * 阿里云第三方接口
 * springcloud 包装后的注解
 */
@FeignClient(name = "accountService", url = "https://ccdcapi.alipay.com")
public interface AccountService {


    @RequestMapping(value="/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo=6216665000001788266&cardBinCheck=true",method=RequestMethod.GET)
    public String getBankInfo();


    @RequestMapping(value="/validateAndCacheCardInfo.json",method=RequestMethod.GET)
    public String getBankInfo(@RequestParam("_input_charset")String charset,@RequestParam("cardNo")String cardNo);


}
