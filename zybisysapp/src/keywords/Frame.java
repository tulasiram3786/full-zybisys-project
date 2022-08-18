package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class Frame extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public Frame() {
		this.driver = DriverFactory.getDriver();
	}

	public void usingElement(Element element) {
		log("switching to frame with xpath"+element.locator+"</br>");
		try {
			 this.driver.switchTo().frame(driver.findElement(element.locator));
			 
			 log("Succesfully switched to   "+element.name+"with xpath"+element.locator+ "</br>");
			
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to  switch  "+element.name+"with xpath"+element.locator+ "</br>");
			isFailed = true;
		}
		
	}

}
