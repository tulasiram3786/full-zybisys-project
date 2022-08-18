package zybisysapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Report1 {
	public static String userName = "abdul@gmail.com";
	public static String passWord = "Zybisys@321";

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(passWord);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(2000);
		driver.get("https://dev.zybisys.com/coc/reports/bandwidth");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='From']/following::div/input[@type='text'])[1]")).click();
		driver.findElement(By.xpath("//td[text()='20']")).click();
		Actions actions = new Actions(driver);
		WebElement elementText = driver.findElement(By.xpath("(//div[@class='show-time']/following::span)[1]"));
		int i=1;
		while(!elementText.getText().equals("00")) {
			WebElement element = driver.findElement(By.xpath("(//div[@class='handle handle-0 '])[1]"));
			actions.clickAndHold(element).moveByOffset(elementText.getSize().getWidth()-i*5,elementText.getSize().getHeight()).release().build().perform();
			elementText = driver.findElement(By.xpath("(//div[@class='show-time']/following::span)[1]"));
			i++;
		}
		WebElement elementText1 =  driver.findElement(By.xpath("(//div[@class='show-time']/span)[3]"));
		i=1;
		while(!elementText1.getText().equals("00")) {
			WebElement elements = driver.findElement(By.xpath("(//div[@class='handle handle-0 '])[2]"));
			actions.clickAndHold(elements).moveByOffset(elementText1.getSize().getWidth()-i*5, elementText1.getSize().getHeight()).release().build().perform();
			elementText1 =  driver.findElement(By.xpath("(//div[@class='show-time']/span)[3]"));
			i++;
		}
		driver.findElement(By.xpath("//label[text()='To']/following::div/input[@type='text']")).click();
		driver.findElement(By.xpath("(//td[text()='21'])[2]")).click();
		
	}

}
