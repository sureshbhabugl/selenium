package selenium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
	
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/suresh/eclipse-workspace/bin/bin/driver/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//1. Getting the value of the option selected.
		String optionLabel = selectRandomCheckBox(driver);
		
		// Printing the option selected based on the ID value passed.
		if(!optionLabel.isEmpty())
			System.out.println("The selected checkbox label is " + optionLabel);
		else {
			throw new NullPointerException();
			
		}
		
		//2. Selecting an option based from the drop down list based on the option selected in the previous step.
		
		Select select = new Select(driver.findElement(By.cssSelector("select#dropdown-class-example")));
		
		select.selectByValue(optionLabel);
		
		//3. Entering the random value in the textbox 
		
		driver.findElement(By.cssSelector("input#name")).sendKeys(optionLabel);
		
		//Clicking on the Alert button
		
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		Assert.assertTrue(alertMessage.contains(optionLabel));
		
		driver.quit();

	}
	
	
	
	public static String selectRandomCheckBox(WebDriver driver) {
		
		int id = driver.findElements(By.cssSelector("input[type='checkbox']")).size();  // I'm counting the number of options that are there in the page to make it dynamic

		WebElement optionToSelect = driver.findElement(By.cssSelector("input#checkBoxOption" + generateRandomOptionValue(id)));

		optionToSelect.click(); // Clicking on the random option based on the value of ID
		
		String oLabel = null;

		// In the below loop, I'm looping thur all the options in the page and checking if they are
		// selected.If selected, I'm extracting the value of the option checked using
		// "getAttribute()" method.
		
		for (int i = 1; i <= id; i++) {
		
			WebElement optionCheckBox = driver.findElement(By.cssSelector("input#checkBoxOption" + i));
			
			if (optionCheckBox.isSelected()) {
			
				oLabel = optionCheckBox.getAttribute("value");
				
			}
		}
		
		return !oLabel.isEmpty()?oLabel:null; 
		

	}
	
	
	public static int generateRandomOptionValue(int checkBoxCount ) {
		
		if(checkBoxCount==0) {
			throw new IllegalAccessError("The maximum check box count cannot be zero");
		}
		
		Random rand = new Random();

		int imax = checkBoxCount;
		int imin = 1;

		return rand.nextInt((imax - imin) + 1) + imin;
	}

}
