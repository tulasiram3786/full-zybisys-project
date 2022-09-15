package COCmodules;

import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v97.browser.Browser;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.Elements;
import data.TestData;
import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import keywords.Backbutton;
import keywords.Click;
import keywords.CompareTexts;
import keywords.Count;
import keywords.GetListText;
import keywords.GetText;
import keywords.GetUrl;
import keywords.GetValue;
import keywords.GoTo;
import keywords.Keys;
import keywords.Scroll;
import keywords.SendData;
import keywords.Verify;
import keywords.VerifyCurrentURL;
import keywords.Wait;
import modules.components.Login;
import reporters.CsvReporter;
import reporters.ReportUtil;

public class DashBoard {

	TestData testData = new TestData();
	String moduleName ="dashboard";
	
	Elements elements = Elements.getElements();
	
	 
	public String getTestData(String parameter) {
		return testData.getTestDataValue(moduleName, parameter);
	}
	public String[] getTestDataArrayValue(String parameter) {
		return testData.getTestDataArrayValue(moduleName, parameter);
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		DriverFactory.createDriver("chrome",moduleName);
		new Login().login(testData.USER_NAME, testData.PASSWORD);
		
	}
	/*
	 * Instance Total Count Script in Dashboard
	 * 
	 */
	@Test(priority = 1)
	public void instanceTotalCount() throws InterruptedException {
		CsvReporter.getReporter(moduleName);
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		ReportUtil.addCell("Instance Total Count");
		new Wait().forElement(elements.instanceTotal, "visable", "60");
		String widzetCount = new GetText().getData(elements.instanceTotal);
		ReportUtil.addCell(widzetCount);
		Integer rowCount = new Count().getCount(elements.Rowinstances);
		ReportUtil.addCell(rowCount+"");
		boolean isNotequal = new CompareTexts().comapre(widzetCount, rowCount + "");
		ReportUtil.addCell(isNotequal? "failed": "passed", isNotequal? "color:red" : "color:green");
		ReportUtil.endRow();
		
	}
	/*
	 * Instance Up Count Script in Dashboard
	 * 
	 */

	@Test(priority = 2)
	public void instanceUpCount() throws InterruptedException {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		ReportUtil.addCell("instance Up Count");
		new Wait().forElement(elements.instanceUpWidzet, "visable", "60");
		String widzetCount = new GetText().getData(elements.instanceUpWidzet);
		ReportUtil.addCell(widzetCount);
		Integer rowCount = new Count().getCount(elements.rowsInstanceUp);
		ReportUtil.addCell(rowCount+"");
		boolean isNotequal = new CompareTexts().comapre(widzetCount, rowCount + "");
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
		ReportUtil.endRow();
		
		

	}
	/*
	 * Instance Down Count Script in Dashboard
	 */
	@Test(priority = 3)
	public void InstanceDownCount() throws InterruptedException {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		ReportUtil.addCell(" instance Down Count");
		System.out.println(DriverFactory.getDriver().getPageSource());
		new Wait().forElement(elements.instanceDownWidzet, "visable", "60");
		String widzetCount = new GetText().getData(elements.instanceDownWidzet);
		ReportUtil.addCell(widzetCount);
		Integer rowCount = new Count().getCount(elements.rowInstanceDown);
		ReportUtil.addCell(rowCount+"");
		boolean isNotequal = new CompareTexts().comapre(widzetCount, rowCount + "");
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
		ReportUtil.endRow();
		
	}
	
	/*
	 * Services Total Count in Dashboard and instances Script
	 * 
	 */
	@Test(priority = 4)
	
	public void ServicesTotalCount() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		ReportUtil.addCell("services Total Count");
	    
		Integer TotalServicesCount = Integer.parseInt( new GetText().getData(elements.serviceTotal));
		new GoTo().gotoUrl(getTestData("instace_URL"));
		new Wait().forSeconds("5");
		
		List<String> textList = new GetListText().list(elements.servicesOkTotalCount);
		Integer totalOkCount = 0;
		for(int i=1; i<textList.size(); i++) {
			totalOkCount = Integer.parseInt(textList.get(i))+totalOkCount;
			
		}
		textList = new GetListText().list(elements.servicesWarnTotalCount);
		Integer totalWarnCount = 0;
		for(int i=1; i<textList.size(); i++) {
			totalWarnCount = Integer.parseInt(textList.get(i))+totalWarnCount;
			
		}
		textList = new GetListText().list(elements.servicesCriticalTotalCount);
		Integer totalCriticalCount = 0;
		for(int i=1; i<textList.size(); i++) {
			totalCriticalCount = Integer.parseInt(textList.get(i))+totalCriticalCount;
			
		}
	
		ReportUtil.addCell(TotalServicesCount + "");
		ReportUtil.addCell((totalOkCount + totalWarnCount + totalCriticalCount )+"");
		boolean isNotequal = new CompareTexts().comapre(TotalServicesCount+"", (totalOkCount + totalWarnCount + totalCriticalCount ) + "");
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
		ReportUtil.endRow();
		
		
		
		
	}
	/*
	 * Services Ok Count in Dashboard and instances Script
	 * 
	 */
	@Test(priority = 5)
	public void ServicesOk() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		ReportUtil.addCell("services Ok Count");
		new GoTo().gotoUrl(getTestData("dashBoard_URL"));
		new Wait().forSeconds("5");
		Integer serviceok = Integer.parseInt( new GetText().getData(elements.serviceok));
		new GoTo().gotoUrl(getTestData("instace_URL"));
		new Wait().forSeconds("5");
		
		List<String> textList = new GetListText().list(elements.okCountinstance);
		Integer okCountinstance = 0;
		for(int i=1; i<textList.size(); i++) {
			okCountinstance = Integer.parseInt(textList.get(i))+okCountinstance;
			
		}
		
		ReportUtil.addCell(serviceok +"");
		ReportUtil.addCell(okCountinstance +"");
		boolean isNotequal = new CompareTexts().comapre(serviceok+"", okCountinstance+"");
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red"  : "color:green");
		ReportUtil.endRow();
		
	}
	/*
	 * Services Warn Count in Dashboard and instances Script
	 * 
	 */
	
	@Test(priority = 6)
	public void ServicesWarnCount() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		ReportUtil.addCell(" service warn");
		new GoTo().gotoUrl(getTestData("dashBoard_URL"));
		new Wait().forSeconds("5");
		Integer servicewarn = Integer.parseInt( new GetText().getData(elements.servicewarn));
		new GoTo().gotoUrl(getTestData("instace_URL"));
		new Wait().forSeconds("5");
		
		List<String> textList = new GetListText().list(elements.instancewarnCount);
		Integer instancewarnCount = 0;
		for(int i=1; i<textList.size(); i++) {
			instancewarnCount = Integer.parseInt(textList.get(i))+instancewarnCount;
			
		}
		
		ReportUtil.addCell(servicewarn +"");
		ReportUtil.addCell(instancewarnCount +"");
		Boolean isNotequal = new CompareTexts().comapre(servicewarn+"", instancewarnCount+"");
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
		ReportUtil.endRow();
		
	}
	/*
	 * Services Critical Count in Dashboard and instances Script
	 * 
	 * 
	 */
	@Test(priority = 7)
	public void ServicesCriticalCount() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		ReportUtil.addCell(" service critical");
		new GoTo().gotoUrl(getTestData("dashBoard_URL"));
		new Wait().forSeconds("5");
		Integer servicecritical = Integer.parseInt( new GetText().getData(elements.servicecritical));
		new GoTo().gotoUrl(getTestData("instace_URL"));
		new Wait().forSeconds("5");
		
		List<String> textList = new GetListText().list(elements.instancecritCount);
		Integer instancecritCount = 0;
		for(int i=1; i<textList.size(); i++) {
			instancecritCount = Integer.parseInt(textList.get(i))+instancecritCount;
			
		}
		ReportUtil.addCell(servicecritical +"");
		ReportUtil.addCell(instancecritCount +"");
		
		Boolean isNotequal = new CompareTexts().comapre(servicecritical+"", instancecritCount+"");
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
		ReportUtil.endRow();
		
	}
	/*
	 * Verify Actions Script in Dashboard
	 * 
	 */
	@Test(priority = 8)
	public void Actions() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		ReportUtil.addCell("performance link");
		ReportUtil.addCell(getTestData("performance"));
		new GoTo().gotoUrl(getTestData("dashBoard_URL"));
		new Wait().forSeconds("3");
		new Click().onElement(elements.threedots);
		new Wait().forSeconds("3");
		new Click().onElement(elements.performance);
		new Wait().forSeconds("3");
		ReportUtil.addCell(new GetUrl().get());
		boolean isNotequal = new VerifyCurrentURL().notcontainsText("zoom_view");
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
		
		
		new Backbutton().clickOn();
		new Wait().forSeconds("3");
		new Click().onElement(elements.threedots);
		new Wait().forSeconds("3");
		ReportUtil.addRow();
		ReportUtil.addCell("Assign vendor");
		ReportUtil.addCell(getTestData("assignVendor"));
		new Click().onElement(elements.Assignvendor);
		new Wait().forSeconds("3");
		ReportUtil.addCell(new GetUrl().get());
		isNotequal = new VerifyCurrentURL().notcontainsText("vendor-data");
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
	
		
		
		new Backbutton().clickOn();
		new Wait().forSeconds("3");
		new Click().onElement(elements.threedots);
		new Wait().forSeconds("3");
		ReportUtil.addRow();
		ReportUtil.addCell("Edittags");
		String tag = "test"+new Random().nextInt(20);
		ReportUtil.addCell(tag);
		
		new Click().onElement(elements.Edittags);
		new Wait().forSeconds("3");
		boolean isNotequalEdittags = new VerifyCurrentURL().notcontainsText("Edittags");
		
		new SendData().sendData(elements.Managetags, tag);
		new Keys().press(elements.Managetags, org.openqa.selenium.Keys.TAB);
		new Click().onElement(elements.Tagsubmit);
		new Wait().forSeconds("5");
		new Click().onElement(elements.threedots);
		new Wait().forSeconds("2");
		new Click().onElement(elements.Edittags);
		new Wait().forSeconds("2");
		isNotequal = new Verify().elementsContainsText(elements.EdittagsText,tag);
		ReportUtil.addCell(new GetText().getData(elements.EdittagsText));
		new Click().onElement(elements.closeTags);
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
		
		
		
		new Click().onElement(elements.threedots);
		new Wait().forSeconds("3");
		ReportUtil.addRow();
		ReportUtil.addCell("Editinstance");
		ReportUtil.addCell("zybisys");
		new Click().onElement(elements.Editinstance);
		boolean isNotequalEditinstance = new VerifyCurrentURL().notcontainsText("Editinstance");
		
		new SendData().sendData(elements.EnterinstanceName, "zybisys");
		new Click().onElement(elements.Changename);
		new Click().onElement(elements.yes);
		new Wait().forSeconds("2");
		isNotequal = new Verify().pageContainsText("zybisys");
		ReportUtil.addCell(new GetText().getData(elements.Actionsfirstrow));
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
		ReportUtil.endRow();
		
		
		
}
	/* Verify Child Tags Script in Dashboard
	 * 
	 */
	@Test(priority = 9)
	public void ChildTags() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		new GoTo().gotoUrl(getTestData("dashBoard_URL"));
		ReportUtil.addRow();
		ReportUtil.addCell("Instance Tag");
		ReportUtil.addCell(getTestData("instace_URL"));
		
		new Wait().forSeconds("3");
		new Scroll().elementInToTheView(elements.InstanceTag);
		new Wait().forSeconds("3");
		new Click().onElement(elements.InstanceTag);
		new Wait().forSeconds("3");
		ReportUtil.addCell(new GetUrl().get());
		boolean isNotequalInstance =new VerifyCurrentURL().notcontainsText("instance");
		ReportUtil.addCell(isNotequalInstance? "failed" : "passed", isNotequalInstance? "color:red" : "color:green");
		ReportUtil.endRow();
		
		new Backbutton().clickOn();
		new Wait().forSeconds("3");
		ReportUtil.addRow();
		ReportUtil.addCell("Backup Tag");
		ReportUtil.addCell(getTestData("backup_URL"));
		new Scroll().elementInToTheView(elements.BackupTag);
		new Click().onElement(elements.BackupTag);
		new Wait().forSeconds("3");
		ReportUtil.addCell(new GetUrl().get());
		boolean isNotequalbackup =new VerifyCurrentURL().notcontainsText("backup");
		ReportUtil.addCell(isNotequalbackup? "failed" : "passed", isNotequalbackup? "color:red" : "color:green");
		ReportUtil.endRow();
	
		
		new Backbutton().clickOn();
		new Wait().forSeconds("3");
		ReportUtil.addRow();
		ReportUtil.addCell("Monitoring Tag");
		ReportUtil.addCell(getTestData("monitoringURL"));
		new Scroll().elementInToTheView(elements.montoringTag);
		new Click().onElement(elements.montoringTag);
		new Wait().forSeconds("3");
		ReportUtil.addCell(new GetUrl().get());
		boolean isNotequalmonitoring =new VerifyCurrentURL().notcontainsText("zoom_view");
		ReportUtil.addCell(isNotequalmonitoring? "failed" : "passed", isNotequalmonitoring? "color:red" : "color:green");
		ReportUtil.endRow();
	
		
		new Backbutton().clickOn();
		new Wait().forSeconds("3");
		ReportUtil.addRow();
		ReportUtil.addCell("Billing Tag");
		ReportUtil.addCell(getTestData("invoice"));
		new Scroll().elementInToTheView(elements.BillingTag);
		new Wait().forSeconds("3");
		new Click().onElement(elements.BillingTag);
		new Wait().forSeconds("3");
		boolean isNotequalbilling = new VerifyCurrentURL().notcontainsText("invoice");
		ReportUtil.addCell(new GetUrl().get());
		ReportUtil.addCell(isNotequalbilling? "failed" : "passed", isNotequalbilling? "color:red" : "color:green");
		ReportUtil.endRow();
		
		new Wait().forSeconds("3");
		new Backbutton().clickOn();
		new Wait().forSeconds("3");
		ReportUtil.addRow();
		ReportUtil.addCell("Report Tag");
		ReportUtil.addCell(getTestData("bandwidth"));
		new Scroll().elementInToTheView(elements.ReportTag);
		new Wait().forSeconds("3");
		new Click().onElement(elements.ReportTag);
		new Wait().forSeconds("3");
		boolean isNotequalreport = new VerifyCurrentURL().notcontainsText("bandwidth");
		ReportUtil.addCell(new GetUrl().get());
		ReportUtil.addCell(isNotequalreport? "failed" : "passed", isNotequalreport? "color:red" : "color:green");
		ReportUtil.endRow();
		new Wait().forSeconds("3");
		new Backbutton().clickOn();
		new GoTo().gotoUrl(getTestData("dashBoard_URL"));
		ReportUtil.endRow();
       System.out.println("Totl tests run"+ "passes"+ "failures"+ "skips");
	
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.getDriver().quit();
	}

		
	}	
	
	