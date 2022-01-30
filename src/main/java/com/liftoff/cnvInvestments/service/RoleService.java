package com.liftoff.cnvInvestments.service;

import com.liftoff.cnvInvestments.dao.RoleDao;
import com.liftoff.cnvInvestments.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
    return roleDao.save(role);
    }
}
