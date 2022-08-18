package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import driver.DriverFactory;

public class CompareTexts extends BaseKeyWord {
	boolean isFailed = false;

	WebDriver driver;

	public CompareTexts() {
		this.driver = DriverFactory.getDriver();
	}

	public boolean comapre(String text1, String text2) {
		log("comparing text1:" + text1 + " with text2:" + text2+" <br>");
		try {
			boolean isEqual = text1.equals(text2);
			if (isEqual)
				log("both text1:" + text1 + " and text2:" + text2 + " are equal  <br>");
			else
				log("both text1:" + text1 + " and text2:" + text2 + " are not equal  <br>");
			return !isEqual;
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to comparing text1:" + text1 + " with text2:" + text2+" <br>");
			isFailed = true;
		}
		return false;
	}
	public boolean comapre(Integer text1, Integer text2) {
		log("comparing " + text1 + " with" + text2+" <br>");
		try {
			boolean isEqual = text1==(text2);
			if (isEqual)
				log("both " + text1 + " and " + text2 + " are equal  <br>");
			else
				log("both " + text1 + " and " + text2 + " are not equal  <br>");
			return !isEqual;
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to comparing " + text1 + " with " + text2+" <br>");
			isFailed = true;
		}
		return false;
	}
}
