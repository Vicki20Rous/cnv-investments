package com.liftoff.cnvInvestments.controllers;

import com.liftoff.cnvInvestments.entity.User;
import com.liftoff.cnvInvestments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    private void initRolesAndUsers(){
        userService.initRolesAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forFundManager"})
    public String forFundManager() {
        return "This URL is accessible to Fund Managers only";
    }

    @GetMapping({"/forInvestor"})
    public String forInvestor() {
        return "This URL is accessible to Investors";
    }
}
