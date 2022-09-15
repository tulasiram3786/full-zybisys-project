package COCmodules;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.Element;
import data.Elements;
import data.TestData;

import driver.DriverFactory;
import keywords.Clear;
import keywords.Click;
import keywords.GetText;
import keywords.GoTo;
import keywords.NewTab;
import keywords.SendData;
import keywords.SwitchTab;
import keywords.VerifyCurrentURL;
import keywords.Verify;
import keywords.Wait;
import reporters.CsvReporter;
import reporters.ReportUtil;

public class Authentication {
	
	TestData testData = new TestData();
	String moduleName ="authentication";
	
	Elements elements = Elements.getElements();
	@BeforeMethod
	public void log(Method method) {
		ReportUtil.addData(method.getName());
	}
	
	public String getTestData(String parameter) {
		return testData.getTestDataValue(moduleName, parameter);
	}
	public String[] getTestDataArrayValue(String parameter) {
		return testData.getTestDataArrayValue(moduleName, parameter);
	}
	
	
	public void login(String userName, String password) throws InterruptedException {
		/*
		 * Generating CSV Report in EXCel 
		 * 
		 */
		CsvReporter.getReporter();
		/*
		 * GoTo COCURL
		 * 
		 */
		new GoTo().gotoUrl(getTestData("COC_URL"));
		new Wait().forSeconds("2");
		new SendData().sendData(elements.userName, userName);
		new SendData().sendData(elements.passWord, password);
		new Wait().forSeconds("10");
		new Click().onElement(elements.submit);
		new Wait().forSeconds("5");
		
	}

	/*
	 * Valid UserName and PassWord Credential Script
	 * 
	 */
	@Test(priority = 2)
	void ValidLogin() throws InterruptedException {
		DriverFactory.createDriver("chrome");     //it is used to add the new Chrome browser
		
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		String validUserNames[] = getTestDataArrayValue("validUserNames");
		String validPasswords[] = getTestDataArrayValue("validPasswords");
		for (int i = 0; i < validUserNames.length; i++) {
			ReportUtil.addRow();
			login(validUserNames[i], validPasswords[i]);
			boolean isLoginFailed = new VerifyCurrentURL().notcontainsText("dashboard");

			ReportUtil.addCell("" +validUserNames[i]  +" "+  validPasswords[i]);
			ReportUtil.addCell("Pass");

			if (!isLoginFailed) {
				ReportUtil.addCell("Pass");
				ReportUtil.addCell("Passed", "color:green");

			} else {
				ReportUtil.addCell("Fail");
				ReportUtil.addCell("Failed", "color:red");

			}

			ReportUtil.endRow();

			DriverFactory.getDriver().quit();
			
		}
		ReportUtil.endTable();
	}

	/*
	 * Invalid UserName Credential Script
	 * 
	 */
	@Test(priority = 3)
	void UserName() throws InterruptedException {
		DriverFactory.createDriver("chrome",moduleName);
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		String [] negativeScenarioUserNames=getTestDataArrayValue("negativeScenarioUserNames");
		String validPasswords[] = getTestDataArrayValue("validPasswords");
		for (int i = 0; i <negativeScenarioUserNames.length; i++) {
			DriverFactory.createDriver("chrome",moduleName);
			login(negativeScenarioUserNames[i], validPasswords[0]);

			boolean isLoginFailed = new Verify().pageContainsText("This is not a valid email address");
			ReportUtil.addCell(" " +negativeScenarioUserNames[i]);
					
			ReportUtil.addCell("Fail");
			

			if (!isLoginFailed) {
				ReportUtil.addCell("Fail");
				ReportUtil.addCell("Passed", "color:green");

			} else {
				ReportUtil.addCell("Pass");
				ReportUtil.addCell("Failed", "color:red");

			}

			ReportUtil.endRow();
			DriverFactory.getDriver().quit();
			
		}
		ReportUtil.endTable();
	}

	/*
	 * Invalid PassWord Script
	 * 
	 */
	@Test(priority = 4)
	void PassWord() throws InterruptedException {
		DriverFactory.createDriver("chrome");
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		String [] negativeScenarioPassWords=getTestDataArrayValue("negativeScenarioPassWords");
		String validUserNames[] = getTestDataArrayValue("validUserNames");
		for (int i = 0; i <negativeScenarioPassWords.length; i++) {
			DriverFactory.createDriver("chrome");
			login(validUserNames[0],negativeScenarioPassWords[i]);

			boolean isLoginFailed = new Verify().pageContainsText("Please enter valid password");
			ReportUtil.addCell(" " +negativeScenarioPassWords[i]);
			ReportUtil.addCell("Fail");
			

			if (!isLoginFailed) {
				ReportUtil.addCell("Fail");
				ReportUtil.addCell("Passed", "color:green");

			} else {
				ReportUtil.addCell("Pass", "color:red");
				ReportUtil.addCell("Failed", "color:red");

				
			}

			ReportUtil.endRow();

			DriverFactory.getDriver().quit();
			 
		}
		ReportUtil.endTable();
	}


}
