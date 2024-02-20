package com.coffee.controller;

import com.coffee.entity.Res;
import com.coffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public Res login(String user, String password){
        Res res = userService.login(user,password);
        return res;
    }
}
