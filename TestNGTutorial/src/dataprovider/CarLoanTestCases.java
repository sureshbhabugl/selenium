package dataprovider;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CarLoanTestCases {
	
	/*
	 * TestNG has the following helpers that can be added along with the annotations.
	 * 
	 * 1) dependsOnMethods = ({<method names>}) - This helper is used to add the test case dependency between two or more test cases
	 * 2) enabled=true/false - This helper is used to toggle on/off a test based on the requirement.
	 * 3) timeOut=4000 - this attribute can be set to a value (in milliseconds) to enable timeout for a specific method. 
	 * 
	 */
	
	@Parameters({"URL"})
	@Test(groups= {"smoke"})
	public void webLoginTest(String URL) {
		System.out.println("-----------------------Value of the parameter: "+URL);
		
	}
	
	@Test(dependsOnMethods={"RestLoginTest"})
	public void mobileLoginTest() {
		System.out.println("@Test This test validates if the user is able to successfully login to the mobile interface");
	}
	
	@Test
	public void RestLoginTest() {
		System.out.println("@Test: This test validates if the user is able to successfully login using API");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("******************************************Beginning of the Test (XML File Level)*****************************************");
		System.out.println("@BeforeTest: I'll be execcuted before all the tests marked in the test level in XML file");
	}
	
	//Example of enabled and disabled
	
	@Test(enabled=true)
	public void enabledExample() {
		System.out.println("I'm an example of enabled helper");
	}
	
	//Example of enabled and disabled
	
		@Test(timeOut=2000)
		public void zTimeOutExample() throws InterruptedException {
			System.out.println("I'm an example of enabled helper");
			
		}
	
	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest: I'll be execcuted after all the tests marked in the test level in XML file");
		System.out.println("@AfterTest NOTE: It will be executed only for carLoanTestCases.java file since this is test level");
		System.out.println("******************************************End of Test (XML File Level)*****************************************");

	}
	

}
