package keywords;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class Clear extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public Clear() {
		this.driver = DriverFactory.getDriver();
	}

	public void onElement(Element element) {
		log("clearing value in  "+element.name+"with xpath"+element.locator+ "</br>");
		try {
			 this.driver.findElement(element.locator).clear();
			 this.driver.findElement(element.locator).click();
			 log("Succesfully cleared the  value in  "+element.name+"with xpath"+element.locator+ "</br>");
			 if(this.driver.findElement(element.locator).getAttribute("value").length()>0) {
				 int i = 0;
				 while(this.driver.findElement(element.locator).getAttribute("value").length()>0 && i< 100) {
					 this.driver.findElement(element.locator).sendKeys(Keys.BACK_SPACE);
					 i++;
				 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to  clear the  value in  "+element.name+"with xpath"+element.locator+ "</br>");
			isFailed = true;
		}
		
	}

}
