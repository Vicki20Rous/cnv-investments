package com.liftoff.cnvInvestments.controllers;

import com.liftoff.cnvInvestments.models.Users;
import com.liftoff.cnvInvestments.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @PostConstruct
    public void initRoleAndUser() {
        usersService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public Users registerNewUser(@RequestBody Users users) {
        return usersService.registerNewUser(users);
    }

    @GetMapping({"/forFundManager"})
    @PreAuthorize("hasRole('Fund Manager')")
    public String forFundManager() {
        return "This URL is only accessible for Fund Managers only";
    }

    @GetMapping({"/forInvestor"})
    @PreAuthorize("hasRole('Investor')")
    public String forInvestor() {
        return "This URL is accessible to Investors ";
    }
}
