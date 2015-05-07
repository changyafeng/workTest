package crossBrowsers;

import java.io.IOException;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;

import com.thoughtworks.selenium.Selenium;







public class AutomationScript extends IntialScrip {
	public static void Login() throws Exception {

		int i = 100;
		
		System.out.println(i);
		
		
		
	
		driver.get("https://login.salesforce.com/");
		ReusableMethod.enterText("id","username", "Username@gmail.com", "UserName");
		
		String userName = driver.findElement(By.id("username")).getAttribute("value");
		System.out.println(userName);
		
		
		driver.get("https://www.salesforce.com/");  // Launch Sales force application

		driver.manage().window().maximize();  // Will maximize the window

		
		/*Click Login*/
		ReusableMethod.clickObj("css","#button-login", "Login");
		Thread.sleep(5000);
		/*Enter username*/
		ReusableMethod.enterText("id","username", "Username@gmail.com", "UserName");
		
		/*Enter Pwd*/
		ReusableMethod.enterText("id","password", "Password@123", "Password");
		
		/*Click Login to SFDC*/
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");

		
	}
	  public static void loginToSalesForce() throws InterruptedException, IOException{
		  
		  driver.get("https://login.salesforce.com/");
			Thread.sleep(3000);
			ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
			ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
			ReusableMethod.clickObj("css","#Login", "Login to SFDC");
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
			Thread.sleep(3000);
		  
	  }
	  
	  public static void checkRemeber() throws Exception{
		  
		  driver.get("https://login.salesforce.com/");
		  Thread.sleep(3000);
		  ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		  ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		  ReusableMethod.selectCheckBox("xpath","//input[@id='rememberUn']", "CheckBox");
		  ReusableMethod.clickObj("xpath","//button[@id='Login']", "Login to SFDC");
		  Thread.sleep(3000);
		  ReusableMethod.clickObj("xpath",".//*[@id='userNav-arrow']", "user menu");
		  Thread.sleep(3000);
		  ReusableMethod.clickObj("xpath",".//*[@id='userNav-menuItems']/a[4]", "Logout");
//		  ReusableMethod.validateText("xpath",".//*[@id='username']", "282221264@qq.com","username");
		  
	  }
	  
	  public static void forgotPasswordA() throws Exception{
		  
		  driver.get("https://login.salesforce.com/");
		  Thread.sleep(3000);
		  ReusableMethod.clickObj("xpath",".//*[@id='forgot']/span[1]/a", "Forgot your password");
		  Thread.sleep(3000);
		  ReusableMethod.enterText("xpath",".//*[@id='un']", "282221264@qq.com", "username");
		  ReusableMethod.clickObj("xpath",".//*[@id='continue']", "Continue-button");
		 
	  }
	
	
	public static void forgotPasswordB() throws Exception{
		  driver.get("https://login.salesforce.com/");
		  Thread.sleep(3000);
		  ReusableMethod.enterText("xpath","//input[@id='username']", "123", "username");
		  ReusableMethod.enterText("xpath","//input[@id='password']", "22131", "password");
		  ReusableMethod.clickObj("xpath","//button[@id='Login']", "Login to SFDC");
		  ReusableMethod.validateText("xpath",".//*[@id='error']", "Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help.","Errer text");
		  
	}
	public static void runMe(){
		System.out.println("RunMe method is working...");
		resultFlag = 1;
	}
	public static void selectUserMenu() throws IOException, InterruptedException{
		loginToSalesForce();
		ReusableMethod.clickObj("xpath",".//*[@id='userNavLabel']", "user menu");
		
	}
	public static void selectMyProfile() throws IOException, InterruptedException{
		selectUserMenu();
		ReusableMethod.clickObj("xpath",".//*[@id='userNav-menuItems']/a[1]", "My Profile");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img", "edit profile");
		Thread.sleep(3000);
		driver.switchTo().frame("contactInfoContentId");
		ReusableMethod.clickObj("xpath",".//*[@id='aboutTab']/a", "About tab");
		ReusableMethod.enterText("xpath",".//*[@id='lastName']", "chan", "LastName");
		ReusableMethod.clickObj("xpath",".//*[@id='TabPanel']/div/div[2]/form/div/input[1]", "Save all");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='publisherAttachTextPost']/span[1]", "Post");
		ReusableMethod.enterText("xpath",".//*[@id='TabPanel']/div/div[2]/form/div/input[1]", "hi", "Text area");
		ReusableMethod.clickObj("xpath",".//*[@id='publishersharebutton']", "Share Button");
		Thread.sleep(3000);
		//Step6 and 7upload file and upload image, I do not know how to create script
//		ReusableMethod.clickObj(".//*[@id='publisherAttachContentPost']/span[1]", "File");
//		ReusableMethod.clickObj(".//*[@id='chatterUploadFileAction']", "Upload a file from computer");
//		ReusableMethod.clickObj(".//*[@id='chatterFile']", "Choose file");
		
		
		
		
	}
	public static void selectMySetting() throws IOException, InterruptedException{
		selectUserMenu();
		ReusableMethod.clickObj("xpath",".//*[@id='userNav-menuItems']/a[2]", "My Setting");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='PersonalInfo']/a", "Personal");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='LoginHistory_font']", "Log History");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='RelatedUserLoginHistoryList_body']/div/a", "Download Log History");
		Thread.sleep(10000);
		ReusableMethod.clickObj("xpath",".//*[@id='DisplayAndLayout']/a", "Display and Layout");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='CustomizeTabs_font']", "Customize My Tabs");
		Thread.sleep(3000);
		
		ReusableMethod.selectDropdown("css", "#p4", "Salesforce Chatter");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='duel_select_0']/option[26]", "Reports");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='duel_select_0_right']/img", "ADD");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='bottomButtonRow']/input[1]", "Save");
		Thread.sleep(5000);
		ReusableMethod.clickObj("xpath",".//*[@id='EmailSetup_font']", "Email");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='EmailSettings_font']", "Email Setting");
		Thread.sleep(3000);
		ReusableMethod.enterText("xpath",".//*[@id='sender_name']", "Neal lslsl", "Email Name");
		ReusableMethod.enterText("xpath",".//*[@id='sender_email']", "282221264@qq.com", "Email Address");
		ReusableMethod.selectCheckBox("xpath",".//*[@id='auto_bcc1']", "Automatic BBC");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='bottomButtonRow']/input[1]", "Save");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='CalendarAndReminders_font']", "Calendar and Reminder");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='Reminders_font']", "Reminder Alerts");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='testbtn']", "Preview Reminder Alert");
		Thread.sleep(5000);
		
	}
	public static void selectDevelopersConsole() throws IOException, InterruptedException{
		selectUserMenu();
		ReusableMethod.clickObj("xpath",".//*[@id='userNav-menuItems']/a[3]", "Developer Console");
		//I do not know how to get xpath of close button

	}
	public static void selectLogout() throws IOException, InterruptedException{
		selectUserMenu();
		ReusableMethod.clickObj("xpath",".//*[@id='userNav-menuItems']/a[4]", "Log out");
	}
	public static void printText() throws IOException, InterruptedException{
		loginToSalesForce();
		driver.switchTo().frame("itarget");
		ReusableMethod.validateText("xpath", ".//*[@id='layout']/div[1]/div/div/h2", "Text is wrong", "Text");
		String display;
		display = driver.findElement(By.xpath(".//*[@id='layout']/div[1]/div/div/h2")).getText();
		System.out.println(display);
	}
	public static void createAccount() throws IOException, InterruptedException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Accounts Tab']", "Account");
		Thread.sleep(5000);
		ReusableMethod.clickObj("css","input[name='new']", "New button");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#acc2", "Amazon2", "account name");
		ReusableMethod.clickObj("css","input[name='save']", "Save button");
		Thread.sleep(5000);
	}
	public static void createNewView() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Accounts Tab']", "Account");
		Thread.sleep(5000);
		ReusableMethod.clickObj("xpath","//span[2]/a[2]", "Create new view");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#fname", "Neal", "View Name");
		ReusableMethod.enterText("css","#devname", "A", "View unique name");
		ReusableMethod.clickObj("css","input[name='save']", "Save");
	}
	public static void editView() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Accounts Tab']", "Account");
		Thread.sleep(5000);
		ReusableMethod.selectDropdown("css", "#fcf", "Neal");
		Thread.sleep(5000);
		ReusableMethod.clickObj("xpath","//div/form/div/div/div/a", "Edit");
		ReusableMethod.enterText("css","#fname", "laldkdk", "New View Name");
		ReusableMethod.selectDropdown("css", "#fcol1", "Account Name");
		ReusableMethod.selectDropdown("css", "#fop1", "contains");
		ReusableMethod.enterText("css","#fval1", "a", "Value");
		ReusableMethod.selectDropdown("css", "#colselector_select_0", "Last Activity");
		ReusableMethod.clickObj("css","img.rightArrowIcon", "Add");
		ReusableMethod.clickObj("css","div.pbBottomButtons > table > tbody > tr > td.pbButtonb > input[name='save']", "Save");
		
	}
	public static void mergeAccount() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Accounts Tab']", "Account");
		Thread.sleep(5000);
		ReusableMethod.clickObj("xpath","//li[5]/span/a", "Merge Account");
		Thread.sleep(5000);
		ReusableMethod.enterText("css","#srch", "Amazon", "Search text");
		ReusableMethod.clickObj("css","div.pbWizardBody > input[name='srchbutton']", "Find Account");
		Thread.sleep(3000);
//		ReusableMethod.clickObj("css","#cid0", "Choose box");
//		ReusableMethod.clickObj("css","#cid1", "Choose box");
		Thread.sleep(3000);
		//In chrome, the button will have not clickable bug
		ReusableMethod.clickObj("css","div.pbBottomButtons > input[class='btn']", "Next");
		Thread.sleep(5000);
		ReusableMethod.clickObj("css","div.pbBottomButtons > input[name='save']", "Merge");
		
		
	}
	public static void createAccountReport() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Accounts Tab']", "Account");
		Thread.sleep(5000);
		ReusableMethod.clickObj("xpath","//div/ul/li[2]/a", "Account report link");
		Thread.sleep(5000);
//		ReusableMethod.selectDropdown("css", "#ext-gen148", "Created Date");
		ReusableMethod.clickObj("css","#ext-gen148", "Date Field");
//		ReusableMethod.selectDropdown("id", "ext-gen242", "Created Date");
		ReusableMethod.clickObj("xpath","//div[@id='ext-gen241']/div[3]", "Created date");
		Thread.sleep(5000);
		ReusableMethod.clickObj("css","#ext-gen152", "From");
		Thread.sleep(5000);
		ReusableMethod.clickObj("id","ext-gen257", "Today");
		Thread.sleep(5000);
		ReusableMethod.clickObj("css","#ext-gen49", "Save");
		Thread.sleep(5000);
		ReusableMethod.enterText("css","#saveReportDlg_reportNameField", "repo", "Report Name");
		ReusableMethod.clickObj("css", "#saveReportDlg_DeveloperName", "Report Unique Name");
		Thread.sleep(3000);
		//chrome browser does not work, after save and run,it will disappear
		ReusableMethod.clickObj("css","#ext-gen280", "Save and run");
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","#buttonLater", "Later");
	}
	public static void dropDownMenu() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Opportunities Tab']", "Opportunities");
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","#fcf", "Drop Down Menu");
	}
	public static void createNewOpty() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Opportunities Tab']", "Opportunities");
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","input[name='new']", "New");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#opp3", "sale", "Opty Name");
		ReusableMethod.enterText("css","#opp4", "Amazon", "Account Name");
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","#opp9", "Close date");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath","//td[2]/div[2]/div[2]/div/a", "Today");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath","//tr[2]/td[3]", "close date");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "#opp11", "Closed Won");
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","#bottomButtonRow > input[name='save']", "save");
		
	}
	public static void optyPipelineRep() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Opportunities Tab']", "Opportunities");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a", "Opty Pipeline link");
	}
	public static void stuckOptyRep() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Opportunities Tab']", "Opportunities");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a", "Stuck Opportunities link");
	}
	public static void quarterlySummaryRep() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","a[title='Opportunities Tab']", "Opportunities");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "#quarter_q", "Next FQ");
		ReusableMethod.selectDropdown("css", "#open", "Open Opportunities");
		ReusableMethod.clickObj("css","td > input[name='go']", "Run report");
		Thread.sleep(10000);
	}
	public static void getQuoteData() throws InterruptedException, IOException{
		driver.get("https://www.statefarm.com/");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='insurance-menuitem']/span", "Insurance");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "select[name='productName']", "Homeowners");
		Thread.sleep(3000);
		ReusableMethod.enterText("xpath","//div[2]/form/div/input", "94539", "Zipcode");
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","div.controls > input[name='submit']", "Go");
		Thread.sleep(20000);
		ReusableMethod.enterText("css","#firstName-sfxid_3", "obama", "FirstName");
		ReusableMethod.enterText("css","#middleName-sfxid_4", "b", "MiddleName");
		ReusableMethod.enterText("css","#lastName-sfxid_5", "washington", "LastName");
		ReusableMethod.selectDropdown("css", "#suffix-sfxid_6", "Sr");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#street1-sfxid_7", "washington ave", "Stree Address");
		ReusableMethod.enterText("css","#street2-sfxid_8", "1234", "Apt/Suit Number");
		ReusableMethod.enterText("xpath",".//*[@id='primaryApplicantDOBId']/div[1]/input", "11", "Month");
		ReusableMethod.enterText("xpath",".//*[@id='primaryApplicantDOBId']/div[3]/input", "12", "Date");
		ReusableMethod.enterText("xpath",".//*[@id='primaryApplicantDOBId']/div[5]/input", "1985", "Year");
		ReusableMethod.clickObj("css","#buttonContinueId > span", "Continue");
		

	}
	public static void checkLeads() throws InterruptedException, IOException{
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='Lead_Tab']/a", "Leads");
	}
	public static void validateViewDropDown() throws InterruptedException, IOException{
		checkLeads();
		ReusableMethod.clickObj("css","#fcf", "View Drop Down");
	}
	public static void functionalityGoButton() throws InterruptedException, IOException{
		checkLeads();
		ReusableMethod.selectDropdown("css", "#fcf", "Today's Leads");
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","#userNavButton", "User Menu");
		ReusableMethod.clickObj("css",".menuButtonMenuLink", "Logout");
		Thread.sleep(5000);
		checkLeads();
		ReusableMethod.clickObj("xpath",".//*[@id='filter_element']/div/span/span[1]/input", "Go!");
		Thread.sleep(5000);
	}
	public static void listItemTodaysLeads() throws InterruptedException, IOException{
		checkLeads();
		ReusableMethod.selectDropdown("css", "#fcf", "Today's Leads");
	}
	public static void checkNewLeads() throws InterruptedException, IOException{
		checkLeads();
		ReusableMethod.clickObj("xpath",".//*[@id='hotlist']/table/tbody/tr/td[2]/input", "New");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#name_lastlea2", "ABCD", "Lastname");
		ReusableMethod.enterText("css","#lea3", "ABCD", "Company name");
		ReusableMethod.clickObj("xpath",".//*[@id='bottomButtonRow']/input[1]", "Save");
		Thread.sleep(3000);
	}
	public static void createNewContact() throws InterruptedException, IOException{
		checkLeads();
		ReusableMethod.clickObj("xpath",".//*[@id='Contact_Tab']/a", "Contact");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='hotlist']/table/tbody/tr/td[2]/input", "New");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#name_lastcon2", "ABCD", "Last Name");
		ReusableMethod.enterText("css","#con4", "Amazon", "Account Name");
		ReusableMethod.clickObj("xpath",".//*[@id='topButtonRow']/input[1]", "Save");
		Thread.sleep(3000);
	}
	public static void newViewContact() throws InterruptedException, IOException {
		loginToSalesForce();
		ReusableMethod.clickObj("xpath",".//*[@id='Contact_Tab']/a", "Contact");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='filter_element']/div/span/span[2]/a[2]", "Create New View");
		Thread.sleep(3000);
		ReusableMethod.enterText("xpath",".//*[@id='fname']", "dkdk", "View Name");
		ReusableMethod.clickObj("xpath",".//*[@id='devname']", "View Unique Name");
		ReusableMethod.clickObj("xpath",".//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]", "Save");
		Thread.sleep(3000);
	}
	public static void recentlyContact() throws InterruptedException, IOException{
		loginToSalesForce();
		ReusableMethod.clickObj("xpath",".//*[@id='Contact_Tab']/a", "Contact");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "#hotlist_mode", "Recently Created");
		Thread.sleep(5000);
	}
	public static void checkMyContacts() throws InterruptedException, IOException{
		loginToSalesForce();
		ReusableMethod.clickObj("xpath",".//*[@id='Contact_Tab']/a", "Contact");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "#fcf", "My Contacts");
		Thread.sleep(5000);
	}
	public static void viewAContact() throws InterruptedException, IOException{
		loginToSalesForce();
		ReusableMethod.clickObj("xpath",".//*[@id='Contact_Tab']/a", "Contact");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a", "A Contact Name");
		Thread.sleep(3000);
		
	}
	public static void checkCancel() throws InterruptedException, IOException{
		loginToSalesForce();
		ReusableMethod.clickObj("xpath",".//*[@id='Contact_Tab']/a", "Contact");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='filter_element']/div/span/span[2]/a[2]", "Create New View");
		Thread.sleep(3000);
		ReusableMethod.enterText("xpath",".//*[@id='fname']", "dkdk", "View Name");
		ReusableMethod.clickObj("xpath",".//*[@id='devname']", "View Unique Name");
		
		ReusableMethod.clickObj("xpath",".//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[2]", "Cancel");
		Thread.sleep(3000);
	}
	public static void checkSaveNew() throws InterruptedException, IOException{
		checkLeads();
		ReusableMethod.clickObj("xpath",".//*[@id='Contact_Tab']/a", "Contact");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='hotlist']/table/tbody/tr/td[2]/input", "New");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#name_lastcon2", "ABCDee", "Last Name");
		ReusableMethod.enterText("css","#con4", "Amazon", "Account Name");
		ReusableMethod.clickObj("xpath",".//*[@id='topButtonRow']/input[2]", "Save and New");
		Thread.sleep(3000);
	}
	public static void verifyName() throws InterruptedException, IOException{
		loginToSalesForce();
		ReusableMethod.clickObj("xpath",".//*[@id='home_Tab']/a", "Home");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='ptBody']/div/div/span[1]/h1/a", "Username Link");
		Thread.sleep(5000);
		
	}
	public static void verifyUpdate() throws InterruptedException, IOException{
		verifyName();
		ReusableMethod.clickObj("xpath",".//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img", "Edit Profile");
		Thread.sleep(3000);
		driver.switchTo().frame("contactInfoContentId");
		ReusableMethod.clickObj("xpath",".//*[@id='aboutTab']/a", "About");
		Thread.sleep(3000);
		ReusableMethod.enterText("xpath",".//*[@id='lastName']", "Abed", "Last Name");
		ReusableMethod.clickObj("xpath",".//*[@id='TabPanel']/div/div[2]/form/div/input[1]", "Save All");
		Thread.sleep(5000);
	}
	public static void checkTabCustomization() throws InterruptedException, IOException{
		loginToSalesForce();
		ReusableMethod.clickObj("xpath",".//*[@id='AllTab_Tab']/a/img", "All Tab");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='bodyCell']/div[3]/div[1]/table/tbody/tr/td[2]/input", "Customize My Tabs");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='duel_select_1']/option[10]", "Files");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='duel_select_0_left']/img", "Remove");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='bottomButtonRow']/input[1]", "Save");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='userNavLabel']", "user name");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='userNav-menuItems']/a[4]", "Log out");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#username", "282221264@qq.com", "username");
		ReusableMethod.enterText("css","#password", "woshitiancai223", "password");
		ReusableMethod.clickObj("css","#Login", "Login to SFDC");
		Thread.sleep(5000);
		
	}
}
