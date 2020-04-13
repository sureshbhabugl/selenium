package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 * Listners listens to each event triggered from the XML file. The following are the steps.
 * NOTE: ITestListner is an INTERFACE. 
 * 1) Implement the interface
 * 2) Add the Listener class name in the testNG Listner.xml file. 
 * 
 * NOTE: You wont get the error message to implement all the classes since the latest version of ITestListner has default implementation.
 * 
 */

//Implement ITestListner
public class Listners implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("FAILED"+result.getName());
	}

	
	
	

}
