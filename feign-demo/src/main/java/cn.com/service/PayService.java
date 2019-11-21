package cn.com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yulong
 *
 *
 *
 */
@FeignClient(name = "alipayApi", url = "https://openapi.alipay.com/gateway.do")
public interface PayService {

    /**
     * 统一收单交易关闭接口
     */
    @PostMapping("/alipay.trade.close")
    public String close(@RequestBody Map<String, Object> HashMap);


    /**
     * 统一收单交易创建接口
     *
     * @param
     * @return
     */
    @PostMapping("/alipay.trade.create")
    public String create(@RequestBody Map<String, Object> HashMap);

    /**
     * 统一收单交易支付接口
     *
     * @param
     * @return
     */
    @PostMapping("/alipay.trade.pay")
    public String pay(@RequestBody Map<String, Object> HashMap);


    /**
     * 统一收单交易支付接口
     *
     * @param
     * @return
     */
    @PostMapping("/koubei.trade.itemorder.query")
    public String query(@RequestBody Map<String, Object> HashMap);

}
