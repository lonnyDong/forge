package com.seata.account.dao;

import com.account.bean.SeataAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yulong
 * @create 2020/3/27
 */
@Mapper
public interface AccountDao {

    int createAccount(@Param("seataAccount") SeataAccount seataAccount);


}
