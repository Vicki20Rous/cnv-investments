package com.liftoff.cnvInvestments.repository;

import com.liftoff.cnvInvestments.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}
