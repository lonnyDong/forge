package cn.com.service;

import cn.com.BankQueryParam;
import feign.*;

import java.util.Map;

/**
 * @author yulong
 * @create 2019/9/26
 * <p>
 * 阿里云第三方接口
 * 原生注解测试
 *
 */

public interface AliInterface {

    /**
     * 获取银行卡信息
     * @param cardNo
     * @return
     */
    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck=true")
    String getBankInfo(@Param("cardNo") String cardNo);

    /**
     * 获取银行卡和卡bin信息
     * @param cardNo
     * @param binCheck
     * @return
     * 参数
     */
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestLine("GET /validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo={cardNo}&cardBinCheck={binCheck}")
    String getBankInfo2(@Param("cardNo") String cardNo,@Param("binCheck") Boolean binCheck);


    /**
     * 使用map封装参数
     */
    @RequestLine("GET /validateAndCacheCardInfo.json")
    String getBankInfoMap(@QueryMap Map map);



    /**
     * 使用map封装参数
     */
    @RequestLine("GET /validateAndCacheCardInfo.json")
    String getBankInfoMap(@QueryMap BankQueryParam bankQueryParam);



    static AliInterface connect() {

        return Feign.builder()
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(
                        AliInterface.class, "https://ccdcapi.alipay.com"
                );
    }
}
