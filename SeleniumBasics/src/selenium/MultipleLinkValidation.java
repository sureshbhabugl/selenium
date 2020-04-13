package selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleLinkValidation {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * This test is to test the following functionalities. 1. Count all links in the
		 * amazon web site 2. Count only the links in the footer section 3. Check all
		 * the links in a section in the footer
		 * 
		 */

		System.setProperty("webdriver.chrome.driver", "/Users/suresh/eclipse-workspace/bin/bin/driver/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		// ***********The following step will count all the links in the landing page.
		// 1. Count all links in the amazon web site

		int allLinkCount = driver.findElements(By.tagName("a")).size();

		System.out.println("The total number of links in the landing page: " + allLinkCount);

		// @*************Extracting only the link in the footer section***************
		// Grab the locator that represents the "div" tag of the entire footer section
		// and store it in a webElement.

		WebElement footerSection = driver.findElement(By.cssSelector("div#navFooter"));

		// ***************Note*******************
		// 2. Count only the links in the footer section
		// Instead of using driver, use footerSection webElement variable to grab all
		// the link count

		int footerLinkCount = footerSection.findElements(By.tagName("a")).size(); // Note: Use the webelement variable
																					// for the section instead of
																					// webdriver

		System.out.println("The total number of links in the landing page: " + footerLinkCount);

		// ***************Note*******************
		// 3. Check all the links in first section in the footer

		// Using the similar approach in the previous step, grab the section that is for
		// the footer section and get teh WebElement.

		WebElement footerFirstSection = driver
				.findElement(By.xpath("//div[@class='navFooterLinkCol navAccessibility'][1]//ul"));

		List<WebElement> firstSectionLinks = footerFirstSection.findElements(By.tagName("a"));

		int firstSectionCount = firstSectionLinks.size();

		System.out.println("The total number of links in the landing page: " + firstSectionCount);

		for (WebElement link : firstSectionLinks) {

			System.out.println(link.getText());
		}

		// The command to open a link in new tag
		// Keys.chord(Keys a, Keys b)
		// You can construct "CTRL +ENTER" using Keys.chord() method from KEYS class and assign it to a variable.
		
		String keyPressEvent = Keys.chord(Keys.COMMAND,Keys.ENTER);
		
		for(WebElement link: firstSectionLinks) {
			link.sendKeys(keyPressEvent);
		}
		
		Set<String> openLinkWindows = driver.getWindowHandles();
		
		for(String tab:openLinkWindows) {
			System.out.println(driver.switchTo().window(tab).getTitle());
		}

		driver.quit();

	}

}
