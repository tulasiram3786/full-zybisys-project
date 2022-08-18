package modules.components;

import org.testng.Reporter;
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
import reporters.ReportUtil;

public class Login {
	TestData testData = new TestData();
	Elements elements = Elements.getElements();

	public void login(String userName, String password) throws InterruptedException {

		new GoTo().gotoUrl(testData.COC_URL);
		new Wait().forSeconds("2");
		new SendData().sendData(elements.userName, userName);
		new SendData().sendData(elements.passWord, password);
		new Click().onElement(elements.submit);
		new Wait().forSeconds("5");
	}

	@Test(priority = 2)
	void ValidLogin() throws InterruptedException {
		DriverFactory.createDriver("chrome");
		
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		
		for (int i = 0; i < testData.validUserNames.length; i++) {
			ReportUtil.addRow();
			login(testData.validUserNames[i], testData.validPasswords[i]);
			boolean isLoginFailed = new VerifyCurrentURL().notcontainsText("dashboard");

			ReportUtil.addCell("ValidLogin  " + testData.validUserNames[i]
					+ " passWords " + testData.validPasswords[i]);
			ReportUtil.addCell("pass");

			if (!isLoginFailed) {
				ReportUtil.addCell("pass", "color:green");
				ReportUtil.addCell("Passed", "color:green");

			} else {
				ReportUtil.addCell("fail", "color:red");
				ReportUtil.addCell("Failed", "color:red");

			}

			ReportUtil.endRow();

			DriverFactory.getDriver().quit();
		}
		ReportUtil.endTable();
	}

	@Test(priority = 3)
	void InValidUserName() throws InterruptedException {
		DriverFactory.createDriver("chrome");
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		for (int i = 0; i < testData.negativeScenarioUserNames.length; i++) {
			DriverFactory.createDriver("chrome");
			login(testData.negativeScenarioUserNames[i], testData.validPasswords[0]);

			boolean isLoginFailed = new Verify().pageContainsText("This is not a valid email address");
			ReportUtil.addCell("ValidLogin " + testData.negativeScenarioUserNames[i]
					+ " passWords " + testData.validPasswords[0]);
			ReportUtil.addCell("pass");

			if (!isLoginFailed) {
				ReportUtil.addCell("pass", "color:green");
				ReportUtil.addCell("Passed", "color:green");

			} else {
				ReportUtil.addCell("fail", "color:red");
				ReportUtil.addCell("Failed", "color:red");

			}

			ReportUtil.endRow();
			DriverFactory.getDriver().quit();
		}
		ReportUtil.endTable();
	}

	@Test(priority = 4)
	void InValidPassWord() throws InterruptedException {
		DriverFactory.createDriver("chrome");
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		for (int i = 0; i < testData.negativeScenarioPassWords.length; i++) {
			DriverFactory.createDriver("chrome");
			login(testData.validUserNames[0], testData.negativeScenarioPassWords[i]);

			boolean isLoginFailed = new Verify().pageContainsText("Please enter valid password");
			ReportUtil.addCell("ValidLogin " + testData.validUserNames[0]
					+ " passWords " + testData.negativeScenarioPassWords[i]);
			ReportUtil.addCell("pass");

			if (!isLoginFailed) {
				ReportUtil.addCell("pass", "color:green");
				ReportUtil.addCell("Passed", "color:green");

			} else {
				ReportUtil.addCell("fail", "color:red");
				ReportUtil.addCell("Failed", "color:red");

			}

			ReportUtil.endRow();

			DriverFactory.getDriver().quit();
		}
		ReportUtil.endTable();
	}

}
