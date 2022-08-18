package keywords;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import driver.DriverFactory;

public class NewTab extends BaseKeyWord{
	
	boolean isFailed = false;
	
	WebDriver driver;

	public NewTab() {
		this.driver = DriverFactory.getDriver();
	}

	public void open(String url) {
		log("opening new tab with url" + url+" <br>");
		try {
			((JavascriptExecutor)driver).executeScript("window.open(arguments[0],'_blank')",url);
			log("successfully open new tab with url" + url+" <br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to open new tab with url" + url+" <br>");
			isFailed = true;
		}
	}

}
