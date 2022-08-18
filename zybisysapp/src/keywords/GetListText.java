package keywords;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class GetListText extends BaseKeyWord{
	boolean isFailed = false;
	WebDriver driver;

	public GetListText() {
		this.driver = DriverFactory.getDriver();
	}

	public List<String> list(Element element) {
		log("getting the list of webelement" + element.name+"with xpath"+element.locator+ "</br>");
		
		List<String> textList = new ArrayList<>();
		try {
			List<WebElement> list = this.driver.findElements(element.locator);
			for(int i=0; i<list.size(); i++) {
				textList.add(list.get(i).getText());
				
			}
			
			 
			 log("Succesfully got the texts for "+textList.size()+" elements" + element.name+"with xpath"+element.locator+ "</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to got the list of  element" + element.name+"with xpath"+element.locator+ "</br>");
			isFailed = true;
		}
		return textList;
	}

}
