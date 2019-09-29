package cn.com.service;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.annotation.Target;

/**
 * @author yulong
 * @create 2019/9/26
 * <p>
 * 阿里云第三方接口
 * 这种方式不可以用，feignClient 貌似不支持不填写name的方式
 *
 *
 */
@FeignClient(name = "thisOnlyName", url = "https://ccdcapi.alipay.com")
public interface AccountService {


//    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck=true")
    @GetMapping(value="/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck=true")
    String getBankInfo(@Param("cardNo") String cardNo);

//    @Headers({"Content-Type: application/json","Accept: application/json"})
//    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck=true")
//    String getBankInfo2(@Param("cardNo") String cardNo);
//
//
//    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck=true")
//    String getBankInfo3(@Param("cardNo") String cardNo);
//
//
//    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck=true")
//    String getBankInfo4(@Param("cardNo") String cardNo);

}
