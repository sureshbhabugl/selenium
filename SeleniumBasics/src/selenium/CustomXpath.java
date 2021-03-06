package selenium;

import org.openqa.selenium.By;

public class CustomXpath {
	
	static Main main = new Main();

	public static void main(String[] args) throws InterruptedException {

		validateFacebookCustomXPath();
		
		main.quitAll();
		
	}

	
	
	public static void validateFacebookCustomXPath() throws InterruptedException {
		
		main.loadFaceBookPage();
		
		main.driver.findElement(By.xpath("//input[@type='email']")).sendKeys("someemail.email.com");
		
		main.driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("somepassword");
		
		main.driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		main.driver.wait();
	}
	
	
	
}
