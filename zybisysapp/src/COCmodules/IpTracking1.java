package COCmodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import reporters.CsvReporter;
import reporters.ReportUtil;

public class IpTracking1 {
	public static String UserName ="zebu@gmail.com";
	public static String PassWord ="Zybisys@123";
	


		public static Float getRecevedGbForIpAddress(WebDriver driver, String ip) throws InterruptedException {
		
			CsvReporter.addData("'27-07-2022 00:00'");
			CsvReporter.addData("'28-07-2022 23:59'");
			driver.navigate().to("https://dev.zybisys.com/coc/reports/bandwidth");
			Thread.sleep(3000);
			 ReportUtil.createTableWithHeader(new String[] { "IPaddress", "TrisulReport", "COCReport", "Status" });
				ReportUtil.addRow();
				driver.get("https://dev.zybisys.com/coc/reports/ip_tracking");
				Thread.sleep(3000);
				String inputXpath = "//label[text()='From']/following::div[1]/input";
				String dateXpath  =         "(//input[@type='text']/following::span[text()='July, 2022']/following::button/following::table/tbody/tr/td[text()='26'])[2]";
				String timetextXpath = "(//div[@class=\"show-time\"]/span)[1]";
				String handleXpath = "(//div[contains(@class,\"handle handle-0\")])[1]";
				String timeValue = "00";
				String handleXpath1 ="(//div[contains(@class,\"handle handle-0\")])[2]";
				String timeValue1 = "00";
				String timetextXpath1 = "(//div[@class=\"show-time\"]/span)[3]";
				String currentMonthXpath = "(//div[@class='calendar-months']/table/tbody/tr/td[text()='Jul'])[1]";
				String currentMonthSelXpath = "(//div[@class='calendar-nav']/span[@class='current-date'])[1]";
				selectDateandTime(driver, inputXpath, dateXpath, timetextXpath, handleXpath, timeValue,
						timetextXpath1, handleXpath1, timeValue1, currentMonthXpath, currentMonthSelXpath, true);
						
				inputXpath = "//label[text()='To']/following::div[1]/input";
				dateXpath  =         "(//input[@type='text']/following::span[text()='July, 2022']/following::button/following::table/tbody/tr/td[text()='27'])[4]";
				timetextXpath = "(//div[@class=\"show-time\"]/span)[4]";
				handleXpath = "(//div[contains(@class,\"handle handle-0\")])[3]";
				timeValue = "23";
				handleXpath1 ="(//div[contains(@class,\"handle handle-0\")])[4]";
				timeValue1 = "59";
				timetextXpath1 = "(//div[@class=\"show-time\"]/span)[6]";
				currentMonthXpath = "(//div[@class='calendar-months']/table/tbody/tr/td[text()='Jul'])[2]";
				currentMonthSelXpath = "(//div[@class='calendar-nav']/span[@class='current-date'])[3]";
				
				selectDateandTime(driver, inputXpath, dateXpath, timetextXpath, handleXpath, timeValue, timetextXpath1, handleXpath1, timeValue1,
						currentMonthXpath, currentMonthSelXpath, false);


				driver.findElement(By.xpath(inputXpath)).sendKeys(Keys.ESCAPE);
				WebElement ipselect = driver.findElement(By.xpath("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]"));
				ipselect.click();
				ipselect.sendKeys(Keys.ESCAPE);
				Select sel = new Select(ipselect);
				sel.selectByVisibleText(ip);
				List<WebElement> receivedList = driver.findElements(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body jss127 MuiTableCell-alignLeft'][4]"));
				Float totalReceived = 0f;
				for(WebElement received : receivedList) {
					totalReceived = totalReceived + getBandWidthInMb(received.getText());
				}
				
				return totalReceived;

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
					String timeValue1, String timetextXpath2, String handleXpath2, String timeValue2,
					String currentMonthXpath, String currentMonthSelXpath,  Boolean isFrom) throws InterruptedException {
				
				driver.findElement(By.xpath(inputXpath)).click();
				Thread.sleep(2000);
				((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath(currentMonthSelXpath)));
				Thread.sleep(500);
				driver.findElement(By.xpath(currentMonthXpath)).click();
				Thread.sleep(500);
				driver.findElement(By.xpath(dateXpath)).click();

				Actions actions = new Actions(driver);
				Thread.sleep(2000);
				WebElement elementText = driver.findElement(By.xpath(timetextXpath1));
				int i = 1;
				while (!elementText.getText().equals(timeValue1)) {
					WebElement element = driver.findElement(By.xpath(handleXpath1));
					int width = isFrom ? (elementText.getSize().getWidth() - i * 2): (elementText.getSize().getWidth() + i * 2);
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
					int width = isFrom ? (elementText1.getSize().getWidth() - i * 2): (elementText1.getSize().getWidth() + i * 2);
					actions.clickAndHold(element)
							.moveByOffset(width, elementText1.getSize().getHeight()).release()
							.build().perform();
					elementText1 = driver.findElement(By.xpath(timetextXpath2));
					i++;
				
				}
			}
			
		





		

	}


