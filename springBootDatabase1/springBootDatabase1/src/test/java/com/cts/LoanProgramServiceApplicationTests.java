package com.cts;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoanProgramServiceApplicationTests {
	Calculator c=new Calculator();
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void findSummation() {
		int expectedRes=10;
		int actualRes=c.summation(5, 5);
		assertThat(actualRes).isEqualTo(expectedRes);
	}
	
	@Test
	void findProduct() {
		int expectedRes=100;
		int actualRes=c.product(25, 2, 2);
		assertThat(actualRes).isEqualTo(expectedRes);  //first pass actual output then pass expected output
	}
	
	@Test
	void checking() {
		boolean res=c.sameOrNot(24, 24);
		assertThat(res).isTrue();
	}
	
	@Test
	void multiple() {
		boolean result=c.multipleOrNot(6, 10);
		assertThat(result).isTrue();
	}

}
