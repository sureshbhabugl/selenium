package testcases;

import org.testng.annotations.Test;

public class CarLoanTestCases {
	
	@Test
	public void webLoginTest() {
		System.out.println("This test validates if the user is able to successfully login to the web interface");
	}
	
	@Test
	public void mobileLoginTest() {
		System.out.println("This test validates if the user is able to successfully login to the mobile interface");
	}
	
	@Test
	public void RestLoginTest() {
		System.out.println("This test validates if the user is able to successfully login using API");
	}
	

}
