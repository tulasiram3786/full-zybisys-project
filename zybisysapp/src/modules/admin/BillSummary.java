package modules.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BillSummary {

	@Test
	public static void main() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat-admin-console.zybisys.com/customers/details/5eb25f0c37ad1d2e13d2abf9");
		Reporter.log("navigated successfulluy to https://uat-admin-conssole.zybisys.com/customers/details/5eb25f0c37ad1d2e13d2abf9</br>");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@zybisys.com");
		Reporter.log("entered successfully email admin@zybisys.com </br>");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Zyb1&y&0");
		Reporter.log("entered succesfully password Zyb1&y&0 </br>");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.log("Clicked on login succesfully");

		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		//Admin Bill summary page
		
		driver.findElement(By.xpath("//a[@href='/bill-summary']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='ZEBU SHARE AND WEALTH MANAGEMENTS PRIVATE LIMITED']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select month and year']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//td[@title='2022-03']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='IN-MUM-WEST-1'])[2]")).click();
		Thread.sleep(1000);
		String str =driver.findElement(By.xpath("//h5[text()='AliceBlu36873']")).getText();
		System.out.println("str");
		
//		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[text()='ZEBU SHARE AND WEALTH MANAGEMENTS PRIVATE LIMITED']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Select month and year']")).sendKeys(Keys.ENTER);
//		driver.findElement(By.xpath("//td[@title='2022-03']")).click();
//		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
//		driver.findElement(By.xpath("(//div[text()='IN-MUM-WEST-1'])[2]")).click();
	}
}
