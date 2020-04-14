package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver =null;
	public Properties properties = null;
	public FileInputStream fis = null;
	
	
	//Creating a constructor to initialize the property file and create the file object
	public  TestBase() throws IOException {
		
		properties = new Properties();
		fis = new FileInputStream(".//src//testcases//FlightSimulator.properties"); 
		properties.load(fis);
		
	}
	
	public String getProperty(String propertyName) throws IOException {
		
		//init();
		if(propertyName.isEmpty()) {
			return null;
		}else {
			return properties.getProperty(propertyName);
		}
	}

	public void loadBrowser() {
		String browserName = properties.getProperty("Browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(properties.getProperty("ChromeOption"),properties.getProperty("ChromePath"));
			driver=new ChromeDriver();
		}else if((browserName.equalsIgnoreCase("firefox"))){
			System.setProperty(properties.getProperty("ChromeOption"),properties.getProperty("ChromePath"));
			driver=new ChromeDriver();
		}else {
			throw new IllegalAccessError("Unknown browser");
		}
	}
	
	
	public void navigateToURl(String URL) {
		loadBrowser();
		driver.get(URL);
	}
	
	
	
	
	
	public void login(String UserName, String Password) {
		if(UserName.isEmpty()||Password.isEmpty()) {
			throw new IllegalAccessError("Username or password is empty");
		}
		
		WebElement username = driver.findElement(By.name("userName"));
		WebElement password = driver.findElement(By.name("password"));
	    WebElement loginBtn = driver.findElement(By.name("login"));
		username.sendKeys(UserName);
		password.sendKeys(Password);
		loginBtn.click();
	}

}
