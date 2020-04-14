package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

public class FlightAutomation{
	
	TestBase ts = null;
	@Test
	public void Login() throws IOException {
		ts = new TestBase();
		System.out.println(ts.getProperty("URL"));
		ts.navigateToURl(ts.getProperty("URL"));
		ts.login(ts.getProperty("UserName"), ts.getProperty("Password"));
		ts.driver.quit();
	}

}
