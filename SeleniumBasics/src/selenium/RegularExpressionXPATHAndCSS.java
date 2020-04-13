package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularExpressionXPATHAndCSS extends CheckBoxPractice {

	static WebDriver driver;

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/suresh/eclipse-workspace/bin/bin/driver/chromedriver");

		driver = new ChromeDriver();

		driver.get("http://rediff.com");

		// *************remember********
		// Parent child relationship in the main icon example below. Ex:-
		// //div[contains(@class,'cell topicons')]//a[@class='mailicon']

		driver.findElement(By.xpath("//div[contains(@class,'cell topicons')]//a[@class='mailicon']")).click();

		Thread.sleep(3000);

		driver.navigate().back();

		Thread.sleep(3000);

		// *************REMEMBER********
		// Using regular expression using XPAth using "contains()" method.
		// Example: //a[contains(@title,'Sign in')] . Here instead of typing the long
		// text "Already a user? Sign In", you use contains method and pass the
		// attribbute using @attributename

		driver.findElement(By.xpath("//a[contains(@title,'Sign in')]")).click();

		Thread.sleep(3000);

		driver.navigate().back();

		Thread.sleep(3000);

		// *************REMEMBER********
		// Using regular expression using CSS using "*" method.
		// Example: a[title*='Sign in']. Here instead of typing the long
		// text "Already a user? Sign In", you use * next to the attribute name and
		// assign the value

		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		
		driver.findElement(By.xpath("//u[contains(text(),'Create a new account')]")).click();
		
		

		driver.quit();

	}

}
