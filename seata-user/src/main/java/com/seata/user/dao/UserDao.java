package com.seata.user.dao;

import com.seata.user.bean.SeataUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yulong
 * @create 2020/3/27
 */
@Mapper
public interface UserDao {

    int add(@Param("seataUser") SeataUser seataUser);

    void updatePhone(@Param("id") int id,@Param("phone") String phone);

    void updateAge(@Param("id")int id,@Param("age") int age);

    SeataUser getUserById(@Param("id")int id);

    //批量更新数据：


}
