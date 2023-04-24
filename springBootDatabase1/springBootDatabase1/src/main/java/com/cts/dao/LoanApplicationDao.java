package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entities.LoanApplication;

public interface LoanApplicationDao extends JpaRepository<LoanApplication, String> {

}
