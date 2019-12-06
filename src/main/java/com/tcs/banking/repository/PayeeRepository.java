package com.tcs.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.banking.model.Payee;

public interface PayeeRepository extends JpaRepository<Payee, Integer> {
	
	List<Payee> findByCustId(int custId);
}
