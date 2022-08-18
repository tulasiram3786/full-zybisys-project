package modules.vmmaster;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.Elements;
import data.TestData;
import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import keywords.Click;
import modules.components.Login;
import reporters.CsvReporter;
import reporters.ReportUtil;

public class VmMaster {

	@Test
	
	void vmMaster() throws InterruptedException {
		CsvReporter.getReporter();
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://dev-admin-console.zybisys.com/vm-masters");
		Reporter.log(
				"navigated successfulluy to https://uat-admin-console.zybisys.com/customers/details/5eb25f0c37ad1d2e13d2abf9</br>");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@zybisys.com");
		Reporter.log("entered successfully email admin@zybisys.com </br>");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Zyb1&y&0");
		Reporter.log("entered succesfully password Zyb1&y&0 </br>");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.log("Clicked on login succesfully");

		driver.manage().window().maximize();
		Thread.sleep(10000);
/*
 *  Adding VM Master Script
 */
		driver.findElement(By.xpath("//a[@href='/vm-masters']")).click();
		driver.findElement(By.xpath("//span[text()='Add Servers']")).click();
		Thread.sleep(3000);
		WebDriverWait w = (new WebDriverWait(driver, 7));
		w.until(ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("//h5[text()='Select Customer']/following::div[1]/div/span/input[@type='search']")));
		driver.findElement(By.xpath("//h5[text()='Select Customer']/following::div[1]/div/span/input[@type='search']"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@title='Dummy FINANCIAL SERVICES PRIVATE LIMITED']")).click();

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.CLEAR);
		driver.findElement(By.xpath("//input[@id='vm_hostname']")).sendKeys("windows");
		driver.findElement(By.xpath("//input[@id='vm_os']")).sendKeys("centos");
		driver.findElement(By.xpath("//input[@placeholder='Enter CPU Core']")).sendKeys("16GB");
		driver.findElement(By.xpath("//input[@id='vm_ram']")).sendKeys("16GB");
		driver.findElement(By.xpath("//input[@id='vm_hdd']")).sendKeys("300GB");
		driver.findElement(By.xpath("//input[@id='vm_lan_ip']")).sendKeys("10.193.8.6");
		driver.findElement(By.xpath("//input[@id='vm_wan_ip']")).sendKeys("10.193.8.8");
		WebElement element = driver.findElement(By.xpath("//span[text()='Submit']/parent::button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		
		driver.findElement(By.xpath("//span[text()='Submit']/parent::button")).click();
		Thread.sleep(2000);
		boolean haserror = driver.findElement(By.xpath("//body")).getText().toLowerCase()
				.contains("Something went wrong".toLowerCase());
		ReportUtil.addRow();

		ReportUtil.addCell("Addserver");
		
		ReportUtil.addCell("pass");

		ReportUtil.addCell(haserror ? "fail" : "pass");
		ReportUtil.addCell(haserror ? "fail" : "pass");
		ReportUtil.addRow();

		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Widzet", "VMlist", "Status" });
		driver.get("https://dev-admin-console.zybisys.com/vm-masters");
		verifyCounts(driver);
		ReportUtil.addRow();
		ReportUtil.addCell("IN-MUM-WEST-1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.xpath("(//div[@title='IN-MUM-WEST-1'])"));
		js.executeScript("arguments[0].click();", button);

		verifyCounts(driver);
		ReportUtil.addRow();
		ReportUtil.addCell("IN-MUM-WEST-2");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement buttons = driver.findElement(By.xpath("(//div[@title='IN-MUM-WEST-2'])"));
		js.executeScript("arguments[0].click();", buttons);

		verifyCounts(driver);
		driver.navigate().to("https://dev-admin-console.zybisys.com/vm-masters");
		ReportUtil.addRow();
		ReportUtil.addCell("Server ON");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys(Keys.ENTER);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		WebElement buttons1 = driver.findElement(By.xpath("(//div[@title='Server ON'])"));
		js.executeScript("arguments[0].click();", buttons1);

		verifyCounts(driver);

		ReportUtil.addRow();
		ReportUtil.addCell("Server OFF");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys(Keys.ENTER);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		WebElement buttons2 = driver.findElement(By.xpath("(//div[@title='Server OFF'])"));
		js.executeScript("arguments[0].click();", buttons2);
		verifyCounts(driver);

		driver.navigate().to("https://dev-admin-console.zybisys.com/vm-masters");
		ReportUtil.addRow();
		ReportUtil.addCell("Virtual Instances");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys(Keys.ENTER);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		WebElement buttons4 = driver.findElement(By.xpath("(//div[@title='Virtual Instances'])"));
		js.executeScript("arguments[0].click();", buttons4);
		verifyCounts(driver);
		ReportUtil.addRow();
		ReportUtil.addCell("Physical Instances");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys(Keys.ENTER);
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		WebElement buttons5 = driver.findElement(By.xpath("(//div[@title='Physical Instances'])"));
		js.executeScript("arguments[0].click();", buttons5);
		
		
		
		verifyCounts(driver);
		driver.navigate().to("https://dev-admin-console.zybisys.com/vm-masters");
		ReportUtil.addRow();
		ReportUtil.addCell("Untagged Servers");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//p[text()='Untagged Servers'])")).click();
		
		JavascriptExecutor js7 = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		WebElement buttons6 = driver.findElement(By.xpath("(//button[@class='ant-switch'])"));
		js.executeScript("arguments[0].click();", buttons6);
		
        
		verifyCounts(driver);

	}

	public void verifyCounts(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		int total = Integer.parseInt(driver
				.findElement(By.xpath("//h4[text()='Total Machines']/following::div[2]/following::h4[1]")).getText());
		int totalvmscount = driver.findElements(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']")).size();
		ReportUtil.addRow();
		ReportUtil.addCell("Total vms Count");
		ReportUtil.addCell(totalvmscount + "");
		ReportUtil.addCell(total + "");
		ReportUtil.addCell((total == totalvmscount) + "");
		if (total == totalvmscount) {
			System.out.println("total vms count in widzet " + total + " is matched with list count " + totalvmscount);
		} else {
			System.out
					.println("total vms count in widzet " + total + " is not matched with list count " + totalvmscount);
		}
		int poweredonvms = Integer.parseInt(driver
				.findElement(By.xpath("//h4[text()='Virtual Machines']/following::div[1]/div[1]/div/h4")).getText());
		int poweredonvmscount = driver.findElements(By.xpath(
				"//*[local-name()='svg'][@style='color: green;']/following::td[2]/span/span[text()='Virtual Machine']"))
				.size();
		ReportUtil.addRow();
		ReportUtil.addCell("poweredonvms");
		ReportUtil.addCell(poweredonvmscount + "");
		ReportUtil.addCell(poweredonvms + "");
		ReportUtil.addCell((poweredonvms == poweredonvmscount) + "");
		if (poweredonvms == poweredonvmscount) {
			System.out.println(" powered on vms count in widget " + poweredonvms + " is matched with list count "
					+ poweredonvmscount);
		} else {
			System.err.println(" powered on vms count in widget " + poweredonvms + " is not matched with list count "
					+ poweredonvmscount);
		}
		int poweredoffvms = Integer.parseInt(driver
				.findElement(By.xpath("//h4[text()='Virtual Machines']/following::div[1]/div[2]/div/h4")).getText());
		int poweredoffvmscount = driver.findElements(By.xpath(
				"//*[local-name()='svg'][@style='color: red;']/following::td[2]/span/span[text()='Virtual Machine']"))
				.size();
		ReportUtil.addRow();
		ReportUtil.addCell("poweredoffvms");
		ReportUtil.addCell(poweredoffvmscount + "");
		ReportUtil.addCell(poweredoffvms + "");
		ReportUtil.addCell((poweredoffvms == poweredoffvmscount) + "");
		if (poweredoffvms == poweredoffvmscount) {
			System.out.println(" powered off vms count in widget " + poweredoffvms + " is matched with list count "
					+ poweredoffvmscount);
		} else {
			System.out.println(" powered off vms count in widzet " + poweredoffvms + " is not matched with list count "
					+ poweredoffvmscount);
		}
		int poweredonvmspm = Integer.parseInt(driver
				.findElement(By.xpath("//h4[text()='Physical Machines']/following::div/div/div/div/following::h4[1]"))
				.getText());
		int poweredonvmspmcount = driver.findElements(By.xpath(
				"//*[local-name()='svg'][@style='color: green;']/following::td[2]/span/span[text()='Physical Machine']"))
				.size();
		ReportUtil.addRow();
		ReportUtil.addCell("poweredonvmspm");
		ReportUtil.addCell(poweredonvmspmcount + "");
		ReportUtil.addCell(poweredonvmspm + "");
		ReportUtil.addCell((poweredonvmspm == poweredonvmspm) + "");
		if (poweredonvmspm == poweredonvmspm) {
			System.out.println("powered on vms count in widzet " + poweredonvmspm + " is matched with list count "
					+ poweredonvmspmcount);
		} else {
			System.out.println(" powered off vms count in widzet " + poweredonvmspm + " is not matched with list count "
					+ poweredonvmspmcount);
		}
		int poweredoffvmspm = Integer.parseInt(
				driver.findElement(By.xpath("//h4[text()='Physical Machines']/following::div[7]/following::h4[1]"))
						.getText());
		int poweredoffvmspmcount = driver.findElements(By.xpath(
				"//*[local-name()='svg'][@style='color: red;']/following::td[2]/span/span[text()='Physical Machine']"))
				.size();
		ReportUtil.addRow();
		ReportUtil.addCell("poweredoffvmspm");
		ReportUtil.addCell(poweredoffvmspmcount + "");
		ReportUtil.addCell(poweredoffvmspm + "");
		ReportUtil.addCell((poweredoffvmspm == poweredoffvmspm) + "");
		if (poweredoffvmspm == poweredoffvmspm) {
			System.out.println("powered off vms count in widzet " + poweredoffvmspm + " is matched with list count "
					+ poweredoffvmspmcount);
		} else {
			System.out.println(" powered off vms count in widzet " + poweredoffvmspm
					+ " is not matched with list count " + poweredoffvmscount);
		}

	}
}
