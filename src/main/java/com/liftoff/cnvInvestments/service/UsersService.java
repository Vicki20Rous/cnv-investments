package com.liftoff.cnvInvestments.service;

import com.liftoff.cnvInvestments.models.Role;
import com.liftoff.cnvInvestments.models.Users;
import com.liftoff.cnvInvestments.repository.RoleRepo;
import com.liftoff.cnvInvestments.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void initRoleAndUser() {

        Role fundManagerRole = new Role();
        fundManagerRole.setRoleName("Fund Manager");
        fundManagerRole.setRoleDescription("Fund Manager Role");
        roleRepo.save(fundManagerRole);

        Role investorRole = new Role();
        investorRole.setRoleName("Investor");
        investorRole.setRoleDescription("Investor Role");
        roleRepo.save(investorRole);

        Users fundManagerUser = new Users();
        fundManagerUser.setUsersName("admin");
        fundManagerUser.setUsersPassword(getEncodedPassword("manager@pass"));
        fundManagerUser.setUsersFirstName("manager1");
        fundManagerUser.setUsersLastName("manager1");
        Set<Role> fundManagerRoles = new HashSet<>();
        fundManagerRoles.add(fundManagerRole);
        fundManagerUser.setRole(fundManagerRoles);
        usersRepo.save(fundManagerUser);

    }

    public Users registerNewUser(Users users) {
        Role role = roleRepo.findById("Investors").get();
        Set<Role> investorRoles = new HashSet<>();
        investorRoles.add(role);
        users.setRole(investorRoles);
        users.setUsersPassword(getEncodedPassword(users.getUsersPassword()));

        return usersRepo.save(users);
    }

}
