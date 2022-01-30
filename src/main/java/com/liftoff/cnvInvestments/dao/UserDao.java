package com.liftoff.cnvInvestments.dao;

import com.liftoff.cnvInvestments.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
