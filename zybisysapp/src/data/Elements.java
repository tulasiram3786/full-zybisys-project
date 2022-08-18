package data;

import org.openqa.selenium.By;

public class Elements {
	private static Elements elements = null;

	public static Elements getElements() {
		if (elements == null) {
			elements = new Elements();
		}
		return elements;
	}
/*
 * COC Login Xpath
 * 
 */
	public Element userName = new Element("//input[@type='text']", ElementType.XPATH, "userName");
	public Element passWord = new Element("//input[@type='password']", ElementType.XPATH, "passWord");
	public Element submit = new Element("//button[@type='submit']", ElementType.XPATH, "submit");
/*
 * 	COC Forgot password Xpath
 */
	public Element forgotPassword = new Element("//a[text()='Forgot Password?']", ElementType.XPATH, "forgotPassword");
	public Element email = new Element("//input[@name='email']", ElementType.XPATH, "email");
	public Element generateOTP = new Element("//span[text()='Generate OTP']", ElementType.XPATH, "generateOTP");
//	public Element Sigin= new Element("(//a[text()='SIGN IN'])[2]", ElementType.XPATH, "Sigin");
	public Element zohoemail1 = new Element("//input[@type='email']", ElementType.XPATH, "zohoemail1");
	public Element zohonext = new Element("//span[text()='Next']", ElementType.XPATH, "zohonext");
	public Element zohopassword = new Element("//input[@name='PASSWORD']", ElementType.XPATH, "zohopassword");
	/*
	 * ZOHO Xpath
	 */
	public Element zohosigninLink = new Element("(//a[text()='SIGN IN'])[1]", ElementType.XPATH, "zohosigninLink");
	public Element zohosignin = new Element("//span[text()='Sign in']/parent::button", ElementType.XPATH, "zohosignin");
	public Element zybisysOTPMail = new Element("(//span[text()='Zybisys | OTP'])[1]", ElementType.XPATH, "zybisysOTPMail" );
	public Element ZybisysOTP = new Element("//td/h1", ElementType.XPATH,"ZybisysOTP");
	public Element OTPinput = new Element("(//input[@type='text'])[%s]", ElementType.XPATH, "OTPinput");
	
	public Element body = new Element("//body", ElementType.XPATH, "body");
	
	public Element search = new Element("//input[@type='text']", ElementType.XPATH, "search");
	/*
	 * Dashboard Xpath
	 */
//	public Element searchinstance = new Element("//input[@value='MCR42VM-CLOUD-ZYBISYS-COM-LIVE-154.83.3.29-10.192.1.69']", ElementType.XPATH, "searchinstance");
	public Element instanceTotal = new Element("//label[text()='Total']/following::label[1]", ElementType.XPATH, "instanceTotal");
	public Element Rowinstances = new Element("//div[@class='pointer']", ElementType.XPATH, "Rowinstances");
	public Element instanceUpWidzet = new Element("//label[text()='Up']/following::label[1]", ElementType.XPATH, "instanceup");
	public Element rowsInstanceUp = new Element("//*[@class='MuiSvgIcon-root MuiSvgIcon-colorSecondary']", ElementType.XPATH, "rowsInstanceUp");
	public Element instanceDownWidzet = new Element("//div[text()='Instances']/following::div[1]/div[3]/label[2]", ElementType.XPATH, "instancedown");
	public Element rowInstanceDown = new Element("//*[@class='MuiSvgIcon-root MuiSvgIcon-colorError']", ElementType.XPATH, "rowInstanceDown");
	public Element serviceTotal = new Element("(//label[text()='Total']/following::label[1])[2]", ElementType.XPATH, "serviceTotal");
	public Element servicesOkTotalCount = new Element("//div[@class='coc-instance-row']/div[6]", ElementType.XPATH, "servicesOkTotalCount");
	public Element serviceok = new Element("//div[text()='Services']/following::div[3]/label[2]", ElementType.XPATH, "serviceok");
	public Element okCountinstance = new Element("//div[@class='center-text font500 ok_text']", ElementType.XPATH, "okCountinstance");
	public Element servicewarn = new Element("//div[text()='Services']/parent::div//following::div[1]/div[3]/label[2]", ElementType.XPATH, "servicewarn");
	public Element instancewarnCount = new Element("//div[@class='center-text font500 warning_text']", ElementType.XPATH, "instancewarnCount");
	public Element servicesWarnTotalCount = new Element("//div[@class='coc-instance-row']/div[7]", ElementType.XPATH, "servicesWarnTotalCount");
	public Element servicecritical =  new Element("//div[text()='Services']/parent::div//following::div[1]/div[4]/label[2]", ElementType.XPATH, "servicecritical");
	public Element instancecritCount = new Element("//div[@class='center-text font500 danger_text']", ElementType.XPATH, "instancecritCount");
	public Element servicesCriticalTotalCount = new Element("//div[@class='coc-instance-row']/div[8]", ElementType.XPATH, "servicesCriticalTotalCount");
	/*
	 * COC Pending Ticket Xpath
	 */
	public Element pendingTickets = new Element("//span[text()='Pending Tickets']", ElementType.XPATH, "pendingTickets");
	public Element ClosedTickets = new Element("//span[text()='Closed Tickets']", ElementType.XPATH, "ClosedTickets");
	public Element BillingAmount =  new Element("(//div[text()='Billing'])[1]", ElementType.XPATH, "BillingAmount");
	public Element threedots = new Element("(//*[local-name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeSmall']/parent::span[1]/parent::button)[1]", ElementType.XPATH, "threedots");
	
	/*
	 * COC Actions Xpath
	 */
	public Element Actions = new Element("(//span[@class='MuiIconButton-label'])[8]", ElementType.XPATH, "Actions");
	public Element Actionsfirstrow = new Element("(//div[@class='coc-dashboard-row'])[2]/div[3]/p", ElementType.XPATH, "Actionsfirstrow");
	public Element performance = new Element("//a[text()='Performance']", ElementType.XPATH, "performance");
	public Element Assignvendor = new Element("//a[text()='Assign vendor']", ElementType.XPATH, "Assignvendor");
	public Element Addinstance = new Element("//span[text()='Add Instances']", ElementType.XPATH, "Addinstance");
	public Element checkbox = new Element("(//input[@type='checkbox'])[2]", ElementType.XPATH, "checkbox");
	public Element updateList = new Element("//span[text()='Update List']", ElementType.XPATH, "updateList");
	public Element Edittags = new Element("//li[text()='Edit Tags']", ElementType.XPATH, "Edittags");
	public Element closeTags = new Element("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeSmall']", ElementType.XPATH, "closeTags");
	
	public Element EdittagsText = new Element("//ul[@class='input-tag__tags']", ElementType.XPATH, "EdittagsText");
	public Element Managetags = new Element("(//input[@type='text'])[2]", ElementType.XPATH, "Managetags");
	public Element Tagsubmit = new Element("//span[text()='Submit']", ElementType.XPATH, "Tagsubmit");
	public Element Editinstance = new Element("//li[text()='Edit Instance']", ElementType.XPATH, "Editinstance");
	public Element EnterinstanceName = new Element("(//input[@type='text'])[3]", ElementType.XPATH, "EnterinstanceName");
	public Element Changename = new Element("//span[text()='Change Name']", ElementType.XPATH, "Changename");
	public Element yes = new Element("//button[text()='Yes']", ElementType.XPATH, "yes");
	
	/*
	 * COC Dashboard Child Tags Xpath
	 * 
	 */
	
	public Element InstanceTag = new Element("(//div[@class=\"h2\"][text()='Instance'])[1]", ElementType.XPATH, "InstanceTag");
	public Element BackupTag = new Element("//div[text()='Backup']", ElementType.XPATH, "BackupTag");
	public Element montoringTag = new Element("//div[text()='Monitoring']", ElementType.XPATH, "montoringTag");
	public Element BillingTag = new Element("(//div[text()='Billing'])[2]", ElementType.XPATH, "BillingTag");
	public Element ReportTag = new Element("//div[text()='Report']", ElementType.XPATH, "ReportTag");
	
	/*
	 * Privilege (Add User) Xpaths
	 * 
	 */
	
	public Element AddUser = new Element("//span[text()='Add User']", ElementType.XPATH, "AddUser");
	public Element FirstName = new Element("(//input[@type='text'])[2]", ElementType.XPATH, "FirstName");
	public Element lastName = new Element("(//input[@type='text'])[3]", ElementType.XPATH, "lastName");
	public Element addUserEmail = new Element("(//input[@type='text'])[4]", ElementType.XPATH, "addUserEmail");
	public Element PhoneNumber = new Element("//input[@type='number']", ElementType.XPATH, "PhoneNumber");
	public Element addUserInvite = new Element("//span[@class='MuiButton-label']/following::span[text()='Invite']", ElementType.XPATH, "addUserInvite");
	public Element userTable = new Element("//div[@class='MuiGrid-root MuiGrid-container']", ElementType.XPATH, "userTable");
	
	public Element threeDots = new Element("//div[@class='coc-user-row'][last()]/div/div/button", ElementType.XPATH, "threeDots");
	
	/*
	 * Privilege (Edit User) Xpaths
	 * 
	 */
	public Element editUser = new Element("//span[text()='Edit']", ElementType.XPATH, "editUser");
	public Element editUserName = new Element("//span[text()='Edit']", ElementType.XPATH, "editUserName");
	public Element newUserName =  new Element("(//input[@type='text'])[2]", ElementType.XPATH, "newUserName");
	public Element newUserNameUpdate = new Element("//span[text()='Update']", ElementType.XPATH, "newUserNameUpdate");
	
	/*
	 * Privilege (PassWord) Xpaths
	 * 
	 */
	public Element editPassWord = new Element("//span[text()='Password']", ElementType.XPATH, "editPassWord");
	public Element yourCurrentPassWord = new Element("//span[text()='Password']", ElementType.XPATH, "yourCurrentPassWord");
	public Element yourCurrentPassWordSubmit = new Element("//input[@type='password']", ElementType.XPATH, "yourCurrentPassWordSubmit");
	public Element submitPassWord = new Element("//span[text()='Submit']", ElementType.XPATH, "submitPassWord");
	public Element newPassWord = new Element("//label[text()='New Password']/following::div[1]/input", ElementType.XPATH, "newPassWord");
	public Element conFirmPassWord = new Element("//label[text()='Confirm Password']/following::div[1]/input", ElementType.XPATH, "conFirmPassWord");
	public Element resetSubmit = new Element("//span[text()='Submit']", ElementType.XPATH, "resetSubmit");
	public Element verifyEmail = new Element("//span[text()='Verify mail']", ElementType.XPATH, "verifyEmail");
	public Element passwordThreeDots = new Element("//div[text()='#$%&paru@gmail.com']/following::div[3]/div/button", ElementType.XPATH, "passwordThreeDots");
	public Element delete = new Element("//span[text()='Delete']", ElementType.XPATH, "delete");
	public Element confirmDelete = new Element("//button[text()='Yes']", ElementType.XPATH, "confirmDelete");
	
	public Element instance = new Element("//span[text()='Instances']", ElementType.XPATH, "instance");
	public Element rowInstanceCount = new Element("//div[@class='coc-instance-row']", ElementType.XPATH, "rowInstanceCount");
	public Element warningInstance = new Element("//span[text()='Warnings']", ElementType.XPATH, "warningInstance");
	public Element criticalsInstance = new Element("//span[text()='Criticals']", ElementType.XPATH, "criticalsInstance");
//	public Element notification =  new Element("(//*[local-name()='svg']/following::*[local-name()='path']/following::div[@class='center-text'])[2]",ElementType.XPATH, "notification");
	public Element todayNotification = new Element("//span[text()='Today there is no notifications']", ElementType.XPATH, "todayNotification");
	public Element previousNotification =  new Element("//span[text()='View Previous Notifications']", ElementType.XPATH, "previousNotification");
	public Element previousNotificationText =  new Element("(//span[@class=\"sc-hiKfDv dRsyqq\"])[2]", ElementType.XPATH, "previousNotificationText");
	
	public Element okText = new Element("//div[@class='center-text font500 ok_text']", ElementType.XPATH, "okText");
	public Element warningText = new Element("//div[@class='center-text font500 warning_text']", ElementType.XPATH, "warningText");
	public Element criticalText = new Element("//div[@class='center-text font500 danger_text']", ElementType.XPATH, "criticalText");
	public Element threeDotsInstance = new Element("(//span[@class='MuiIconButton-label'])[8]", ElementType.XPATH, "threeDotsInstance");
	public Element instancePerformance = new Element("//a[text()='Performance']", ElementType.XPATH, "instancePerformance");
	public Element instanceTable = new Element("(//div[@class='jss95 jss96'])[1]", ElementType.XPATH, "instanceTable");
	
	public Element all_instances = new Element("//div[text()='Instance']/parent::div[1]/following::div[@class='left-text font400 pointer']", ElementType.XPATH, "all instances");
	public Element instance1 = new Element("//div[text()='Instance']/parent::div[1]/following::div[@class='left-text font400 pointer'][%s]", ElementType.XPATH, "instance");

	
	public Element window = new Element("//div[@class='sc-giAqHp bYgUJS']", ElementType.XPATH, "window");
	public Element calculatedInstanceOkCount = new Element("//div[text()='Instance']/parent::div[1]/following::div[@class= 'center-text font500 ok_text'][%s]", ElementType.XPATH, "calculatedInstaceOkCount");
	public Element AllcalculatedInstanceOkCount = new Element("//div[text()='Instance']/parent::div[1]/following::div[@class= 'center-text font500 ok_text']", ElementType.XPATH, "calculatedInstaceOkCount");
	public Element calculatedInstaceWarnCount = new Element("//div[text()='Instance']/parent::div[1]/following::div[@class= 'center-text font500 warning_text'][%s]", ElementType.XPATH, "calculatedInstanceWarnCount");
	public Element calculatedInstanceCriticalCount = new Element("//div[text()='Instance']/parent::div[1]/following::div[@class= 'center-text font500 danger_text'][%s]", ElementType.XPATH, "calculatedInstanceCriticalCount");
	
	public Element instanceokcount = new Element("//span[text()='OK']", ElementType.XPATH, "instanceokcount");
	
	
	public Element warnCount = new Element("//span[text()='WARN']", ElementType.XPATH, "instance");
	public Element critCount = new Element("//span[text()='CRIT']", ElementType.XPATH, "instance");
	
	public Element threeDotsInstance1 = new Element("(//*[@class='MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeSmall']/parent::span/parent::button)[1]", ElementType.XPATH, "threeDotsInstance1");
	public Element instancePerformane = new Element("//a[text()='Performance']", ElementType.XPATH, "instancePerformane");
	
	
	public Element notificationInstance = new Element("(//*[@class='MuiSvgIcon-root pointer MuiSvgIcon-colorPrimary'])[1]", ElementType.XPATH, "notificationInstance");
	public Element viewNotification = new Element("/span[text()='View Previous Notifications']", ElementType.XPATH, "viewNotificatio");
	
	
/*
 * COC module Backup Xpaths
 * 
 */
	public Element Subscription = new Element("//span[text()='Subscription']", ElementType.XPATH, "Subscription");
	public Element purchase = new Element("//button[text()='Purchase']", ElementType.XPATH, "purchase");
	public Element searchInstance = new Element("//input[@id='outlined-adornment-search']", ElementType.XPATH, "searchInstance");
	public Element addInstance = new Element("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd']", ElementType.XPATH, "addInstance");
	public Element proceed = new Element("//button[text()='Proceed']", ElementType.XPATH, "proceed");
	public Element creditcardNumber = new Element("//a[@class='btn btn-block text-left text-transform-none']/parent::li", ElementType.XPATH, "creditcardNumber");
	
	public Element cardNumber = new Element("//input[@name='account_number']", ElementType.XPATH, "cardNumber");
	public Element expiryMonth = new Element("//input[@id='card-expiry-month']", ElementType.XPATH, "expiryMonth");
	public Element expiryyear = new Element("//input[@id='card-expiry-year']", ElementType.XPATH, "expiryyear");
	public Element cvv = new Element("//input[@id='card-cvv']", ElementType.XPATH, "cvv");
	public Element paySubmit = new Element("//button[@id='submit-form-button']", ElementType.XPATH, "paySubmit");
	public Element masterCardPassWord = new Element("//input[@id='txtPassword']", ElementType.XPATH, "masterCardPassWord");
	public Element masterCardSubmit = new Element("//input[@id='cmdSubmit']", ElementType.XPATH, "masterCardSubmit");
	public Element subscriptionThreeDots= new Element("(//*[local-name()='path']/parent::*[local-name()='svg']//following::span[@class='MuiIconButton-label'])[7]", ElementType.XPATH, "subscriptionThreeDots");
	public Element viewJobs = new Element("//li[text()='View Jobs']", ElementType.XPATH, "viewJobs");
	public Element jobs = new Element("//span[text()='Jobs']", ElementType.XPATH, "jobs");
	public Element clientInstances = new Element("(//select[@class='MuiSelect-root MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input'])[2]", ElementType.XPATH, "clientInstances");
	public Element option = new Element("//option[text()='10.192.1.66 - Zybisys-win']", ElementType.XPATH, "option");
	public Element instanceAdd = new Element("//span[text()='+ Add']", ElementType.XPATH, "instanceAdd");
	public Element backupVolumeFolder= new Element("//li[@title='D:/Backup_volume_testing']", ElementType.XPATH, "backupVolumeFolder");
	public Element backupInclude = new Element("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[1]", ElementType.XPATH, "backupInclude");
	public Element nameBackup = new Element("//input[@id='name-backup']", ElementType.XPATH, "nameBackup");
	public Element levelBackup = new Element("//label[@id='type-of-backup']", ElementType.XPATH, "levelBackup");
	public Element backupNext = new Element("//button[text()='Next']", ElementType.XPATH, "backupNext");
	public Element backupDaily = new Element("(//input[@type='radio'])[2]", ElementType.XPATH, "backDaily");
	public Element hoursBackup = new Element("//div[@id='backup-type-select'])[2]", ElementType.XPATH, "hoursBackup");
	public Element minutesBackup = new Element("(//div[@id='backup-type-select'])[2]", ElementType.XPATH, "minutesBackup");
	public Element nextBackup = new Element("//button[text()='Next']", ElementType.XPATH, "nextBackup");
	public Element timeProceed = new Element("//button[text()='Procced']", ElementType.XPATH, "timeProceed");
	public Element close = new Element("//button[text()='Close']", ElementType.XPATH, "close");
	public Element verifyJob = new Element("//div[@class='MuiBox-root jss311']", ElementType.XPATH, "verifyJob");
	
	
	
	public Element paymentIframe = new Element("//iframe", ElementType.XPATH, "paymentIframe");
	public Element paymentCardNumber = new Element("//input[@id='card-number']", ElementType.XPATH, "paymentCardNumber");
	public Element paymentMonth = new Element("//input[@id='card-expiry-month']", ElementType.XPATH, "paymentMonth");
	public Element paymentYear = new Element("//input[@id='card-expiry-year']", ElementType.XPATH, "paymentYear");
	public Element paymentCvv = new Element("//input[@id='card-cvv']", ElementType.XPATH, "paymentCvv");
	public Element paymentPay = new Element("//button[@id='submit-form-button']", ElementType.XPATH, "paymentPay");
	
	
	
	public Element baculumStatus = new Element("//i[@title='Terminated normally']", ElementType.XPATH, "baculumStatus");
	
	/*
	 * Admin VM Master Xpaths
	 * 
	 */
	public Element VMMaster = new Element("//a[@href='vm-masters']",ElementType.XPATH, "VMMaster");
	public Element AddServer = new Element("//span[text()='Add Servers']",ElementType.XPATH, "AddServer");
	public Element VMInput = new Element("//h5[text()='Select Customer']/following::div[1]/div/span/input[@type='search']",ElementType.XPATH, "VMInput");
	public Element DropDownCustomer = new Element("//div/div[@class='rc-virtual-list']/div/div/div/div/div[text()='Dummy FINANCIAL SERVICES PRIVATE LIMITED'])[1]",ElementType.XPATH,"DropDownCustomer");
	public Element InputSearch = new Element("//input[@type='search']",ElementType.XPATH, "InputSearch");
	public Element VMHostName = new Element("//input[@id='vm_hostname']", ElementType.XPATH, "VMHostName");
	public Element VMOs = new Element("//input[@id='vm_os']", ElementType.XPATH, "VMOs");
	public Element VMCpu = new Element ("//input[@placeholder='Enter CPU Core']", ElementType.XPATH, "VMCpu");
	public Element VMRam = new Element("//input[@id='vm_ram']", ElementType.XPATH, "VMRam");
	public Element VMHdd = new Element("//input[@id='vm_hdd']", ElementType.XPATH, "VMHdd");
	public Element VMLanIp = new Element("//input[@id='vm_lan_ip']", ElementType.XPATH, "VMIp");
	public Element VMWanIp = new Element("//input[@id='vm_wan_ip']", ElementType.XPATH, "VMWanIp");
	public Element VMSubmit = new Element("//span[text()='Submit']/parent::button", ElementType.XPATH, "VMSubmit");
	public Element VMTotal = new Element("//h4[text()='Total Machines']/following::div[2]/following::h4[text()='180']", ElementType.XPATH, "VMTotal");
	public Element VMTotalCount = new Element("//tr[@class='ant-table-row ant-table-row-level-0']", ElementType.XPATH, "VMTotalCount");
	public Element poweredonvms = new Element("//h4[text()='Virtual Machines']/following::div[1]/div[1]/div/h4", ElementType.XPATH, "poweredonvms");
	public Element poweredonvmscount = new Element("//*[local-name()='svg'][@style='color: green;']/following::td[2]/span/span[text()='Virtual Machine']", ElementType.XPATH, "poweredonvmscount");
	public Element poweredoffvms = new Element("//h4[text()='Virtual Machines']/following::div[1]/div[2]/div/h4", ElementType.XPATH, "poweredoffvms");
	public Element poweredoffvmscount = new Element("//*[local-name()='svg'][@style='color: red;']/following::td[2]/span/span[text()='Virtual Machine']", ElementType.XPATH, "poweredoffvmscount");
	public Element poweredonvmspm = new Element("//h4[text()='Physical Machines']/following::div/div/div/div/following::h4[text()='6']", ElementType.XPATH,"poweredonvmspm");
	public Element poweredonvmspmcount = new Element("//*[local-name()='svg'][@style='color: green;']/following::td[2]/span/span[text()='Physical Machine']", ElementType.XPATH, "poweredonvmspmcount");
	public Element poweredoffvmspm = new Element("//h4[text()='Physical Machines']/following::div[7]/following::h4[text()='1']", ElementType.XPATH, "poweredoffvmspm");
	public Element poweredoffvmspmcount = new Element("//*[local-name()='svg'][@style='color: red;']/following::td[2]/span/span[text()='Physical Machine']", ElementType.XPATH, "poweredoffvmspmcount");
	
	
	
	
	
	
	
			

}
