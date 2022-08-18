package keywords;

import org.openqa.selenium.WebDriver;

import driver.DriverFactory;

public class GetUrl extends BaseKeyWord {
boolean isFailed = false;
	
	WebDriver driver;

	public GetUrl() {
		this.driver = DriverFactory.getDriver();
	}

	public String get(){
		
		try {
			String url = this.driver.getCurrentUrl();
			log("successfully to url" + url+" <br>");
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			
			isFailed = true;
		}
		return null;
	}

}
