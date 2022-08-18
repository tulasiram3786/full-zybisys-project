package keywords;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import data.Element;
import driver.DriverFactory;

public class ExecuteJavaScript extends BaseKeyWord {
	boolean isFailed = false;
	WebDriver driver;

	public ExecuteJavaScript() {
		this.driver = DriverFactory.getDriver();
	}

	public void onElement(String javaScript, Element element) {
		log("executing javascript "+javaScript+" on element" + element.name+"with xpath"+element.locator+ "</br>");
		try {
			 ((JavascriptExecutor)this.driver).executeScript(javaScript, driver.findElement(element.locator));
			log("Successfully executed javascript "+javaScript+" on element" + element.name+"with xpath"+element.locator+ "</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to execute javascript "+javaScript+" on element" + element.name+"with xpath"+element.locator+ "</br>");
			isFailed = true;
		}
	}

	public void onElement(String javaScript, Element element, Object ... arguments) {
		log("executing javascript "+javaScript+" on element" + ((Element)arguments[0]).name+"with xpath"+((Element)arguments[0]).locator+ "</br>");
		try {
			 Object[] args = new Object[arguments.length+1];
			 System.arraycopy(arguments, 1, args, 1, arguments.length);
			 args[0]=driver.findElement(element.locator);
			 ((JavascriptExecutor)this.driver).executeScript(javaScript, args);
			log("Successfully executed javascript "+javaScript+" on element" + element.name+"with xpath"+element.locator+ "</br>");
		} catch (Exception e) {
			e.printStackTrace();
			log("failed to execute javascript "+javaScript+" on element" + element.name+"with xpath"+element.locator+ "</br>");
			isFailed = true;
		}
	}
}
