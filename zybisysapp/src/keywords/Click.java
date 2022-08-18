package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class Click extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public Click() {
		this.driver = DriverFactory.getDriver();
	}

	public void onElement(Element element) {
		log("clicking on element" + element.name+"with xpath"+element.locator+ "</br>");
		try {
			 this.driver.findElement(element.locator).click();
			 log("Succesfully clicked on element" + element.name+"with xpath"+element.locator+ "</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to click on element" + element.name+"with xpath"+element.locator+ "</br>");
			isFailed = true;
		}
	}

}
