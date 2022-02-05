package com.liftoff.cnvInvestments.repository;

import com.liftoff.cnvInvestments.dto.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
