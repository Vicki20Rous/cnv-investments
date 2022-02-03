package com.liftoff.cnvInvestments.service;

import com.liftoff.cnvInvestments.dao.RoleDao;
import com.liftoff.cnvInvestments.dao.UserDao;
import com.liftoff.cnvInvestments.entity.Role;
import com.liftoff.cnvInvestments.entity.User;
import com.mysql.cj.xdevapi.AddStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user) {
        return userDao.save(user);
    }

    public void initRolesAndUser(){
        Role fundManagerRole = new Role();
        fundManagerRole.setRoleName("Fund Manager");
        fundManagerRole.setRoleDescription("Fund Manager role");
        roleDao.save(fundManagerRole);

        Role investorRole = new Role();
        investorRole.setRoleName("Investor");
        investorRole.setRoleDescription("Investor role");
        roleDao.save(investorRole);


        User fundManagerUser = new User();
        fundManagerUser.setUserFirstName("victoria");
        fundManagerUser.setUserLastName("rouser");
        fundManagerUser.setUserName("manager27");
        fundManagerUser.setPassword("java@pass");
        Set<Role> fundManagerRoles = new HashSet<>();
        fundManagerRoles.add(fundManagerRole);
        fundManagerUser.setRole(fundManagerRoles);
        userDao.save(fundManagerUser);

        User investorUser = new User();
        investorUser.setUserFirstName("john");
        investorUser.setUserLastName("smith");
        investorUser.setUserName("investor187");
        investorUser.setPassword("code@pass");
        Set<Role> investorUsers = new HashSet<>();
        investorUsers.add(investorRole);
        investorUser.setRole(investorUsers);
        userDao.save(investorUser);

    }
}
