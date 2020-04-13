package dataprovider;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class HomeLoanWithDataProvider {

	/*
	 * Class Level Annotations: These are the annotations that are being used in the
	 * class level (.java) file and it is exclusive to that class. There are 2 level
	 * of annotations. 1. Before Class & After Class: These are executed once at
	 * class level when the class gets loaded and executed. 2. Before Method & After
	 * method: These are executed once before and after every method in the same
	 * class file (.java file)
	 * 
	 * XML File level Annotations: These are the annotations that are executed at
	 * the xml file level. There are 2 levels of annotations. 1) Before Test & After
	 * Test: These are executed once before all the tests that are marked inside the
	 * <classes/> tags that are executed in the XML file definition hierarchy. 2)
	 * Before Suite & After Suite: These are executed once before and after all the
	 * tests <tests></test> in the test level that are marked in the XML file
	 * definition hierarchy.
	 * 
	 */

	@Parameters({ "URL" })
	@Test(groups = { "regression" })
	public void paramterTest(String URL) {
		System.out.println("-------The parameter URL from the xml file is : " + URL);
	}

	@Test(groups = { "regression" })
	public void webLoginTest() {
		System.out.println("@Test: This test validates if the user is able to successfully login to the web interface");
	}

	@Test(groups = { "regression" })
	public void mobileLoginTest() {
		System.out.println(
				"@Test: This test validates if the user is able to successfully login to the mobile interface");
	}

	@Test(dataProvider = "getData")
	public void RestLoginTest(String username, String password) {
		System.out.println("Username: "+username);
		System.out.println("Password: "+password);
		
	}

	/*
	 * The following method is specifically going to do the data provided to
	 * restLoginTest
	 */

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[3][2]; // Here the first dimension is for the number of rows to be iterated and the
											// second dimension is for the number of parameters.

		// First set of data
		data[0][0] = "firstusername";
		data[0][1] = "password1";

		// Second set of data
		data[1][0] = "secondusername";
		data[1][1] = "password2";

		// Third set of data
		data[2][0] = "thirdusername";
		data[2][1] = "password3";
		
		
		// Another way to send the data is as follows
		
		Object[][] data1= {
				{"suresh1","password1"},
				{"suresh2","password2"},
				{"suresh3","password3"}
		};
		
		return data1;

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println(
				"******************************************Beginning of the Suite*****************************************");
		System.out.println(
				"@BeforeSuite: I'll be the first method to be executed before any class will be executed as I'm suite level annotation");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println(
				"@AfterSuite: I'll be the first method to be executed before any class will be executed as I'm suite level annotation");
		System.out.println(
				"******************************************End of the Suite*****************************************");
	}

}
