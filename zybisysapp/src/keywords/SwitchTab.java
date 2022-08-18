package keywords;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class SwitchTab extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public SwitchTab() {
		this.driver = DriverFactory.getDriver();
	}

	public void to(String index) {
		log("Switching to window with index  "+index+ "</br>");
		try {
			Set<String> windowHandles = driver.getWindowHandles();
		    List<String> windowStrings = new ArrayList<>(windowHandles);
		    String reqWindow = windowStrings.get(Integer.parseInt(index));
		    driver.switchTo().window(reqWindow);
		    log("Succesfully Switched to window with index  "+index+ "</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("Failed to Switch to window with index  "+index+ "</br>");
			isFailed = true;
		}
	}

}
