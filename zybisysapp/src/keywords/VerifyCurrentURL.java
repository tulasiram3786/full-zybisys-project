package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import driver.DriverFactory;

public class VerifyCurrentURL extends BaseKeyWord {
	boolean isFailed = false;

	WebDriver driver;

	public VerifyCurrentURL() {
		this.driver = DriverFactory.getDriver();
	}

	public boolean notcontainsText(String text1) {
		log("Verifyurl contains text1" + text1+" <br>" );
		try {
			boolean contains = driver.getCurrentUrl().contains(text1);
			
			if (!contains)
				log("The url "+ driver.getCurrentUrl()+"does not  contains text "+text1+" <br>");
			else
				log("The url "+ driver.getCurrentUrl()+" contains text "+text1+" <br>");
			
			return !contains;
		} catch (Exception e) {
			e.printStackTrace();
			log("error occured while VerifyCurrentURL containsText"+text1+" <br>");
			isFailed = true;
			
		}
		
		return false;
	}
}
