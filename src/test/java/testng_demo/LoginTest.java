package testng_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	public void test1() throws InterruptedException {
		
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver","chromedriver2.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(LoginLink));
		
		LoginLink.click();
		
		Thread.sleep(4000);
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abc@12345");
		
		WebElement Remember =driver.findElement(By.className("rememberMe"));
		Remember.click();
		
		WebElement LoginButton = driver.findElement(By.name("btn_login"));
		LoginButton.click();
		
		WebElement Error = driver.findElement(By.id("msg_box"));
		
		String ActualMsg = Error.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
		driver.quit();
		
	}

}
