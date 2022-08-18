package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

import com.google.common.graph.ElementOrder.Type;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class TestData {
	private static Map<String, Map<String, Object>> testData = null;

	public static Map<String, Object> getTestData(String moduleName)  {
		if (testData == null) {
			try {
				InputStream is = new FileInputStream("C:\\Users\\dell\\Desktop\\mails.json");
		        String jsonTxt = IOUtils.toString(is, "UTF-8");
		        java.lang.reflect.Type stringStringMap = new TypeToken<Map<String, Map<String, Object>>>(){}.getType();
		        testData = new Gson().fromJson(jsonTxt, stringStringMap);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return testData.get(moduleName);
	}
	
	
	public static String getTestDataValue(String moduleName, String parameter) {
		return getTestData(moduleName).get(parameter).toString();
	}
	
	public static String[] getTestDataArrayValue(String moduleName, String parameter) {
		List<String> data =((List<String>)getTestData(moduleName).get(parameter));
		String arr[] =new String[data.size()];
		data.toArray(arr);
		return arr;
	}
	
	public String COC_URL="https://dev.zybisys.com/login";
	public String USER_NAME="abdul@gmail.com";
	public String PASSWORD="Zybisys@321";
	
	/* Authentication TestData
	 * 
	 */
	public String validUserNames[] = {"abdul@gmail.com"} ;
	public String validPasswords[] = {"Zybisys@321"} ;
	
	public String negativeScenarioUserNames[] = {"- ! #,?", "ABC...123@gmail.com","",
			"ABDUL@GMAIL >COM", "@gmail.com", "trade#gmail.com", "123456", "trade#@gmail :com", "@gmail_com",
			 "12345"};
			
	
			
	public String negativeScenarioPassWords[] = { "Zybisys@","1234",
			
			"Zybisys#12345", "!@#$%^", "ZYBISYS", "1234 #(){}", "zybisys_908", "ZYBISYS()&^%",
			"", "zybi"} ;
	
	/* 
	 * Privilege TestData
	 * 
	 */
	
	public String addUser[] = {"FirstName : " + "test", "LastName : "+ "test1", "Email : " + "test1@gmail.com", "PhoneNumber : " + "8115453536"};
    public String passWord[] = { "Zybisys@321",  "Zybisys@123",  "Zybisys@123"};
    
    
    public String inValidFirstNames[] = {"!^_^", "abc-com", " |||||", "---test--- "};
    
    public String invalidEmail[] = {"!^-abc@gmail.com", "#$%&paru@gmail.com", "||||@gmail.com", "????@gmail.com", "****@gmail.com", "%%@gmail.com"};
    
    public String validFirstName = "testname";
    public String validLastName ="testname";
    public String validEmail ="test1@gmail.com";
    public String validPhone="9676543213";
    public String validCaseEmail ="zybisystest@gmail.com";
    public int minPhonenumber = 1111111111;
    public int maxPhonenumber = 2147483647;
    public String getValidPhone() {
    	return (new Random().nextInt(maxPhonenumber-minPhonenumber)+minPhonenumber)+"";
    }
    
    /*
     * Backup TestData
     * 
     */
    public long paymentCardNumber = 4242424242424242l;
    public int paymentMonth =03;
    public int paymentYear =23;
    public int paymentCvv=111;
    public int masterCardpwd= 1221;
    
    
    
    
	public String resetPasswordEmail="parameswari.theegala@zybisys.com";
	public String ZOHO_URL = "https://accounts.zoho.com/signin?servicename=VirtualOffice&signupurl=https://www.zoho.com/workplace/pricing.html";
	public String zohoUSER_NAME = "parameswari.theegala@zybisys.com";
	public String zohoPASSWORD = "achu@009#";
	public String waitForZoho = "2";
	public String cocwindownumber = "0";
	public String zohowindownumber = "1";
	public String waitforCOC = "5";
	
	/*
	 * DashBoard TestData
	 * 
	 */
	
	public String instace_URL = "https://dev.zybisys.com/coc/manage/instance";
	public String dashBoard_URL = "https://dev.zybisys.com/coc/dashboard";
	public String privilege_URL = "https://dev.zybisys.com/coc/privilege/users";
	public String backup_URL= "https://dev.zybisys.com/coc/manage/backup";
	public String performance = "https://dev.zybisys.com/coc/manage/zoom_view/graphs?lip=10.192.1.69&wip=154.83.3.29&datacenter=IN-MUM-WEST-1";
	public String assignVendor = "https://dev.zybisys.com/coc/dashboard/vendor-data?ip=10-192-1-69";
	public String instanceUrl = "https://dev.zybisys.com/coc/manage/instance";
	public String backupUrl = "https://dev.zybisys.com/coc/manage/backup";
	public String monitoringURL = "https://dev.zybisys.com/coc/manage/zoom_view/graphs?lip=10.192.1.68&wip=154.83.3.161&datacenter=IN-MUM-WEST-1";
	public String invoice ="https://dev.zybisys.com/coc/billings/invoices";
	public String bandwidth="https://dev.zybisys.com/coc/reports/bandwidth";
	public String InstanceNotification = "https://dev.zybisys.com/coc/manage/instance";
	

	
	
	
	
	
	public String baculum_URL = "http://10.192.1.83:9095/web/job/history/";
	
	public String FirstName= "swetha";
	public String lastName= "kumari";
	public String addUserEmail = "swetha@gmail.com";
	public String PhoneNumber = "9877655423";
	public String Invite ="submit";
	
	public String editUserName = "archana";
	public String editUserNameUpdate = "submit";
	public String editPassWord = "zybisys@123";
	
	

}
