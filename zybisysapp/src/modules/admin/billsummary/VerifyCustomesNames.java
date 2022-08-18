package modules.admin.billsummary;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyCustomesNames {
	WebDriver driver;


public void customer() throws Exception{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	/* dev Admin Login Script
	 * 
	 */
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
	
	driver.findElement(By.xpath("//a[@href='/customers']")).click();
	Thread.sleep(10000);
	List<WebElement> customerlist=driver.findElements(By.xpath("//tr/td[4]/div"));
	List<String> customerList=new ArrayList<>();
	for(int i=0; i<customerlist.size(); i++) {
//		System.out.println(customerlist.get(i).getText());
		customerList.add(customerlist.get(i).getText());
		
	}
	
//	WebDriverWait wait=new WebDriverWait(driver,30);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/bill-summary']")));
	driver.findElement(By.xpath("//a[@href='/bill-summary']")).click();
	Thread.sleep(1000);

	for(int i=0; i<customerList.size(); i++) {
//		System.out.println(customerList.get(i));
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys((customerList.get(i)));
		if(driver.findElements(By.xpath("//div[text()='"+customerList.get(i)+"']")).size()==0)
		{
			System.out.println(customerList.get(i)+ "is not displayed");
		}
	
	}
	
	
	
}
@Test
public void verifyCustomerDetails() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
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
	
	driver.findElement(By.xpath("//a[@href='/bill-summary']")).click();
	Thread.sleep(10000);
	
}

}
