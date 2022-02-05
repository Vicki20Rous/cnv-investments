package com.liftoff.cnvInvestments.service;

import com.liftoff.cnvInvestments.dto.models.Role;
import com.liftoff.cnvInvestments.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role) {
        return roleRepo.save(role);
    }
}
