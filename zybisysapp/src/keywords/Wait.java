package keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class Wait extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public Wait() {
		this.driver = DriverFactory.getDriver();
	}

	public void forSeconds(String seconds) {
		log("waiting for seconds "+seconds+"</br>");
		try {
			 Thread.sleep(Long.parseLong(seconds)*1000);
			log("Succesfully waitited  for the seconds "+seconds+"</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("Failed to waited for seconds "+seconds+"</br>");
			isFailed = true;
		}
	}
	
	public void forElement(Element element, String type, String seconds) {
		log("waiting for element "+element.name+" with xpath"+element.locator+"</br>");
		try {
			 WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(seconds)*1000);
			 if(type=="clickable")
				 wait.until(ExpectedConditions.elementToBeClickable(element.locator));
			 else if(type=="visable")
				 wait.until(ExpectedConditions.visibilityOfElementLocated(element.locator));
		
			 log("successfully waited for for element "+element.name+" with xpath"+element.locator+"</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("waiting for element "+element.name+" with xpath"+element.locator+"</br>");
			isFailed = true;
		}
	}
	public void forElement(Element element, String type) {
		log("waiting for element "+element.name+" with xpath"+element.locator+"</br>");
		try {
			 WebDriverWait wait = new WebDriverWait(driver, 30);
			 if(type=="clickable")
				 wait.until(ExpectedConditions.elementToBeClickable(element.locator));
			 else if(type=="visable")
				 wait.until(ExpectedConditions.visibilityOfElementLocated(element.locator));
		
			 log("successfully waited for for element "+element.name+" with xpath"+element.locator+"</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("waiting for element "+element.name+" with xpath"+element.locator+"</br>");
			isFailed = true;
		}
	}

}
