package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import driver.DriverFactory;

public class GoTo extends BaseKeyWord{
	
	boolean isFailed = false;
	
	WebDriver driver;

	public GoTo() {
		this.driver = DriverFactory.getDriver();
	}

	public void gotoUrl(String url) {
		log("navigating to url" + url+" <br>");
		try {
			this.driver.navigate().to(url);
			log("successfully to url" + url+" <br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to url" + url+" <br>");
			isFailed = true;
		}
	}

}
