package parameteratxmlfilelevel;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PersonalLoanTestCases {
	
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
	
	@Parameters({"URL"})
	@Test(groups= {"smoke"})
	public void webLoginTest(String URL) {
		System.out.println("-----------------------Value of the parameter: "+URL);
		
	}
	
	@Test(groups= {"smoke","regression"})
	public void mobileLoginTest() {
		System.out.println("@Test This test validates if the user is able to successfully login to the mobile interface");
	}
	
	@Test(groups = {"regression"})
	public void RestLoginTest() {
		System.out.println("@Test: This test validates if the user is able to successfully login using API");
	}
	
	@BeforeClass(groups = {"regression"})
	public void beforeClass() {
		System.out.println("******************************************Beginning of the Class (Class level annotation)*****************************************");

		System.out.println("@BeforeClass: This will be first method executed before any method is executed in PersonalLoanTestCases.java file");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass: This will be first method executed before any method is executed in PersonalLoanTestCases.java file");
		System.out.println("******************************************End of the Class (Class level annotation)*****************************************");

	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod: This will be first method executed before any method is executed in PersonalLoanTestCases.java file");
		System.out.println("******************************************Before every method execution (Class level annotation)*****************************************");

	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod: This will be last method executed after any method is executed in PersonalLoanTestCases.java file");
		System.out.println("******************************************Before every method execution (Class level annotation)*****************************************");

	}

}
