package selenium;

import org.openqa.selenium.By;

public class CustomCSS {
	
	
	

	
	static Main main = new Main();

	public static void main(String[] args) throws InterruptedException {

		//validateFacebookCustomXPath();
		
		validateSalesForceLogin();
		
		main.quitAll();
		
	}

	
	//Syntax for CSS is tagname[attribute=value]
	
	public static void validateFacebookCustomXPath() throws InterruptedException {
		
		main.loadFaceBookPage();
		
		main.driver.findElement(By.cssSelector("input[type='email']")).sendKeys("someemail.email.com");
		
		main.driver.findElement(By.cssSelector("input[data-testid='royal_pass']")).sendKeys("somepassword");
		
		main.driver.findElement(By.cssSelector("input[value='Log In']")).click();
		
		main.driver.wait();
	}
	
	
	/*
	 * There is another short way to recognize CSS selectors for ID and ClassName
	 * <input type="password" class="inputtext login_form_input_box" name="pass" id="pass" data-testid="royal_pass">
	 * 
	 * ID -  tagName#id
	 * example: input#pass
	 * 
	 * Class Name - tagname.className
	 * example: input.inputtext
	 * 
	 * 
	 * REMEMBER: You may skip the tag name as well and it will work. Example 
	 * 
	 * 	ID = #pass
	 * 	CSS = .inputtext
	 */
	
	public static void validateSalesForceLogin() throws InterruptedException{
		
		main.loadSalesForceLoginPage();
		
		boolean isLogoDisplayed = main.driver.findElement(By.cssSelector("img.standard_logo")).isDisplayed();  // Using the '.' for class name to check if the logo is displayed.
		
		System.out.println(isLogoDisplayed);
		
		main.driver.findElement(By.cssSelector("input#username")).sendKeys("someusername");  // using # to represent ID in the css selector
		
		main.driver.findElement(By.cssSelector("input#password")).sendKeys("somepassword"); // using # to represent ID in the css selector
		
		main.driver.findElement(By.cssSelector("input#Login")).click(); // using # to represent ID in the css selector
		
		
	}
	
}
