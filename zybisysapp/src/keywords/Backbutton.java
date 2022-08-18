package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class Backbutton extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public Backbutton() {
		this.driver = DriverFactory.getDriver();
	}

	public void clickOn() {
		log("Click on the browser backButton"+ "</br>");
		try {
			driver.navigate().back();
			 log("Succesfully clicked on the browser backbutton"+ "</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to  clicked on the browser backbutton"+ "</br>");
			isFailed = true;
		}
	}

}
