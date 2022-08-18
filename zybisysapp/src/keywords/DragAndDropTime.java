package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropTime {
	public static String  UserName="abdul@gmail.com";
	public static String password ="Zybisys@321";
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(3000);
		driver.get("https://dev.zybisys.com/coc/reports/ip_tracking");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[text()='From']/following::div[1]/input")).click();
		driver.findElement(By.xpath("(//td[text()='14'])[1]")).click();
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		WebElement elementText = driver.findElement(By.xpath("(//div[@class=\"show-time\"]/span)[1]"));
		int i=1;
		while(!elementText.getText().equals("00")){
			WebElement element = driver.findElement(By.xpath("(//div[contains(@class,\"handle handle-0\")])[1]"));
			actions.clickAndHold(element).moveByOffset(elementText.getSize().getWidth()-i*5, elementText.getSize().getHeight()).release().build().perform();
			elementText = driver.findElement(By.xpath("(//div[@class=\"show-time\"]/span)[1]"));
			i++;
		}
		
		
		WebElement elementText2 = driver.findElement(By.xpath("(//div[@class=\"show-time\"]/span)[3]"));
		i=1;
		while(!elementText2.getText().equals("00")){
			WebElement element = driver.findElement(By.xpath("(//div[contains(@class,\"handle handle-0\")])[2]"));
			actions.clickAndHold(element).moveByOffset(elementText2.getSize().getWidth()-i*5, elementText2.getSize().getHeight()).release().build().perform();
			elementText2 = driver.findElement(By.xpath("(//div[@class=\"show-time\"]/span)[3]"));
			i++;
		}
		driver.findElement(By.xpath("//label[text()='To']/following::div[1]/input")).click();
		driver.findElement(By.xpath("(//td[text()='15'])[2]")).click();
		
		WebElement elementText3 = driver.findElement(By.xpath("(//div[@class='show-time']/span)[4]"));
		i=1;
		while(!elementText3.getText().equals("23")) {
			WebElement element = driver.findElement(By.xpath("(//div[contains(@class, 'handle handle-0')])[3]"));
			actions.clickAndHold(element).moveByOffset(elementText3.getSize().getWidth()+i*5, elementText3.getSize().getHeight()).release().build().perform();
			elementText3 = driver.findElement(By.xpath("(//div[@class='show-time']/span)[4]"));
			i++;
		}
		WebElement elementText4 = driver.findElement(By.xpath("(//div[@class='show-time']/span)[6]"));
		i=1;
		while(!elementText4.getText().equals("59")) {
			WebElement element = driver.findElement(By.xpath("(//div[contains(@class, 'handle handle-0')])[4]"));
			actions.clickAndHold(element).moveByOffset(elementText4.getSize().getWidth()+i*5, elementText4.getSize().getHeight()).release().build().perform();
			elementText4 = driver.findElement(By.xpath("(//div[@class='show-time']/span)[6]"));
			i++;
		}
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//span[text()='Public IP']")).click();
		driver.findElement(By.xpath("(//div[@class='calendar-days'])[1]"));
		
		Select s1 = new  Select(driver.findElement(By.xpath("//select[option='All']")));
		s1.selectByIndex(2);
		
		driver.findElement(By.xpath("//span[text()='Run Report']")).click();
	}
	


		
	}


