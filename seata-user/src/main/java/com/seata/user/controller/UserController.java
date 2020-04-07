package com.seata.user.controller;

import com.seata.user.bean.SeataUser;
import com.seata.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yulong
 * @create 2020/3/27
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String test(){
        SeataUser s1 = new SeataUser();

        s1.setName("1111");
        s1.setAge("1111");
        s1.setPhone("1111");
        s1.setAddress("11111");

        userService.add(s1);
        return "success";
    }

}