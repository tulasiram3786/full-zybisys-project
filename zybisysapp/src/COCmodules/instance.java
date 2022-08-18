package COCmodules;

import java.util.List;

import org.junit.AfterClass;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import data.Elements;
import data.TestData;
import driver.DriverFactory;
import keywords.Backbutton;
import keywords.Click;
import keywords.CompareTexts;
import keywords.Count;
import keywords.ExecuteJavaScript;
import keywords.GetListText;
import keywords.GetText;
import keywords.GetUrl;
import keywords.GoTo;
import keywords.Scroll;
import keywords.Verify;
import keywords.VerifyCurrentURL;
import keywords.Wait;
import modules.components.Login;
import reporters.ReportUtil;

public class instance {
	TestData testData = new TestData();
	String moduleName ="instance";
	
	Elements elements = Elements.getElements();
	
	 
	public String getTestData(String parameter) {
		return testData.getTestDataValue(moduleName, parameter);
	}
	public String[] getTestDataArrayValue(String parameter) {
		return testData.getTestDataArrayValue(moduleName, parameter);
	}
	@Test
	public void setUp() throws InterruptedException {
		DriverFactory.createDriver("chrome");
		new Login().login(testData.USER_NAME, testData.PASSWORD);
		
	}
	/* Verify instances Script in Instances
	 * 
	 */
	@Test(priority = 1)
	public void verifyInstance() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected ok Result", "Actual ok Result","Expected warn Result", "Actual warn Result", "Expected critical Result", "Actaul critical Result", "Status" });
		/*
		 * Goto Instance URL
		 * 
		 */
		new GoTo().gotoUrl(getTestData("instace_URL"));
		new Wait().forElement(elements.all_instances, "visable");;
		/*
		 * List out all the instance list using for loop and get the counts 
		 * 
		 */
		List<String> instances = new GetListText().list(elements.all_instances);
		for(int i=0; i<instances.size(); i++) {
			int j = i+1;
			new Scroll().elementInToTheView(elements.instance1.replace(j+""));
			String instanceOk =new GetText().getData(elements.calculatedInstanceOkCount.replace(j+""));
			String InstanceWarn = new GetText().getData(elements.calculatedInstaceWarnCount.replace(j+""));
			String InstanceCritical =new GetText().getData(elements.calculatedInstanceCriticalCount.replace(j+""));
			new Click().onElement(elements.instance1.replace(j+""));
			System.out.println(elements.instance1.replace(j+"").locator+"i="+i+"j="+j);
			
			new Wait().forSeconds("2");
			Integer okCount = new GetListText().list(elements.instanceokcount).size();
			Integer warnCount = new GetListText().list(elements.warnCount).size();
			Integer critCount = new GetListText().list(elements.critCount).size();
			new Click().onElement(elements.window);
			new Wait().forSeconds("2");
			ReportUtil.addRow();
			ReportUtil.addCell(instances.get(i));
			ReportUtil.addCell(instanceOk);
			ReportUtil.addCell(okCount+"", Integer.parseInt(instanceOk)==okCount ? "color:green" : "color:red");
			ReportUtil.addCell(InstanceWarn);
			ReportUtil.addCell(warnCount+"",  Integer.parseInt(InstanceWarn)==warnCount ? "color:green" : "color:red");
			ReportUtil.addCell(InstanceCritical);
			ReportUtil.addCell(critCount+"", Integer.parseInt(InstanceCritical)==critCount ? "color:green" : "color:red");
			
			boolean status = Integer.parseInt(instanceOk)==okCount && Integer.parseInt(InstanceWarn)==warnCount && Integer.parseInt(InstanceCritical)==critCount;
			ReportUtil.addCell(status ? "Pass":"fail", status ? "color:green":"color:red");

			ReportUtil.endRow();	
		
		
		}
		
			
		}
	/*
	 * Verify Actions Script in Instances 
	 * 
	 */
	@Test(priority = 2)
	public void Action() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		new GoTo().gotoUrl(getTestData("instace_URL"));
		ReportUtil.addRow();
		ReportUtil.addCell("performance link");
		ReportUtil.addCell(getTestData("performance"));
		new Wait().forSeconds("3");
		new Click().onElement(elements.threedots);
		new Wait().forSeconds("3");
		new Click().onElement(elements.performance);
		new Wait().forSeconds("3");
		ReportUtil.addCell(new GetUrl().get());
		boolean isNotequal = new VerifyCurrentURL().notcontainsText("zoom_view");
		ReportUtil.addCell(isNotequal? "failed" : "passed", isNotequal? "color:red" : "color:green");
		ReportUtil.endRow();
		new Wait().forSeconds("3");
		new Backbutton().clickOn();
		new GoTo().gotoUrl(getTestData("dashBoard_URL"));
		
		ReportUtil.endTable();
		
	}
//	@Test(priority = 4)
	public void notification() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		ReportUtil.addRow();
		new GoTo().gotoUrl(testData.instace_URL);
		ReportUtil.addRow();
		new Wait().forSeconds("3");
		ReportUtil.addCell("notification");
		new Click().onElement(elements.notificationInstance);
		
		new Wait().forSeconds("5");
		new ExecuteJavaScript().onElement("arguments[0].click()", elements.previousNotification);
		new Wait().forSeconds("10");
		boolean isNotContains = new Verify().pageContainsText("Previous Notifications");
		System.out.print(isNotContains);
		ReportUtil.addCell("pass");
		ReportUtil.addCell(isNotContains ? "fail":"pass");
		ReportUtil.addCell(isNotContains ? "failed":"passed", isNotContains ? "color:red":"color:green");
		ReportUtil.endRow();
		ReportUtil.endTable();
		
		
	}
   
	}

	


