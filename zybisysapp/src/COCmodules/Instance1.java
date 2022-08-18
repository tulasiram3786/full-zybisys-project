package COCmodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Instance1 {
	

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abdul@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Zybisys@321");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.get("https://dev.zybisys.com/coc/manage/instance");
//		List<WebElement> TotalRowList=driver.findElements(By.xpath("//div[text()='Instance']/parent::div[1]/following::div[@class= 'center-text font500 ok_text']"));
//		System.out.println("The total number of rows are in the table are:"+TotalRowList.size());
		
		
		WebElement TogetRows = driver.findElements(By.xpath("//div[text()='Instance']/parent::div[1]/following::div[@class= 'center-text font500 ok_text']"));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
	}	

}
