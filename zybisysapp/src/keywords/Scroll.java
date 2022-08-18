package keywords;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class Scroll extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public Scroll() {
		this.driver = DriverFactory.getDriver();
	}

	public void elementInToTheView(Element element) {
		log("elementintotheview"+element.name+"</br>");
		try {
			 WebElement scrollElement = driver.findElement(element.locator);
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", scrollElement);
			    
			log("Succesfully elementInToTheView"+ "</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to  elementInToTheView"+ "</br>");
			isFailed = true;
		}
	}

}
