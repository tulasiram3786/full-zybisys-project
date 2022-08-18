package COCmodules;

import org.testng.annotations.Test;

import data.Elements;
import data.TestData;
import driver.DriverFactory;
import keywords.Click;
import keywords.ExecuteJavaScript;
import keywords.Frame;
import keywords.GoTo;
import keywords.SendData;
import keywords.Wait;
import modules.components.Login;

public class Backup {
	TestData testData = new TestData();
	Elements elements = Elements.getElements();
	@Test(priority = 1)
	public void setUp() throws InterruptedException {
		DriverFactory.createDriver("chrome");
		new Login().login(testData.USER_NAME, testData.PASSWORD);
		
	}
	@Test(priority = 2)
	public void verifySubscription() {
		new GoTo().gotoUrl(testData.backup_URL);
		new Wait().forSeconds("5");
		new Click().onElement(elements.Subscription);
		new Click().onElement(elements.purchase);
		new Wait().forSeconds("5");
		new Click().onElement(elements.addInstance);
		new Wait().forSeconds("3");
		new Click().onElement(elements.proceed);
		new Wait().forSeconds("5");
		new Frame().usingElement(elements.paymentIframe);
		new Wait().forSeconds("5");
		new Click().onElement(elements.creditcardNumber);
		new Wait().forSeconds("10");
		new SendData().sendData(elements.paymentCardNumber, testData.paymentCardNumber+"");
		new Wait().forSeconds("5");
		new SendData().sendData(elements.paymentMonth, testData.paymentMonth +"");
		new Wait().forSeconds("5");
		new SendData().sendData(elements.paymentYear, testData.paymentYear +"");
		new Wait().forSeconds("5");
		new SendData().sendData(elements.paymentCvv, testData.paymentCvv+"");
		new Click().onElement(elements.paySubmit);
		new SendData().sendData(elements.masterCardPassWord, testData.masterCardpwd+"");
		new Click().onElement(elements.masterCardSubmit);
		
		
}
}
