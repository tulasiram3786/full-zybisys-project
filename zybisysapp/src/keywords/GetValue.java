package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class GetValue extends BaseKeyWord {
	boolean isFailed = false;

	WebDriver driver;

	public GetValue() {
		this.driver = DriverFactory.getDriver();
	}

	public String getData(Element element) {
		log("get element value from locator" + element.name+" with xpath"+element.locator+ "<br>");
		try {
			String text = this.driver.findElement(element.locator).getAttribute("value");
			log("Succesfully get element value from locator" + element.name+" with xpath"+element.locator+ "<br>");
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			log("Failed to get element value from locator" + element.name+" with xpath"+element.locator+ "<br>");
			isFailed = true;
		}
		return null;
	}
}
