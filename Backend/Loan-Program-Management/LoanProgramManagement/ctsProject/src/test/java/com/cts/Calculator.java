package com.cts;

public class Calculator {
	public int summation(int a,int b) {
		return a+b;
	}
	public int product(int a, int b, int c) {
		return a*b*c;
	}
	public boolean sameOrNot(int a,int b) {
		return a==b;
	}
	
//	public boolean multipleOrNot(int val1,int val2) {
//		if(val2%val1==0) {
//			return true;
//		}
//		return false;
//	}
	public boolean multipleOrNot(int val1, int val2) {
		if(val2%val1==0) {
			return true;
		}
		return false;
	}
	
}
