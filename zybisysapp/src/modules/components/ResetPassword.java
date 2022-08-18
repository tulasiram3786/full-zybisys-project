package modules.components;

import org.testng.annotations.Test;

import data.Elements;
import data.TestData;
import driver.DriverFactory;
import keywords.Clear;
import keywords.Click;
import keywords.ExecuteJavaScript;
import keywords.GetText;
import keywords.GoTo;
import keywords.NewTab;
import keywords.SendData;
import keywords.SwitchTab;
import keywords.Wait;

public class ResetPassword {
	TestData testData = new TestData();
	Elements elements = Elements.getElements();
	
	@Test
	public void setUp() {
		DriverFactory.createDriver("chrome");
	}

	@Test
	void verifyResetPassword() throws InterruptedException {
		
		new GoTo().gotoUrl(testData.COC_URL);
		new Click().onElement(elements.forgotPassword);
		new Wait().forSeconds(testData.waitForZoho);
		new SendData().sendData(elements.email, testData.resetPasswordEmail);
		new Click().onElement(elements.generateOTP);
		
		new NewTab().open(testData.ZOHO_URL);
		new Wait().forSeconds(testData.waitForZoho);
		new SwitchTab().to(testData.zohowindownumber);
		
		System.out.println(DriverFactory.getDriver().getPageSource());
		new Wait().forElement(elements.zohoemail1, "visable");
		
		new SendData().sendData(elements.zohoemail1, testData.zohoUSER_NAME);
		new Click().onElement(elements.zohonext);
		//new Clear().onElement(elements.zohopassword);
		//new ExecuteJavaScript().onElement("arguments[0].value=arguments[1];",elements.zohosigninLink, testData.PASSWORD);
		new Wait().forElement(elements.zohopassword, "visable");
		new SendData().sendData(elements.zohopassword, testData.zohoPASSWORD);
		new Click().onElement(elements.zohosignin);
		new Wait().forSeconds(testData.waitForZoho);
		new Click().onElement(elements.zybisysOTPMail);
		new Wait().forSeconds(testData.waitForZoho);
	   String data = new GetText().getData(elements.ZybisysOTP);
	   new SwitchTab().to(testData.cocwindownumber);
	   for(int i=0; i<data.length(); i++)
		   new SendData().sendData(elements.OTPinput.replace((i+1)+""), data.charAt(i)+"");
		
		
		
	}

}
