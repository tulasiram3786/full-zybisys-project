package modules.trisul.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import reporters.ReportUtil;

public class TrisulReports {

	WebDriver driver;

	public TrisulReports(WebDriver driver){
		this.driver = driver;
	}

	void createdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}


	public void getTrafficbandwidth(String ipaddress,String fromDate, String toDate, String receivedCoc, String transmittedCoc, String totalCoc) throws InterruptedException {
		/*
		 * Trisul Login
		 * 
		 */
		driver.get("http://10.192.1.53:3000/");
		Thread.sleep(1000);
		if (driver.getCurrentUrl().contains("login")) {
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("parameswari");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("S00TVa3U");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
		}
		driver.findElement(By.xpath("//a[contains(text(),' Reports')]")).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//a[contains(text(),' Readymade')]")));
		driver.findElement(By.xpath("//a[contains(text(),' Readymade')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='#reports_endpoints']")).click();
		driver.findElement(By.xpath("//input[@id=\"IP2\"]")).sendKeys(ipaddress);
		driver.findElement(
				By.xpath("//label[text()=' Static IP Report ']/parent::div/parent::div/parent::div/div[2]/ul/li[4]/a"))
				.click();
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].value=arguments[1]", driver.findElement(By.xpath("//input[@id=\"from_date\"]")), fromDate);
		((JavascriptExecutor)driver).executeScript("arguments[0].value=arguments[1]", driver.findElement(By.xpath("//input[@id=\"to_date\"]")), toDate);
		driver.findElement(By.xpath("//input[@id=\"to_date\"]")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.xpath("(//button[text()='Generate'][@type='submit'])[12]")).click();
		//driver.findElement(By.xpath("//label[text()=' Static IP Report ']/parent::div/parent::div/parent::div/div[2]/ul/li[3]/div/div/div/div[3]/btn")).click();
		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//h4[contains(text(),'Total Traffic')]")).getText();
		Float totalMb = getBandWidthInMb(text.replace("Total Traffic -", "").trim());
		String receivedStr = driver.findElement(By.xpath("//legend[contains(text(),'Received Traffic')]")).getText();
		Float receivedMb =  getBandWidthInMb(receivedStr.replace("Received Traffic -", ""));
		String transmittedStr = driver.findElement(By.xpath("//legend[contains(text(),'Transmit Traffic')]")).getText();
		Float transmittedMb =  getBandWidthInMb(transmittedStr.replace("Transmit Traffic -", ""));
		Float transmittedCocMb = getBandWidthInMb(transmittedCoc);
		Float receivedCocMb = getBandWidthInMb(receivedCoc);
		Float totalCocMb = getBandWidthInMb(totalCoc);
		ReportUtil.addRow();
		ReportUtil.addCell(ipaddress+" Total");
		ReportUtil.addCell(text.replace("Total Traffic -", "").trim());
		ReportUtil.addCell(totalCoc);
		ReportUtil.addCell(""+totalMb.equals(totalCocMb));
		ReportUtil.addRow();
		ReportUtil.addCell(ipaddress+" Received");
		ReportUtil.addCell(receivedStr.replace("Received Traffic -", ""));
		ReportUtil.addCell(receivedCoc);
		ReportUtil.addCell(""+receivedMb.equals(receivedCocMb));
		ReportUtil.addRow();
		ReportUtil.addCell(ipaddress+" Transmit");
		ReportUtil.addCell(transmittedStr.replace("Transmit Traffic -", ""));
		ReportUtil.addCell(transmittedCoc);
		ReportUtil.addCell(""+transmittedMb.equals(transmittedCocMb));
		
		
		
	}

	private Float getBandWidthInGB(String text) {
		if(text.contains("GB")) {
			return Float.parseFloat(text.replace("GB", "").trim());	
		}else if(text.contains("MB")) {
			return Float.parseFloat(text.replace("MB", "").trim())/1000;
		}else {
			return 0f;
		}
	}
	
	private Float getBandWidthInMb(String text) {
		if(text.contains("GB")) {
			return Float.parseFloat(text.replace("GB", "").trim())*1000;	
		}else if(text.contains("MB") ||text.contains("MB")) {
			return Float.parseFloat(text.replace("MB", "").trim());
		}else if(text.contains("KB")) {
			return Float.parseFloat(text.replace("KB", "").trim())/1000;
		}else if(text.contains("Bytes")){
			return Float.parseFloat(text.replace("Bytes", "").trim())/1000/1000;
		}if(text.contains("B")){
			return Float.parseFloat(text.replace("B", "").trim())/1000/1000;
		}else {
			System.out.println(text);
			return 0f;
		}
	}
}
