package com.cts.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;

@Entity
@Table(name="loanApplication")
public class LoanApplication {
	@Id
	@Column(name="loanAppId")
	private String loanApplicationId;
	
	@NotBlank(message = "Customer ID is mandatory")
	@Column(name="custId")
	private String customerId;
	
	@Positive(message = "Loan amount must be positive")
	@Column(name="loanAmt")
	private int loanAmount;
	
	@Positive(message = "Number of years must be positive")
	@Column(name="noOfYears")
	private int noOfYears;
	
	@NotBlank(message = "Purpose is mandatory")
	@Column(name="purpose")
	private String purpose;
	
	@NotBlank(message = "Application status is mandatory")
	@Column(name="appStatus")
	private String applicationStatus;
	
	@NotBlank(message = "Type of loan is mandatory")
	@Column(name="typeOfLoan")
	private String typeOfLoan;
	
	@NotNull(message = "Loan application date is mandatory")
	@Column(name="loanAppDate")
	@Temporal(TemporalType.DATE)
	private Date loanAppDate;
	
	@NotBlank(message = "Status is mandatory")
	@Column(name="status")
	private String status;
	
	@OneToOne(mappedBy = "loanApplication", cascade=CascadeType.ALL)
	private CreditRisk creditRisk;

	
	
	
	public LoanApplication(String loanApplicationId, @NotBlank(message = "Customer ID is mandatory") String customerId,
			@Positive(message = "Loan amount must be positive") int loanAmount,
			@Positive(message = "Number of years must be positive") int noOfYears,
			@NotBlank(message = "Purpose is mandatory") String purpose,
			@NotBlank(message = "Application status is mandatory") String applicationStatus,
			@NotBlank(message = "Type of loan is mandatory") String typeOfLoan,
			@NotNull(message = "Loan application date is mandatory") Date loanAppDate,
			@NotBlank(message = "Status is mandatory") String status, CreditRisk creditRisk) {
		super();
		this.loanApplicationId = loanApplicationId;
		this.customerId = customerId;
		this.loanAmount = loanAmount;
		this.noOfYears = noOfYears;
		this.purpose = purpose;
		this.applicationStatus = applicationStatus;
		this.typeOfLoan = typeOfLoan;
		this.loanAppDate = loanAppDate;
		this.status = status;
		this.creditRisk = creditRisk;
	}
	
	

	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(String loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getTypeOfLoan() {
		return typeOfLoan;
	}

	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}

	public Date getLoanAppDate() {
		return loanAppDate;
	}

	public void setLoanAppDate(Date loanAppDate) {
		this.loanAppDate = loanAppDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CreditRisk getCreditRisk() {
		return creditRisk;
	}

	public void setCreditRisk(CreditRisk creditRisk) {
		this.creditRisk = creditRisk;
	}
	
	
	

}
