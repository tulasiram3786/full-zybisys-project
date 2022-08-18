package keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class Keys extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public Keys() {
		this.driver = DriverFactory.getDriver();
	}

	public void press(Element element, org.openqa.selenium.Keys key) {
		log("pressing key"+ key+"</br>");
		try {
			 Actions actions = new Actions(driver);
			 driver.findElement(element.locator).sendKeys(key);
			log("Succesfully pressed key"+ "</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to pressed key"+ "</br>");
			isFailed = true;
		}
	}

}
