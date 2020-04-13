package annotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CarLoanTestCases {
	
	/*
	 * Class Level Annotations:
	 * These are the annotations that are being used in the class level (.java) file and it is exclusive to that class. There are 2 level of annotations.
	 * 1. Before Class & After Class: These are executed once at class level when the class gets loaded and executed.
	 * 2. Before Method & After method: These are executed once before and after every method in the same class file (.java file)
	 * 
	 * XML File level Annotations:
	 * These are the annotations that are executed at the xml file level. There are 2 levels of annotations.
	 * 1) Before Test & After Test: These are executed once before all the tests that are marked inside the <classes/> tags that are executed in the XML file definition hierarchy.
	 * 2) Before Suite & After Suite: These are executed once before and after all the tests <tests></test> in the test level that are marked in the XML file definition hierarchy. 
	 * 
	 */
	
	@Test
	public void webLoginTest() {
		System.out.println("@Test This test validates if the user is able to successfully login to the web interface");
	}
	
	@Test
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
	
	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest: I'll be execcuted after all the tests marked in the test level in XML file");
		System.out.println("@AfterTest NOTE: It will be executed only for carLoanTestCases.java file since this is test level");
		System.out.println("******************************************End of Test (XML File Level)*****************************************");

	}
	

}
