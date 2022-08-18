package modules.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyCustomer {
   WebDriver driver;
	@Test
	public void login() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://uat-admin-console.zybisys.com/customers/details/5eb25f0c37ad1d2e13d2abf9");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@zybisys.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Zyb1&y&0");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/bill-summary']")));
		driver.findElement(By.xpath("//a[@href='/bill-summary']")).click();
		Thread.sleep(1000);
	}
	public void ServerwiseBills() throws InterruptedException  {
		
		
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(Keys.CLEAR);
		driver.findElement(By.xpath("//div[text()='TRADEJINI FINANCIAL SERVICES PRIVATE LIMITED']")).click();
	

}
}
