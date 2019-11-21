package cn.com.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author yulong
 * @create 2019/10/9
 */
@RestController
@RequestMapping("/actuator")
public class ActuatorController {

    @GetMapping("/user")
    public String getUser() {
        return "user";

    }

    @PostMapping("/user")
    public String newUser() {
        return "new user";

    }

    @PutMapping("/user")
    public String updateUser() {
        return "update user";

    }

    @DeleteMapping("/user")
    public String delUser() {
        return "del user";

    }


}
