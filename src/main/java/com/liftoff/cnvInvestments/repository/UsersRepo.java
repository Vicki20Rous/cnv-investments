package com.liftoff.cnvInvestments.repository;

import com.liftoff.cnvInvestments.dto.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, String> {
    Users findByUsername(String usersName);
}
