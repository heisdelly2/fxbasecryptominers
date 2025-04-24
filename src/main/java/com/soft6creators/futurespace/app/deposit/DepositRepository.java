package com.soft6creators.futurespace.app.deposit;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends CrudRepository<Deposit, Integer> {
	public List<Deposit> findByUserEmail(String userEmail);
	public List<Deposit> findAllByStatus(String status);
} 