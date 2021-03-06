package selenium;

import org.openqa.selenium.By;

public class SelectorExampleWith$ extends Main {

	public static Main main = new Main();

	public static void main(String[] args) throws InterruptedException {
		// There is another way to validate in Chrome and Firefox if the xpath/css
		// constructed is correct.
		// $("") => is for CSS
		// $x("") => is for XPAth

		// The following code is constructed usng the XPath and CSS selector option that
		// is available in the browser without using plugins.
		
		validateFaceBookSigninPage();
		
		validateSalesForceErrorMessage();

		main.quitAll();

	}

	public static void validateFaceBookSigninPage() {

		main.loadFaceBookPage();

		main.driver.findElement(By.id("email")).sendKeys("someoneemail.email.com");

		main.driver.findElement(By.name("pass")).sendKeys("somepassword");

		main.driver.findElement(By.xpath("//*[@id='login_form']/table/tbody/tr[3]/td[2]/div/a")).click();

		main.driver.navigate().back();

		System.out.println(main.driver.findElement(By.cssSelector("i.fb_logo.img.sp_Vgu5hh_52BR.sx_445ecd")).getText());

	}

	public static void validateSalesForceErrorMessage() throws InterruptedException {

		main.loadSalesForceLoginPage();
		
		main.driver.findElement(By.id("username")).sendKeys("someone@email.com");
		
		main.driver.findElement(By.name("pw")).sendKeys("password");
		
		main.driver.findElement(By.xpath("//*[@id='Login']")).click();
		
		Thread.sleep(1000);
		
		System.out.println(main.driver.findElement(By.id("error")).getText());
		

	}
	
	

}
