package cn.com;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yulong
 * @create 2019/9/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankQueryParam implements Serializable {

    private String cardNo;

    private String checkBin;


}
