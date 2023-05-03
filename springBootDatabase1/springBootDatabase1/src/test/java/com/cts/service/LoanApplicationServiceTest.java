package com.cts.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.dao.LoanApplicationDao;
import com.cts.services.LoanApplicationService;
import com.cts.services.impl.LoanApplicationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class LoanApplicationServiceTest {
	
	@Mock    //for that only we use fake data
	private LoanApplicationDao loanApplicationDaoTest;
	
//	@Autowired We will not use autowired beacuse the actual data will come from database. we need fake data
	private LoanApplicationService loanApplicationServiceTest;
	
	@BeforeEach
	void setUp() {
		this.loanApplicationServiceTest = new LoanApplicationServiceImpl(this.loanApplicationDaoTest);
	}
	
	@Test
	void getAllDetails() {
		loanApplicationServiceTest.getAllDetails();
		verify(loanApplicationDaoTest).findAll();
	}
}
