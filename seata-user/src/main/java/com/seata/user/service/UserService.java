package com.seata.user.service;

import com.seata.user.bean.SeataUser;

/**
 * @author yulong
 * @create 2020/3/27
 */
public interface UserService {

    void add( SeataUser seataUser);

    void updatePhone( SeataUser seataUser);

    void updateAge( SeataUser seataUser);

    void updateUser();
}
