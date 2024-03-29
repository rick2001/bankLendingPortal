package com.cts.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.dao.LoanApplicationDao;
import com.cts.entities.LoanApplication;
import com.cts.services.LoanApplicationService;
import com.cts.services.impl.LoanApplicationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class LoanApplicationServiceTest {

	@Mock // for that only we use fake data
	private LoanApplicationDao loanApplicationDaoTest;

//	@Autowired We will not use autowired beacuse the actual data will come from database. we need fake data
	private LoanApplicationService loanApplicationServiceTest;

	@BeforeEach
	void setUp() {
		this.loanApplicationServiceTest = new LoanApplicationServiceImpl(this.loanApplicationDaoTest);
	}

//	testing the function get list of results based on date
	@DisplayName("Valid date")
	@Test
	public void testGetDateBasedResult1() {
		// dummy data
		LocalDate date = LocalDate.now();
		LoanApplication loanApplication1 = new LoanApplication();
		loanApplication1.setLoanAppDate(date);
		LoanApplication loanApplication2 = new LoanApplication();
		loanApplication2.setLoanAppDate(date);
		LoanApplication loanApplication3 = new LoanApplication();
		loanApplication3.setLoanAppDate(date.minusDays(1));

		// storing dummy data into table
		loanApplicationDaoTest.save(loanApplication1);
		loanApplicationDaoTest.save(loanApplication2);
		loanApplicationDaoTest.save(loanApplication3);

//	        expected data
		List<LoanApplication> loanApplicationList = new ArrayList<>();
		loanApplicationList.add(loanApplication1);
		loanApplicationList.add(loanApplication2);

		// mock the behavior of the DAO........defining the behaviour
		when(loanApplicationDaoTest.findAll()).thenReturn(loanApplicationList);

		List<LoanApplication> result = loanApplicationServiceTest.getListDateBasedResult(date); //above the behaviour 
		       // is defined when this method will get called..instead of the actual data the above data will come.

		assertEquals(loanApplicationList, result);
	}
	
	@DisplayName("Invalid Date")
	@Test
	public void testGetDateBasedResult2() {
		LocalDate date = LocalDate.now();
	    LocalDate nonExistingDate = date.plusDays(1); // Date that doesn't exist in the dummy data

	    LoanApplication loanApplication1 = new LoanApplication();
	    loanApplication1.setLoanAppDate(date);
	    LoanApplication loanApplication2 = new LoanApplication();
	    loanApplication2.setLoanAppDate(date);
	    LoanApplication loanApplication3 = new LoanApplication();
	    loanApplication3.setLoanAppDate(date.minusDays(1));

	    // storing dummy data into table
	    loanApplicationDaoTest.save(loanApplication1);
	    loanApplicationDaoTest.save(loanApplication2);
	    loanApplicationDaoTest.save(loanApplication3);

	    // expected data (empty list)
	    List<LoanApplication> expectedEmptyList = new ArrayList<>();

	    // mock the behavior of the DAO
	    when(loanApplicationDaoTest.findAll()).thenReturn(Arrays.asList(loanApplication1, loanApplication2, loanApplication3));

	    // Call the service method with non-existing date
	    List<LoanApplication> result = loanApplicationServiceTest.getListDateBasedResult(nonExistingDate);

	    assertEquals(expectedEmptyList, result);
	}

	
	// testing the method fetching only one specific Loan Application details based on id 
	@Test
	public void testGetOneDetail() {
		String loanAppId = "123";
		LoanApplication loanApplication = new LoanApplication();
		loanApplication.setLoanAppId(loanAppId);

		// mock the behavior of the DAO
		when(loanApplicationDaoTest.findById(loanAppId)).thenReturn(Optional.of(loanApplication));

		LoanApplication result = loanApplicationServiceTest.getOnedetailBasedOnId(loanAppId);

		assertEquals(loanApplication, result);
	}
	
	
	//testing update details
	@Test
    public void testUpdateDetails() {
		
        String loanAppId = "123";
        LoanApplication loanApplication1 = new LoanApplication();
        loanApplication1.setLoanAppId(loanAppId);
        loanApplicationDaoTest.save(loanApplication1);
        
        // mock the behavior of the DAO
        when(loanApplicationDaoTest.findById(loanAppId)).thenReturn(Optional.of(loanApplication1));

        LoanApplication result = loanApplicationServiceTest.updateLoanDetails(loanApplication1);

        assertEquals(loanApplication1, result);
    }
		
	// testing the function get all the details from the table
	@Test
	void getAllDetails() {
		loanApplicationServiceTest.getAllDetails();
		verify(loanApplicationDaoTest).findAll();
	}
}
