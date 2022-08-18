package COCmodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import keywords.SendData;
import reporters.CsvReporter;
import reporters.ReportUtil;

public class IPTrackingReport {
	public static String username = "zebu@gmail.com";
	public static String password = "Zybisys@123";

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.zybisys.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(3000);
		CsvReporter.addData("'15-08-2022 00:00'");
		CsvReporter.addData("'16-08-2022 23:59'");
		
		 ReportUtil.createTableWithHeader(new String[] { "IPaddress", "TrisulReport", "COCReport", "Status" });
			ReportUtil.addRow();
			driver.get("https://dev.zybisys.com/coc/reports/ip_tracking");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[text()='From']/following::input[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[text()='August, 2022']/following::button/following::table/thead/following::tbody/tr[3]/td[text()='15'])[1]")).click();

			Actions actions = new Actions(driver);
			Thread.sleep(2000);
			WebElement elementText = driver.findElement(By.xpath("(//div[@class=\"show-time\"]/span)[1]"));
			int i = 1;
			while (!elementText.getText().equals("00")) {
				WebElement element = driver.findElement(By.xpath("(//div[contains(@class,\"handle handle-0\")])[1]"));
				actions.clickAndHold(element)
						.moveByOffset(elementText.getSize().getWidth() - i * 5, elementText.getSize().getHeight()).release()
						.build().perform();
				elementText = driver.findElement(By.xpath("(//div[@class=\"show-time\"]/span)[1]"));
				i++;
			}

			WebElement elementText2 = driver.findElement(By.xpath("(//div[@class=\"show-time\"]/span)[3]"));
			i = 1;
			while (!elementText2.getText().equals("00")) {
				WebElement element = driver.findElement(By.xpath("(//div[contains(@class,\"handle handle-0\")])[2]"));
				actions.clickAndHold(element)
				
						.moveByOffset(elementText2.getSize().getWidth() - i * 5, elementText2.getSize().getHeight())
						.release().build().perform();
				elementText2 = driver.findElement(By.xpath("(//div[@class=\"show-time\"]/span)[3]"));
				i++;
			}
			 

			driver.findElement(By.xpath("//label[text()='To']/following::input[1]")).click();
			Thread.sleep(2000);
			
			
			
			driver.findElement(By.xpath("(//span[text()='August, 2022']/following::button/following::table/thead/following::tbody/tr[3]/td[text()='16'])[2]")).click();
			Actions actions1 = new Actions(driver);
			WebElement elementText1 = driver.findElement(By.xpath("(//div[@class='show-time'])[2]/span[1]"));
			int i1 =1;
			while(!elementText1.getText().equals("23")) {
				WebElement elements = driver.findElement(By.xpath("(//div[contains(@class, 'handle handle-0 ')])[3]"));
				actions.clickAndHold(elements)
				.moveByOffset(elementText1.getSize().getWidth() + i*5, elementText1.getSize().getHeight() ).release()
				.build().perform();
				elementText1 = driver.findElement(By.xpath("(//div[@class='show-time'])[2]/span[1]"));
				i++;
				
			}
			WebElement elementText3 = driver.findElement(By.xpath("(//div[@class='show-time'])[2]/span[3]"));
			i=1;
			while(!elementText3.getText().equals("59")) {
				WebElement elementText4 = driver.findElement(By.xpath("(//div[contains(@class, 'handle handle-0 ')])[4]"));
				actions.clickAndHold(elementText4)
				.moveByOffset(elementText4.getSize().getWidth() + i*5, elementText4.getSize().getHeight()).release()
				.build().perform();
				elementText1 = driver.findElement(By.xpath("(//div[@class='show-time'])[2]/span[3]"));
				i++;
				
			}
			
			driver.findElement(By.xpath("//label[text()='To']/following::input[1]")).click();
			Select sel = new Select(driver.findElement(By.xpath("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]")));
			sel.selectByVisibleText("154.83.3.25");
			Thread.sleep(5000);
			List<WebElement> webelement =driver.findElements(By.xpath("//div[text()='External IP Communication ']/parent::div/following::table/tbody/tr/td[3]"));
			Float totalMB = 0f;
			for(int j=0; j< webelement.size(); j++) {
				String s = webelement.get(j).getText();
				System.out.println("Text is:" + getBandWidthInMb(s));
				totalMB = totalMB + getBandWidthInMb(s);
			}
			System.out.println(totalMB);
			
			
			driver.navigate().to("https://dev.zybisys.com/coc/reports/bandwidth");
			Thread.sleep(2000);
			String inputXpath = "//label[text()='From']/following::div[1]/input";
			String dateXpath  =         "(//input[@type='text']/following::span[text()='July, 2022']/following::button/following::table/tbody/tr/td[text()='26'])[1]";
			String timetextXpath = "(//div[@class=\"show-time\"]/span)[1]";
			String handleXpath = "(//div[contains(@class,\"handle handle-0\")])[1]";
			String timeValue = "00";
			String handleXpath1 ="(//div[contains(@class,\"handle handle-0\")])[2]";
			String timeValue1 = "00";
			String timetextXpath1 = "(//div[@class=\"show-time\"]/span)[2]";
			selectDateandTime(driver, inputXpath, dateXpath, timetextXpath, handleXpath, timeValue, timetextXpath1, handleXpath1, timeValue1, true);
					
			inputXpath = "//label[text()='To']/following::div[1]/input";
			dateXpath  =         "(//input[@type='text']/following::span[text()='July, 2022']/following::button/following::table/tbody/tr/td[text()='27'])[1]";
			timetextXpath = "(//div[@class=\"show-time\"]/span)[3]";
			handleXpath = "(//div[contains(@class,\"handle handle-0\")])[3]";
			timeValue = "23";
			handleXpath1 ="(//div[contains(@class,\"handle handle-0\")])[4]";
			timeValue1 = "23";
			timetextXpath1 = "(//div[@class=\"show-time\"]/span)[4]";
			selectDateandTime(driver, inputXpath, dateXpath, timetextXpath, handleXpath, timeValue, timetextXpath1, handleXpath1, timeValue1, false);
			
	}
	private static Float getBandWidthInMb(String text) {
		if(text.contains("GB")) {
			return Float.parseFloat(text.replace("GB", "").trim())*1000;	
		}else if(text.contains("MB") ||text.contains("MB")) {
			return Float.parseFloat(text.replace("MB", "").trim());
		}else if(text.contains("KB")) {
			return Float.parseFloat(text.replace("KB", "").trim())/1000;
		}else if(text.contains("Bytes")){
			return Float.parseFloat(text.replace("Bytes", "").trim())/1000/1000;
		}if(text.contains("B")){
			return Float.parseFloat(text.replace("B", "").trim())/1000/1000;
		}else {
			System.out.println(text);
			return 0f;
		}
	}
			
			
		public static void selectDateandTime(WebDriver driver , String inputXpath, String dateXpath, 
				String timetextXpath1, String handleXpath1,
				String timeValue1, String timetextXpath2, String handleXpath2, String timeValue2, Boolean isFrom) throws InterruptedException {
			
			driver.findElement(By.xpath(inputXpath)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(dateXpath)).click();

			Actions actions = new Actions(driver);
			Thread.sleep(2000);
			WebElement elementText = driver.findElement(By.xpath(timetextXpath1));
			int i = 1;
			while (!elementText.getText().equals(timeValue1)) {
				WebElement element = driver.findElement(By.xpath(handleXpath1));
				int width = isFrom ? (elementText.getSize().getWidth() - i * 5): (elementText.getSize().getWidth() + i * 5);
				actions.clickAndHold(element)
						.moveByOffset(width, elementText.getSize().getHeight()).release()
						.build().perform();
				elementText = driver.findElement(By.xpath(timetextXpath1));
				i++;
			}
			
			WebElement elementText1 = driver.findElement(By.xpath(timetextXpath2));
			i = 1;
			while (!elementText1.getText().equals(timeValue2)) {
				WebElement element = driver.findElement(By.xpath(handleXpath2));
				int width = isFrom ? (elementText1.getSize().getWidth() - i * 5): (elementText1.getSize().getWidth() + i * 5);
				actions.clickAndHold(element)
						.moveByOffset(width, elementText1.getSize().getHeight()).release()
						.build().perform();
				elementText1 = driver.findElement(By.xpath(timetextXpath2));
				i++;
			}
		}
	
		
		

	}


