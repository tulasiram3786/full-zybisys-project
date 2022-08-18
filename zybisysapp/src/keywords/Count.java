package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class Count extends BaseKeyWord {
	boolean isFailed = false;
	WebDriver driver;

	public Count() {
		this.driver = DriverFactory.getDriver();
	}

	public Integer getCount(Element element) {
		log("getting the count of webelement" + element.name+"with xpath"+element.locator+ "</br>");
		Integer count =0;
		try {
			count = this.driver.findElements(element.locator).size();
			
			 
			 log("Succesfully got the count of element" + element.name+"with xpath"+element.locator+ "</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to got the count of  element" + element.name+"with xpath"+element.locator+ "</br>");
			isFailed = true;
		}
		return count;
	}

}
