package modules.admin.billsummary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
import modules.trisul.reports.TrisulReports;

public class VerifyBillSummary {
	WebDriver driver;

	@Test
	public void login() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev-admin-console.zybisys.com/bill-summary");
		Reporter.log(
				"navigated successfulluy to https://dev-admin-console.zybisys.com/bill-summary</br>");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@zybisys.com");
		Reporter.log("entered successfully email admin@zybisys.com </br>");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Zyb1&y&0");
		Reporter.log("entered succesfully password Zyb1&y&0 </br>");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.log("Clicked on login succesfully");

		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/bill-summary']")));
		driver.findElement(By.xpath("//a[@href='/bill-summary']")).click();
		Thread.sleep(1000);

	}
   //verify serverwise bills
	@Test
	public void verifyContractedBandwidth() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.CLEAR);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title='ZEBU SHARE AND WEALTH MANAGEMENTS PRIVATE LIMITED']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select month and year']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@placeholder='Select month and year']/following::td[@title='2022-03']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.CLEAR)	;
		driver.findElement(By.xpath("//span[@title='IN-MUM-WEST-1']")).click();
		driver.findElement(By.xpath("//span[text()='submit']")).click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']")));
		
		List<WebElement> instancerows=driver.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']"));
		System.out.println(instancerows.size());
        Reporter.log("<style>"
        		+ "table, th, td {"
        		+ "  border: 1px solid black;"
        		+ "}"
        		+ "</style>");
		Reporter.log("<table style=\"width:100%;border: 1px solid black; border-collapse: collapse;\">");
		Reporter.log(" <tr>"
				+ "<th>Instance Details</th>"
				+ "<th>Contracted Bandwidth</th>"
				+ "<th>Fixed Bandwidth</th>"
				+ "<th>Total Bandwidth</th>"
				+ "<th>Excess Bandwidth</th>"
				+ "<th>Balance Bandwidth</th>"
				+ "<th>Fixed Price (per GB)</th>"
				+ "<th>Excess Price (per GB)</th>"
				+ "  </tr>");
		Float totalFixedBandWidth = 0f;
		Float totalUsuageBandWidth = 0f;
		Float totalExcessBandWidth = 0f;
		Float totalBalance = 0f;
		Float totalfixedPrice = 0f;
		Float totalExcessprice = 0f;
		
		for(int i=0; i<instancerows.size();i++) {
			WebElement instance = instancerows.get(i);
			Reporter.log("<tr>");
			Reporter.log("<td>"+instance.findElement(By.xpath(".//td[1]/h5")).getText()+"</td>");
			System.out.print(instance.findElement(By.xpath(".//td[1]/h5")).getText() +" ");
			Reporter.log("<td>"+instance.findElement(By.xpath(".//td[2]/h5")).getText()+"</td>");
			System.out.print(instance.findElement(By.xpath(".//td[2]/h5")).getText() + " ");
			WebElement fixedBandWidth = instance.findElement(By.xpath(".//td[3]/h5"));
			Reporter.log("<td>"+fixedBandWidth.getText()+"</td>");
			System.out.print(fixedBandWidth.getText() + " ");
			WebElement totalBandWidth=instance.findElement(By.xpath(".//td[4]/h5"));
			//new TrisulReports(driver).getTrafficbandwidth(null, null)
			Reporter.log("<td>"+totalBandWidth.getText()+"</td>");
			System.out.print(totalBandWidth.getText() + " ");
			WebElement excessBandwidth=instance.findElement(By.xpath(".//td[5]/h5"));
			Float actualTotalBandWith = getBandWidthInGB(totalBandWidth.getText());
			Float actualFixedBandWith = getBandWidthInGB(fixedBandWidth.getText());
			Float actualExcessBandWith = getBandWidthInGB(excessBandwidth.getText());
			Float calcualtedExcessBandWith = actualTotalBandWith - actualFixedBandWith;
			
			calcualtedExcessBandWith = (calcualtedExcessBandWith<0) ? 0 : calcualtedExcessBandWith;
			//Reporter.log("<td> expected:("+actualTotalBandWith+"GB - "+actualFixedBandWith+"GB = "+calcualtedExcessBandWith+"GB),  actual:"+excessBandwidth.getText()+"</td>");
			Reporter.log("<td>"+excessBandwidth.getText()+"</td>");
			WebElement balanceBandwidthelement=instance.findElement(By.xpath(".//td[6]/h5"));
			Float balanceBandwidth= getBandWidthInGB(balanceBandwidthelement.getText());
			Float calcualtedBalanceBandWith=actualFixedBandWith-actualTotalBandWith;
			calcualtedBalanceBandWith = (calcualtedBalanceBandWith<0) ? 0 : calcualtedBalanceBandWith;
			//Reporter.log("<td> expected:("+actualFixedBandWith+"GB - "+actualTotalBandWith+"GB = "+calcualtedBalanceBandWith+"GB),  actual:"+balanceBandwidthelement.getText()+"</td>");
			Reporter.log("<td>"+balanceBandwidthelement.getText()+"</td>");
			System.out.print(excessBandwidth.getText() + " ");
			System.out.print(instance.findElement(By.xpath(".//td[6]/h5")).getText() + " ");
			WebElement FixedpriceWebElement=instance.findElement(By.xpath(".//td[7]/h5"));
			Float Fixedprice=Float.parseFloat(FixedpriceWebElement.getText().trim());
			Reporter.log("<td>"+FixedpriceWebElement.getText()+"</td>");
			System.out.print(FixedpriceWebElement.getText() + " ");
			WebElement excessPriceWebelement=instance.findElement(By.xpath(".//td[8]/h5"));
			Float calcualtedExcessPrice=actualExcessBandWith*Fixedprice;
			//Reporter.log("<td> expected:("+actualExcessBandWith+" * "+Fixedprice+" = "+calcualtedExcessPrice+"),  actual:"+excessPriceWebelement.getText()+"</td>");
			Reporter.log("<td>"+excessPriceWebelement.getText()+"</td>");
			System.out.print(instance.findElement(By.xpath(".//td[8]/h5")).getText() + " ");
			System.out.println();
			Reporter.log("</tr>");
			totalFixedBandWidth=actualFixedBandWith+totalFixedBandWidth;
			totalUsuageBandWidth=actualTotalBandWith+totalUsuageBandWidth;
			totalExcessBandWidth=actualExcessBandWith+totalExcessBandWidth;
			totalBalance=balanceBandwidth+totalBalance;
			totalExcessprice=Float.parseFloat(excessPriceWebelement.getText().trim())+totalExcessprice;
			
			
		};
		Reporter.log("<tr>");
		Reporter.log("<td>Summary</td>");
		Reporter.log("<td></td>");
		WebElement actualTotalfixedGB=driver.findElement(By.xpath("//tfoot[@class='ant-table-summary']/tr/td[3]"));
		//Reporter.log("<td>Expected:"+totalFixedBandWidth+"GB,actual:"+actualTotalfixedGB.getText()+"</td>");
		Reporter.log("<td>"+actualTotalfixedGB.getText()+"</td>");
		WebElement totalUsuageBandWidthGB=driver.findElement(By.xpath("//tfoot[@class='ant-table-summary']/tr/td[4]"));
		//Reporter.log("<td>Expected:"+totalUsuageBandWidth+"GB,actual:"+totalUsuageBandWidthGB.getText()+"</td>");
		Reporter.log("<td>"+totalUsuageBandWidthGB.getText()+"</td>");
		WebElement totalExcessBandWidthGB=driver.findElement(By.xpath("//tfoot[@class='ant-table-summary']/tr/td[5]"));
		//Reporter.log("<td>Expected:"+totalExcessBandWidth+"GB,actual:"+totalExcessBandWidthGB.getText()+"</td>");
		Reporter.log("<td>"+totalExcessBandWidthGB.getText()+"</td>");
		WebElement totalBalanceBandWidthGB=driver.findElement(By.xpath("//tfoot[@class='ant-table-summary']/tr/td[6]"));
		//Reporter.log("<td>Expected:"+totalBalance+"GB,actual:"+totalBalanceBandWidthGB.getText()+"</td>");
		Reporter.log("<td>"+totalBalanceBandWidthGB.getText()+"</td>");
		Reporter.log("<td></td>");
		WebElement totalExcesspriceGB=driver.findElement(By.xpath("//tfoot[@class='ant-table-summary']/tr/td[8]"));
		//Reporter.log("<td>Expected:"+totalExcessprice+"GB,actual:"+totalExcesspriceGB.getText()+"</td>");
		Reporter.log("<td>"+totalExcesspriceGB.getText()+"</td>");
		Reporter.log("</tr>");
		Reporter.log("</table>");
	    
	}
//	//Verify consolidateswise bills
//	@Test
//	public void consolidatedbills() throws InterruptedException {
//		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.CLEAR);
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[@title='COMPOSITE INVESTMENTS PRIVATE LIMITED - BROKING']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Select month and year']")).sendKeys(Keys.ENTER);
//		driver.findElement(By.xpath("//input[@placeholder='Select month and year']/following::td[@title='2022-03']")).click();
//		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.CLEAR)	;
//		driver.findElement(By.xpath("//span[@title='IN-MUM-WEST-1']")).click();
//		WebDriverWait wait=new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0'])[1]")));
//		List<WebElement>instancerows=driver.findElements(By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0'])[1]"));
//		System.out.println(instancerows.size());
//		 Reporter.log("<style>"
//	        		+ "table, th, td {"
//	        		+ "  border: 1px solid black;"
//	        		+ "}"
//	        		+ "</style>");
//			Reporter.log("<table style=\"width:100%;border: 1px solid black; border-collapse: collapse;\">");
//			Reporter.log(" <tr>"
//					+ "<th>Instance Details</th>"
//					+ "<th>Contracted Bandwidth</th>"
//					+ "<th>Fixed Bandwidth</th>"
//					+ "<th>Total Bandwidth</th>"
//					+ "  </tr>");
//	
//	
//		for(i=0; i<instancerows.size(); i++) {
//		WebElement instance = instancerows.get(i);
//		
//		System.out.print(instance.findElement(By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0'])[1]/td[2]")).getText());
//		System.out.print(instance.findElement(By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0'])[1]/td[3]")).getText());
//		System.out.print(instance.findElement(By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0'])[1]/td[4]")).getText());
//		WebElement excessBandwidth=instance.findElement(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0'])[1]/td[4]"));
//		Float actualTotalBandWith = getBandWidthInGB(totalBandWidth.getText());
//		Float actualFixedBandWith = getBandWidthInGB(fixedBandWidth.getText());
//		Float actualExcessBandWith = getBandWidthInGB(excessBandwidth.getText());
//	

	private Float getBandWidthInGB(String text) {
		if(text.contains("GB")) {
			return Float.parseFloat(text.replace("GB", "").trim());	
		}else if(text.contains("MB")) {
			return Float.parseFloat(text.replace("MB", "").trim())/1024;
		}else {
			return 0f;
		}
	}
}



