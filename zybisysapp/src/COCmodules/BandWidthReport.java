package COCmodules;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.Element;
import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import modules.trisul.reports.TrisulReports;
import reporters.CsvReporter;
import reporters.ReportUtil;

public class BandWidthReport {
	public static String UserName = "abdul@gmail.com";
	public static String password = "Zybisys@321";

   @Test
	public static void main() throws InterruptedException {
	  
	    
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(3000);
		
		CsvReporter.addData("'26-07-2022 00:00'");
		CsvReporter.addData("'27-07-2022 23:59'");
		
		 
		driver.get("https://dev.zybisys.com/coc/reports/bandwidth");
		Thread.sleep(2000);
/*
 * COC Module bandwidth selecting date and time from date the calender Script
 * 
 */
		String inputXpath = "//label[text()='From']/following::div[1]/input";
		String dateXpath  =         "(//input[@type='text']/following::span[text()='July, 2022']/following::button/following::table/tbody/tr/td[text()='26'])[2]";
		String timetextXpath = "(//div[@class=\"show-time\"]/span)[1]";
		String handleXpath = "(//div[contains(@class,\"handle handle-0\")])[1]";
		String timeValue = "00";
		String handleXpath1 ="(//div[contains(@class,\"handle handle-0\")])[2]";
		String timeValue1 = "00";
		String timetextXpath1 = "(//div[@class=\"show-time\"]/span)[3]";
		String currentMonthXpath = "(//div[@class='calendar-months']/table/tbody/tr/td[text()='Jul'])[1]";
		String currentMonthSelXpath = "(//div[@class='calendar-nav']/span[@class='current-date'])[1]";
		selectDateandTime(driver, inputXpath, dateXpath, timetextXpath, handleXpath, timeValue,
				timetextXpath1, handleXpath1, timeValue1, currentMonthXpath, currentMonthSelXpath, true);
	/*
	 * To date calender script
	 * 			
	 */
		inputXpath = "//label[text()='To']/following::div[1]/input";
		dateXpath  =         "(//input[@type='text']/following::span[text()='July, 2022']/following::button/following::table/tbody/tr/td[text()='27'])[4]";
		timetextXpath = "(//div[@class=\"show-time\"]/span)[4]";
		handleXpath = "(//div[contains(@class,\"handle handle-0\")])[3]";
		timeValue = "23";
		handleXpath1 ="(//div[contains(@class,\"handle handle-0\")])[4]";
		timeValue1 = "59";
		timetextXpath1 = "(//div[@class=\"show-time\"]/span)[6]";
		currentMonthXpath = "(//div[@class='calendar-months']/table/tbody/tr/td[text()='Jul'])[2]";
		currentMonthSelXpath = "(//div[@class='calendar-nav']/span[@class='current-date'])[3]";
		selectDateandTime(driver, inputXpath, dateXpath, timetextXpath, handleXpath, timeValue, timetextXpath1, handleXpath1, timeValue1,
				currentMonthXpath, currentMonthSelXpath, false);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Run Report']")).click();
		Thread.sleep(10000);
		
		/*
		 * Selecting IPList, Recevied, transmitted, Total Bandwidth Script
		 * 
		 */
		/*
		 * Xpath for IPList
		 */
		 
		List<WebElement> elements = driver.findElements(
				By.xpath("//tr/td[contains(@class,'MuiTableCell-root MuiTableCell-body')][2]"));
		List<String> ipsList = elements.stream().map(element -> element.getText()).collect(Collectors.toList());
		/*
		 * Xpath for received bandwidth
		 */
		List<String> received = driver
				.findElements(By.xpath(
						"//tr/td[contains(@class,'MuiTableCell-root MuiTableCell-body')][3]"))
				.stream().map(element -> element.getText()).collect(Collectors.toList());
		/*
		 * Xpath for Transmitted Bandwidth
		 * 
		 */
		List<String> transmitted = driver
				.findElements(By.xpath(
						"//tr/td[contains(@class,'MuiTableCell-root MuiTableCell-body')][4]"))
				.stream().map(element -> element.getText()).collect(Collectors.toList());
		/*
		 * Xpath for Total bandwidth
		 * 
		 */
		List<String> total = driver
				.findElements(By.xpath(
						"//tr/td[contains(@class,'MuiTableCell-root MuiTableCell-body')][5]"))
				.stream().map(element -> element.getText()).collect(Collectors.toList());
		ReportUtil.addCell("Received Bandwith comparison with Top Apps");
		ReportUtil.addRow();
		ReportUtil.createTableWithHeader(new String[] { "IPaddress", "Bandwith","Top Apps", "Expected status", "Status"});
		
		for (int j = 0; j < ipsList.size(); j++) {
			Float totalMB = new TopApps().getRecevedGbForIpAddress(driver, ipsList.get(j)); //top apps and receiced in bandwidth
			Boolean receivedBandthEqual = getBandWidthInMb(received.get(j))==totalMB;
			ReportUtil.addCell(ipsList.get(j));
			if(receivedBandthEqual){
				System.out.println(ipsList.get(j)+"Bandwidth receved "+totalMB+" MB == "+ received.get(j));
			}else {
				System.out.println(ipsList.get(j)+"Bandwidth receved "+totalMB+" MB != "+ received.get(j));
			}
			ReportUtil.addCell(received.get(j)+"");
			ReportUtil.addCell(totalMB+"");
			ReportUtil.addCell("pass");
			ReportUtil.addCell(!receivedBandthEqual ? "failed":"passed", !receivedBandthEqual ? "color:red":"color:green");
			ReportUtil.endRow();
		}
		ReportUtil.addCell("Received Bandwith comparison with Iptracking");
		ReportUtil.addRow();
		ReportUtil.createTableWithHeader(new String[] { "IPaddress", "Bandwith","Ip tracking", "Expected status", "Status"});
		/*
		 * Recevied Bandwidth Calculation Script
		 * 
		 */
		for (int j = 0; j < ipsList.size(); j++) {
			Float totalIpTrackingMb = IpTracking.getRecevedGbForIpAddress(driver, ipsList.get(j));  //iptracking and receiced in bandwidth
			Boolean iptrackingEqual = getBandWidthInMb(received.get(j))==totalIpTrackingMb;
			if(iptrackingEqual){
				System.out.println(ipsList.get(j)+"Iptracking received "+totalIpTrackingMb+" MB == "+ received.get(j));
			}else {
				System.out.println(ipsList.get(j)+"Iptracking received "+totalIpTrackingMb+" MB != "+ received.get(j));
			}
			ReportUtil.addCell(ipsList.get(j));
			ReportUtil.addCell(received.get(j)+"");
			ReportUtil.addCell(totalIpTrackingMb+"");
			ReportUtil.addCell("pass");
			ReportUtil.addCell(!iptrackingEqual ? "failed":"passed", !iptrackingEqual ? "color:red":"color:green");
			ReportUtil.endRow();
		}
		
		ReportUtil.endTable();
		
		
		/*
		 * Transmitted Bandwidth Calculation Script
		 * 
		 */
		
		for (int j = 0; j < ipsList.size(); j++) {
			Float totalMB = new TopApps().getTransmittedGbForIpAddress(driver, ipsList.get(j));  // top apps and bandwidth transmitted
			Boolean transmittedBandthEqual = getBandWidthInMb(transmitted.get(j))==totalMB;
			ReportUtil.addCell(ipsList.get(j));
			if(transmittedBandthEqual){
				System.out.println(ipsList.get(j)+"Bandwidth transmitted "+totalMB+" MB == "+ transmitted.get(j));
			}else {
				System.out.println(ipsList.get(j)+"Bandwidth transmitted "+totalMB+" MB != "+ transmitted.get(j));
			}
			ReportUtil.addCell(transmitted.get(j)+"");
			ReportUtil.addCell(totalMB+"");
			ReportUtil.addCell("pass");
			ReportUtil.addCell(!transmittedBandthEqual ? "failed":"passed", !transmittedBandthEqual ? "color:red":"color:green");
			ReportUtil.endRow();
		}
		
		
		ReportUtil.addCell("transmitted Bandwith comparison with IpTracking");
		ReportUtil.addRow();
		ReportUtil.createTableWithHeader(new String[] { "IPaddress", "Bandwith","Ip tracking", "Expected status", "Status"});
		for (int j = 0; j < ipsList.size(); j++) {
			Float totalIpTrackingMb = IpTracking.getTranmittedGbForIpAddress(driver, ipsList.get(j)); // ip tracking and bandwidth transmitted
			Boolean iptrackingEqual = getBandWidthInMb(transmitted.get(j))==totalIpTrackingMb;
			if(iptrackingEqual){
				System.out.println(ipsList.get(j)+"Iptracking transmitted "+totalIpTrackingMb+" MB == "+ transmitted.get(j));
			}else {
				System.out.println(ipsList.get(j)+"Iptracking transmitted "+totalIpTrackingMb+" MB != "+ transmitted.get(j));
			}
			ReportUtil.addCell(ipsList.get(j));
			ReportUtil.addCell(transmitted.get(j)+"");
			ReportUtil.addCell(totalIpTrackingMb+"");
			ReportUtil.addCell("pass");
			ReportUtil.addCell(!iptrackingEqual ? "failed":"passed", !iptrackingEqual ? "color:red":"color:green");
			ReportUtil.endRow();
		}
		
		ReportUtil.endTable();
				

   for (int j = 0; j < ipsList.size(); j++) {
		Float totalMB = new TopApps().getTotalGbForIpAddress(driver, ipsList.get(j)); //top apps and bandwidth total 
		Boolean totalBandthEqual = getBandWidthInMb(total.get(j))==totalMB;
		ReportUtil.addCell(ipsList.get(j));
		if(totalBandthEqual){
			System.out.println(ipsList.get(j)+"Bandwidth total "+totalMB+" MB == "+ total.get(j));
		}else {
			System.out.println(ipsList.get(j)+"Bandwidth total "+totalMB+" MB != "+ total.get(j));
		}
		ReportUtil.addCell(total.get(j)+"");
		ReportUtil.addCell(totalMB+"");
		ReportUtil.addCell("pass");
		ReportUtil.addCell(!totalBandthEqual ? "failed":"passed", !totalBandthEqual ? "color:red":"color:green");
		ReportUtil.endRow();
	}
	ReportUtil.addCell("total Bandwith comparison with Iptracking");
	ReportUtil.addRow();
	ReportUtil.createTableWithHeader(new String[] { "IPaddress", "Bandwith","Ip tracking", "Expected status", "Status"});
	for (int j = 0; j < ipsList.size(); j++) {
		Float totalIpTrackingMb = IpTracking.getTotalGbForIpAddress(driver, ipsList.get(j)); // ip tracking and bandwidth total
		Boolean iptrackingEqual = getBandWidthInMb(transmitted.get(j))==totalIpTrackingMb;
		if(iptrackingEqual){
			System.out.println(ipsList.get(j)+"Iptracking total "+totalIpTrackingMb+" MB == "+ total.get(j));
		}else {
			System.out.println(ipsList.get(j)+"Iptracking total "+totalIpTrackingMb+" MB != "+ total.get(j));
		}
		ReportUtil.addCell(ipsList.get(j));
		ReportUtil.addCell(total.get(j)+"");
		ReportUtil.addCell(totalIpTrackingMb+"");
		ReportUtil.addCell("pass");
		ReportUtil.addCell(!iptrackingEqual ? "failed":"passed", !iptrackingEqual ? "color:red":"color:green");
		ReportUtil.endRow();
	}
	
	ReportUtil.endTable();
   }
	
	private static Float getBandWidthInMb(String text) {
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
   
   public static void selectDateandTime(WebDriver driver , String inputXpath, String dateXpath, 
			String timetextXpath1, String handleXpath1,
			String timeValue1, String timetextXpath2, String handleXpath2, String timeValue2,
			String currentMonthXpath, String currentMonthSelXpath,  Boolean isFrom) throws InterruptedException {
	   	driver.findElement(By.xpath(inputXpath)).click();
		Thread.sleep(2000);
	   ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath(currentMonthSelXpath)));
		Thread.sleep(1000);
		driver.findElement(By.xpath(currentMonthXpath)).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(dateXpath)).click();

		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		WebElement elementText = driver.findElement(By.xpath(timetextXpath1));
		int i = 1;
		while (!elementText.getText().equals(timeValue1)) {
			WebElement element = driver.findElement(By.xpath(handleXpath1));
			int width = isFrom ? (elementText.getSize().getWidth() - i * 5): (elementText.getSize().getWidth() + i * 2);
			actions.clickAndHold(element)
					.moveByOffset(width, elementText.getSize().getHeight()).release()
					.build().perform();
			elementText = driver.findElement(By.xpath(timetextXpath1));
			i++;
		}
		
		WebElement elementText1 = driver.findElement(By.xpath(timetextXpath2));
		i = 1;
		while (!elementText1.getText().equals(timeValue2)) {
			WebElement element = driver.findElement(By.xpath(handleXpath2));
			int width = isFrom ? (elementText1.getSize().getWidth() - i * 5): (elementText1.getSize().getWidth() + i * 2);
			actions.clickAndHold(element)
					.moveByOffset(width, elementText1.getSize().getHeight()).release()
					.build().perform();
			elementText1 = driver.findElement(By.xpath(timetextXpath2));
			i++;
	
		}
	}

}
