package modules.admin;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Customers {
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
		
		
		driver.findElement(By.xpath("//a[@href='/customers']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@type='button']/span[text()='Add Customers']")).click();
		driver.findElement(By.xpath(" //input[@name='user_name']")).sendKeys("parameswari");
		driver.findElement(By.xpath("//input[@name='user_company']")).sendKeys("zybisys.com");
		driver.findElement(By.xpath("//input[@name='user_email']")).sendKeys("parameswarijittim@gmail.com");
		driver.findElement(By.xpath("//input[@id='user_phone']")).sendKeys("8217380728");
		driver.findElement(By.xpath("//input[@placeholder='Enter Street']")).sendKeys("micolayout");
		driver.findElement(By.xpath("//input[@placeholder='Enter City']")).sendKeys("bangalore");
		driver.findElement(By.xpath("//input[@placeholder='Enter State']")).sendKeys("karnataka");
		driver.findElement(By.xpath("//input[@id='user_address_country']")).sendKeys("india");
		driver.findElement(By.xpath("//input[@id='user_address_zipcode']")).sendKeys("560016");
		driver.findElement(By.xpath("//input[@id='user_gst']")).sendKeys("234657568899");
		driver.findElement(By.xpath("//*[local-name()='circle']/parent::*[local-name()='svg']/parent::td[@class='ant-table-cell']")).click();
		driver.findElement(By.xpath("//span[@class='ant-dropdown-menu-title-content']/following::a")).click();
		
		
	}

}
