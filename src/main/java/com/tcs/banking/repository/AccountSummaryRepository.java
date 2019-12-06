package com.tcs.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.banking.model.AccountSummary;

public interface AccountSummaryRepository extends JpaRepository<AccountSummary, Integer> {
	@Query("select c from AccountSummary c where c.custId = :custId")
	List<AccountSummary> findByCustid(int custId);
}
