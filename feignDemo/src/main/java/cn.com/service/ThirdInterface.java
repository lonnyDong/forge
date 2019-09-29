package cn.com.service;

import cn.com.BankQueryParam;
import feign.*;
import feign.codec.StringDecoder;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author yulong
 * @create 2019/9/26
 * <p>
 * 阿里云第三方接口
 */
public interface ThirdInterface {

    /**
     * 单个参数
     * @param cardNo
     * @return
     */
    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck=true")
    String getBankInfo(@Param("cardNo") String cardNo);

    /**
     * 多个参数
     * @param cardNo
     * @param binCheck
     * @return
     */
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck={binCheck}")
    String getBankInfo2(@Param("cardNo") String cardNo,@Param("binCheck") Boolean binCheck);

    /**
     * POJO
     * @param cardNo
     * @return
     */
    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck=true")
    String getBankInfo3(@QueryMap BankQueryParam bankQueryParam);


    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck=true")
    String getBankInfo4(@Param("cardNo") String cardNo);





    static ThirdInterface connect() {

        return Feign.builder()
                .decoder(new JacksonDecoder())
                .decoder(new StringDecoder())
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(
                        ThirdInterface.class, "https://ccdcapi.alipay.com"
                );
    }
}
