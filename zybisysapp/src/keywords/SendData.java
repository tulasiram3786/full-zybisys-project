package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class SendData extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public SendData() {
		this.driver = DriverFactory.getDriver();
	}

	public void sendData(Element element, String data) {
		log("entering data" + data + " into locator" + element.name +"with xpath "+ element.locator+ "<br>");
		try {
			 this.driver.findElement(element.locator).sendKeys(data);
			 log("Succesfully entering data" + data + " into locator" + element.name +"with xpath "+ element.locator+ "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("Failed to entering data" + data + " into locator" + element.name +"with xpath "+ element.locator+ "<br>");
			isFailed = true;
		}
	}

}
