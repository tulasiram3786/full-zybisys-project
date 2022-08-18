package COCmodules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import reporters.CsvReporter;
import reporters.ReportUtil;


public class DataTransfer {
	public static  String UserName = "zebu@gmail.com";
	public static String PassWord = "Zybisys@123";

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PassWord);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(3000);
		CsvReporter.addData("'04-2021'");
		
		
		
		 ReportUtil.createTableWithHeader(new String[] { "IPaddress", "TrisulReport", "COCReport", "Status" });
			ReportUtil.addRow();
			driver.get("https://dev.zybisys.com/coc/reports/bandwidth_usage");
			Thread.sleep(3000);

			driver.findElement(By.xpath("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]")).click();
			Select sel = new Select(driver.findElement(By.xpath("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]")));
			sel.selectByIndex(3);
			driver.findElement(By.xpath("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[3]")).click();
			Select se2 = new Select(driver.findElement(By.xpath("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[3]")));
			se2.selectByIndex(1);
			driver.findElement(By.xpath("//span[text()='Run Report']")).click();

	}

}
