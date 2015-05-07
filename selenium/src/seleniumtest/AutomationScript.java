package seleniumtest;

import java.io.IOException;

import org.openqa.selenium.By;





public class AutomationScript extends IntialScrip {
	public static void Login() throws Exception {

		int i = 100;
		
		System.out.println(i);
		
		
		
	
		driver.get("https://login.salesforce.com/");
		ReusableMethod.enterText("//input[@id='username']", "Username@gmail.com", "UserName");
		
		String userName = driver.findElement(By.xpath("//input[@id='username']")).getAttribute("value");
		System.out.println(userName);
		
		
		driver.get("https://www.salesforce.com/");  // Launch Sales force application

		driver.manage().window().maximize();  // Will maximize the window

		
		/*Click Login*/
		ReusableMethod.clickObj("//ul[@id='lang-select']/li/a", "Login");

		/*Enter username*/
		ReusableMethod.enterText("//input[@id='username']", "Username@gmail.com", "UserName");
		
		/*Enter Pwd*/
		ReusableMethod.enterText("//input[@id='password']", "Password@123", "Password");
		
		/*Click Login to SFDC*/
		ReusableMethod.clickObj("//button[@id='Login']", "Login to SFDC");

		
	}
	
	
	
	public static void forgotPasswordB() throws Exception{
		  driver.get("https://login.salesforce.com/");
		  ReusableMethod.enterText("//input[@id='username']", "123", "username");
		  ReusableMethod.enterText("//input[@id='password']", "22131", "password");
		  ReusableMethod.clickObj("//button[@id='Login']", "Login to SFDC");
		  ReusableMethod.validateText(".//*[@id='error']", "Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help.","Errer text");
		  
	}
	public static void runMe(){
		System.out.println("RunMe method is working...");
		resultFlag = 1;
	}
	public static void selectUserMenu() throws IOException{
		driver.get("https://login.salesforce.com/");
		ReusableMethod.enterText("//input[@id='username']", "282221264@qq.com", "username");
		ReusableMethod.enterText("//input[@id='password']", "woshitiancai223", "password");
		ReusableMethod.clickObj("//button[@id='Login']", "Login to SFDC");
		ReusableMethod.clickObj(".//*[@id='userNavLabel']", "user menu");
		
	}
	public static void selectMyProfile() throws IOException{
		selectUserMenu();
		ReusableMethod.clickObj(".//*[@id='userNav-menuItems']/a[1]", "My Profile");
		ReusableMethod.clickObj(".//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img", "edit profile");
		ReusableMethod.clickObj(".//*[@id='aboutTab']/a", "About tab");
		ReusableMethod.enterText(".//*[@id='lastName']", "chan", "LastName");
		ReusableMethod.clickObj(".//*[@id='TabPanel']/div/div[2]/form/div/input[1]", "Save all");
		ReusableMethod.clickObj(".//*[@id='publisherAttachTextPost']/span[1]", "Post");
		ReusableMethod.enterText(".//*[@id='TabPanel']/div/div[2]/form/div/input[1]", "hi", "Text area");
		ReusableMethod.clickObj(".//*[@id='publishersharebutton']", "Share Button");
		//Step6 and 7upload file and upload image, I do not know how to create script
//		ReusableMethod.clickObj(".//*[@id='publisherAttachContentPost']/span[1]", "File");
//		ReusableMethod.clickObj(".//*[@id='chatterUploadFileAction']", "Upload a file from computer");
//		ReusableMethod.clickObj(".//*[@id='chatterFile']", "Choose file");
		
		
		
		
	}
	public static void selectMySetting() throws IOException{
		selectUserMenu();
		ReusableMethod.clickObj(".//*[@id='userNav-menuItems']/a[2]", "My Setting");
		ReusableMethod.clickObj(".//*[@id='PersonalInfo']/a", "Personal");
		ReusableMethod.clickObj(".//*[@id='LoginHistory_font']", "Log History");
		ReusableMethod.clickObj(".//*[@id='RelatedUserLoginHistoryList_body']/div/a", "Download Log History");
		ReusableMethod.clickObj(".//*[@id='DisplayAndLayout']/a", "Display and Layout");
		ReusableMethod.clickObj(".//*[@id='CustomizeTabs_font']", "Customize My Tabs");
		ReusableMethod.clickObj(".//*[@id='p4']", "Custom App");
		ReusableMethod.clickObj(".//*[@id='p4']/option[3]", "Salesforce Chatter");
		ReusableMethod.clickObj(".//*[@id='duel_select_0']/option[26]", "Reports");
		ReusableMethod.clickObj(".//*[@id='duel_select_0_right']/img", "ADD");
		ReusableMethod.clickObj(".//*[@id='bottomButtonRow']/input[1]", "Save");
		ReusableMethod.clickObj(".//*[@id='EmailSetup_font']", "Email");
		ReusableMethod.clickObj(".//*[@id='EmailSettings_font']", "Email Setting");
		ReusableMethod.enterText(".//*[@id='sender_name']", "Neal lslsl", "Email Name");
		ReusableMethod.enterText(".//*[@id='sender_email']", "282221264@qq.com", "Email Address");
		ReusableMethod.selectCheckBox(".//*[@id='auto_bcc1']", "Automatic BBC");
		ReusableMethod.clickObj(".//*[@id='bottomButtonRow']/input[1]", "Save");
		ReusableMethod.clickObj(".//*[@id='CalendarAndReminders_font']", "Calendar and Reminder");
		ReusableMethod.clickObj(".//*[@id='Reminders_font']", "Reminder Alerts");
		ReusableMethod.clickObj(".//*[@id='testbtn']", "Preview Reminder Alert");
		
		
	}
	public static void selectDevelopersConsole() throws IOException{
		selectUserMenu();
		ReusableMethod.clickObj(".//*[@id='userNav-menuItems']/a[3]", "Developer Console");
		//I do not know how to get xpath of close button

	}
	public static void selectLogout() throws IOException{
		selectUserMenu();
		ReusableMethod.clickObj(".//*[@id='userNav-menuItems']/a[4]", "Log out");
	}
	public static void printText() throws IOException{
		driver.get("https://login.salesforce.com/");
		ReusableMethod.enterText("//input[@id='username']", "282221264@qq.com", "username");
		ReusableMethod.enterText("//input[@id='password']", "woshitiancai223", "password");
		ReusableMethod.clickObj("//button[@id='Login']", "Login to SFDC");
		String display;
		display = driver.findElement(By.xpath(".//*[@id='layout']/div[1]/div/div/h2")).getText();
		System.out.println(display);
	}
}
