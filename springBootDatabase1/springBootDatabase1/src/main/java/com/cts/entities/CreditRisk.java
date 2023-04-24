package com.cts.entities;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="creditRisk")
public class CreditRisk {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="crId")
	private String crId;
	
	@NotBlank(message = "Loan application ID is mandatory")
	@Column(name="loanAppId")
	private String loanAppId;
	
	
	@NotNull(message = "Credit score is mandatory")
    @Min(value = 200, message = "Credit score must be between 200 and 700")
    @Max(value = 700, message = "Credit score must be between 200 and 700")
	@Column(name="creditScore")
	private int creditScore;
	
	@Positive(message = "EMI must be positive")
	@Column(name="emi")
	private int emi;
	
	@Enumerated(EnumType.STRING)
	@Column(name="basicCheck")
	private String basicCheck;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="loanAppId", referencedColumnName = "loanAppId")
	private LoanApplication loanApplication;

	
	
	public CreditRisk(String crId, @NotBlank(message = "Loan application ID is mandatory") String loanAppId,
			@NotNull(message = "Credit score is mandatory") @Min(value = 200, message = "Credit score must be between 200 and 700") @Max(value = 700, message = "Credit score must be between 200 and 700") int creditScore,
			@Positive(message = "EMI must be positive") int emi, String basicCheck, LoanApplication loanApplication) {
		super();
		this.crId = crId;
		this.loanAppId = loanAppId;
		this.creditScore = creditScore;
		this.emi = emi;
		this.basicCheck = basicCheck;
		this.loanApplication = loanApplication;
	}

	
	
	
	public CreditRisk() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCrId() {
		return crId;
	}

	public void setCrId(String crId) {
		this.crId = crId;
	}

	public String getLoanAppId() {
		return loanAppId;
	}

	public void setLoanAppId(String loanAppId) {
		this.loanAppId = loanAppId;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public String getBasicCheck() {
		return basicCheck;
	}

	public void setBasicCheck(String basicCheck) {
		this.basicCheck = basicCheck;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}
	
	
	
}
