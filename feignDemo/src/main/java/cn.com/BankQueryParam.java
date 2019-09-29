package cn.com;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yulong
 * @create 2019/9/27
 */
@Data
public class BankQueryParam implements Serializable {

    private String cardNo;

    private String checkBin;


}
