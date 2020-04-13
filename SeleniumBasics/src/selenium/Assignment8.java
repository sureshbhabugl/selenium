package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/suresh/eclipse-workspace/bin/bin/driver/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement country = driver.findElement(By.cssSelector("input#autocomplete"));

		country.sendKeys("United");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String script = "return document.getElementById(\"autocomplete\").value;";

		String text = (String) js.executeScript(script);

		System.out.println(text);

		int i = 0;

		while (!text.contains("USA")) {

			country.sendKeys(Keys.DOWN);
			i++;
			text = (String) js.executeScript(script);

			System.out.println(text);

			if (i >= 10)
				break;
		}

		if (i == 10)
			System.out.println("Element not found");

	}

}
