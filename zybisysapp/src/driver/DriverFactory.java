package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import reporters.CsvReporter;

public class DriverFactory {

	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	
	public static void createDriver(String browserName) {
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\104\\chromedriver.exe");
			driver = new ChromeDriver();	
		}else if(browserName.equalsIgnoreCase("Firefox")) {
		
			driver = new FirefoxDriver();	
		}else if(browserName.equalsIgnoreCase("Safari")) {
		 driver=new SafariDriver();
		}else if(browserName.equalsIgnoreCase("InternetExplorer")) {
		
			 driver=new InternetExplorerDriver();
		}else if(browserName.equalsIgnoreCase("Edge")) {
	
			 driver=new EdgeDriver();
		}else {
			Reporter.log("unsupported browser");
		}
		driver.manage().window().maximize();
		threadLocalDriver.set(driver);
		CsvReporter.getReporter();
	}
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
}
