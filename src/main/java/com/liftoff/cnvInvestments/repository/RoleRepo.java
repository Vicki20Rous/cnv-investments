package com.liftoff.cnvInvestments.repository;

import com.liftoff.cnvInvestments.dto.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, String> {

}
