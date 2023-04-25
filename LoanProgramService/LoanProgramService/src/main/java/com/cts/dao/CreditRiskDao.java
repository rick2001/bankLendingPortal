package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entities.CreditRisk;

public interface CreditRiskDao extends JpaRepository<CreditRisk, Integer> {

}