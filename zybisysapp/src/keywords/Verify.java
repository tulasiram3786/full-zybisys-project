package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class Verify extends BaseKeyWord{
	boolean isFailed = false;

	WebDriver driver;

	public Verify() {
		this.driver = DriverFactory.getDriver();
	}

	public boolean pageContainsText(String text1) {
		log("verify page contains text" + text1+" <br>" );
		try {
			boolean contains = driver.findElement(By.xpath("//body")).getText().contains(text1);
			
			if (contains)
				log("page successfully contains text" + text1+" <br>" );
			else
				log("page doen't contains text" + text1 +" <br>");
			
			return !contains;
		} catch (Exception e) {
			e.printStackTrace();
			log("error occured while verify page contains "+text1+"<br>");
			isFailed = true;
			
		}
		
		return false;
	}
	public boolean elementsContainsText(Element element, String text) {
	
		log("verify element "+element.name+" with locator "+element.locator+" contains text" + text+" <br>" );
		try {
			boolean contains = driver.findElement(element.locator).getText().contains(text);
		
			if (contains)
				log(" Succesfuly verified element "+element.name+" with locator "+element.locator+" contains text" + text+" <br>" );
			else
				log("Failed to verify element "+element.name+" with locator "+element.locator+" contains text" + text+" <br>" );
			
			return !contains;
		} catch (Exception e) {
			e.printStackTrace();
			log("Failed to verify element "+element.name+" with locator "+element.locator+" contains text" + text+" <br>" );
			isFailed = true;
			
		}
		
		return false;
	}
}
