package COCmodules;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.Elements;
import data.TestData;
import driver.DriverFactory;
import keywords.Clear;
import keywords.Click;
import keywords.ExecuteJavaScript;
import keywords.GoTo;
import keywords.Scroll;
import keywords.SendData;
import keywords.Verify;
import keywords.Wait;
import modules.components.Login;
import reporters.CsvReporter;
import reporters.ReportUtil;

public class privilege {
	TestData testData = new TestData();
	String moduleName ="privilege";
	
	Elements elements = Elements.getElements();
	
	 
	public String getTestData(String parameter) {
		return testData.getTestDataValue(moduleName, parameter);
	}
	public String[] getTestDataArrayValue(String parameter) {
		return testData.getTestDataArrayValue(moduleName, parameter);
	}
	
	@BeforeMethod
	public void log(Method method) {
		ReportUtil.addData(method.getName());
	}
	
	@Test
	public void setUp() throws InterruptedException {
		DriverFactory.createDriver("chrome");
		new Login().login(testData.USER_NAME, testData.PASSWORD);
		
	}
/*
 * Add user script in Privilege
 * 
 */
	@Test(priority = 1)
	public void addUser() {
	
		ReportUtil.createTableWithHeader(new String[] { "Test Cases","Expected Result", "Actual Result", "Status" });	
		 
			new GoTo().gotoUrl(getTestData("privilege_URL"));
			new Click().onElement(elements.AddUser);
			new SendData().sendData(elements.FirstName, getTestData("validFirstName"));
			new SendData().sendData(elements.lastName, getTestData("validLastName"));
			new SendData().sendData(elements.addUserEmail, getTestData("validCaseEmail"));
			new SendData().sendData(elements.PhoneNumber, getTestData("PhoneNumber"));
			new Click().onElement(elements.addUserInvite);
			new Wait().forSeconds("4");
			boolean isNotadded = new Verify().elementsContainsText(elements.userTable,  testData.validCaseEmail);
			ReportUtil.addCell( "FirstName: "+testData.validFirstName+" LastName:"+testData.validLastName+" Email:"+testData.validCaseEmail+" Phone:"+testData.PhoneNumber);
			ReportUtil.addCell("Pass");
			ReportUtil.addCell(isNotadded ? "fail":"pass");
			ReportUtil.addCell(isNotadded ? "failed":"passed", isNotadded ? "color:red":"color:green");
			ReportUtil.endRow();
//			ReportUtil.endTable();
	}

	/*
	 * Invalid firstname Script in Privilege module
	 * 
	 */
	@Test(priority = 2)
	public void invaidFirstName() {
	
		ReportUtil.createTableWithHeader(new String[] { "Test Cases","Expected Result", "Actual Result", "Status" });
		
		String inValidFirstNames[] = getTestDataArrayValue("inValidFirstNames");
		for(int i=0; i<inValidFirstNames.length;i++) {
			new GoTo().gotoUrl(getTestData("privilege_URL"));
			new Click().onElement(elements.AddUser);
			new SendData().sendData(elements.FirstName, inValidFirstNames[i]);
			new SendData().sendData(elements.lastName, getTestData("validLastName"));
			new SendData().sendData(elements.addUserEmail, getTestData("validEmail"));
			new SendData().sendData(elements.PhoneNumber,  testData.getValidPhone());
			new Click().onElement(elements.addUserInvite);
			new Wait().forSeconds("4");
			boolean isNotadded = new Verify().elementsContainsText(elements.userTable,  testData.validPhone);
			ReportUtil.addRow();
			ReportUtil.addCell(inValidFirstNames[i]);
			ReportUtil.addCell("fail");
			ReportUtil.addCell(isNotadded ? "fail":"pass");
			ReportUtil.addCell(!isNotadded ? "failed":"passed", !isNotadded ? "color:red":"color:green");
			ReportUtil.endRow();
		}

	}
	
/*
 * Invalid Email Script in  Privilege module
 * 
 */
	@Test(priority = 3)
	public void invaidEmail() {
	
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });	
		
		String invalidEmail[] = getTestDataArrayValue("invalidEmail");
		for(int i=0; i<invalidEmail.length;i++) {
			new GoTo().gotoUrl(getTestData("privilege_URL"));
			new Click().onElement(elements.AddUser);
			new SendData().sendData(elements.FirstName, getTestData("validFirstName"));
			new SendData().sendData(elements.lastName, getTestData("validLastName"));
			new SendData().sendData(elements.addUserEmail,invalidEmail[i]);
			new SendData().sendData(elements.PhoneNumber,  testData.getValidPhone());
			new Wait().forSeconds("5");
			new Click().onElement(elements.addUserInvite);
			new Wait().forSeconds("4");
			boolean isNotadded = new Verify().elementsContainsText(elements.userTable,  testData.validPhone);
			ReportUtil.addRow();
			ReportUtil.addCell(invalidEmail[i]);
			ReportUtil.addCell("fail");
			ReportUtil.addCell(isNotadded ? "fail":"pass");
			ReportUtil.addCell(!isNotadded ? "failed":"passed", !isNotadded ? "color:red":"color:green");
			ReportUtil.endRow();
		}

	}

	
	public void addUser(String firstName, String lastName, String email, String phoneNumber) {
		
		
		
	}
	/*
	 * Edit User Script in Privilege module
	 * 
	 */
	@Test(priority = 4)
	public void EditUser() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		new GoTo().gotoUrl(getTestData("privilege_URL"));
		new Wait().forSeconds("5");
		new Click().onElement(elements.threeDots);
		new Wait().forSeconds("5");
		new Click().onElement(elements.editUser);
		new Wait().forSeconds("5");
		new Clear().onElement(elements.newUserName);
		new Wait().forSeconds("5");
		new SendData().sendData(elements.newUserName, "puja");
		
		new Click().onElement(elements.newUserNameUpdate);
		new Wait().forSeconds("5");
		boolean isNotUpdated = new Verify().elementsContainsText(elements.userTable, "puja");
		ReportUtil.addRow();
		ReportUtil.addCell("Edit user :  puja");
		ReportUtil.addCell("Pass");
		if (!isNotUpdated) {
			ReportUtil.addCell("Pass");
			ReportUtil.addCell("Passed", "color:green");

		} else {
			ReportUtil.addCell("Faild");
			ReportUtil.addCell("Failed", "color:red");

		}

		ReportUtil.endRow();		
		
	}
	/*
	 * Change PassWord Script in Privilege Module
	 * 
	 */
	@Test(priority = 5)
	public void changePassWord() {
		
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		new GoTo().gotoUrl(getTestData("privilege_URL"));
		new Wait().forSeconds("10");
		new Click().onElement(elements.threeDots);
		new Wait().forSeconds("5");
		new Click().onElement(elements.yourCurrentPassWord);
		new Wait().forSeconds("5");
		new SendData().sendData(elements.yourCurrentPassWordSubmit, "Zybisys@321");
		
		new Click().onElement(elements.submitPassWord);
		new Wait().forSeconds("5");
		new SendData().sendData(elements.newPassWord, "Zybisys@654");
		
		new SendData().sendData(elements.conFirmPassWord, "Zybisys@654");
		
		new Wait().forSeconds("5");
		new Click().onElement(elements.resetSubmit);
		new Wait().forSeconds("5");
		boolean isNotUpdated = new Verify().pageContainsText("Password reset done");
		ReportUtil.addRow();
		ReportUtil.addCell("current password:"+getTestData("currentpassword")+" new password::"+getTestData("newpassword"));
		
		ReportUtil.addCell("Passed");
	
		ReportUtil.addCell(isNotUpdated ?"fail":"Passed");
		ReportUtil.addCell(isNotUpdated ?"fail":"Passed", isNotUpdated?"color:red":"color:green");


		ReportUtil.endRow();
	}
	/*
	 * Delete User Script in Privilege Module
	 * 
	 */
	@Test(priority = 6)
	public void deleteUser() {
		ReportUtil.createTableWithHeader(new String[] { "Test Cases", "Expected Result", "Actual Result", "Status" });
		new GoTo().gotoUrl(getTestData("privilege_URL"));
		new Wait().forSeconds("5");
		new Click().onElement(elements.passwordThreeDots);
		new Wait().forSeconds("5");
		new Click().onElement(elements.delete);
		new Click().onElement(elements.confirmDelete);
		new Wait().forSeconds("1");
		boolean isNotUpdated = new Verify().pageContainsText("User Updated");
		ReportUtil.addRow();
		
		ReportUtil.addCell("delet user :  puja");
		
		ReportUtil.addCell("Passed");
		
		ReportUtil.addCell(isNotUpdated ?"fail":"Passed");
		ReportUtil.addCell(isNotUpdated ?"fail":"Passed", isNotUpdated?"color:red":"color:green");

		ReportUtil.endRow();
		
		
	}

}

