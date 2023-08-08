package com.cts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.entities.LoanApplication;


@Repository
public interface LoanApplicationDao extends JpaRepository<LoanApplication, String> {

	@Query("select u from LoanApplication u where u.loanAppId not in (select loanAppId from CreditRisk)")
	public List<LoanApplication> getLoanApplication();
	
	
}
