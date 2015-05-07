package stateFarm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;

import com.thoughtworks.selenium.Selenium;







public class AutomationScript extends IntialScrip {
	
	public static void getQuoteData() throws InterruptedException, IOException{
		driver.get("https://www.statefarm.com/");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='insurance-menuitem']/span", "Insurance");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "select[name='productName']", "Homeowners");
		Thread.sleep(3000);
		ReusableMethod.enterText("xpath","//div[2]/form/div/input", "94539", "Zipcode");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div/input[2]", "Go");
		Thread.sleep(20000);
		ReusableMethod.enterText("xpath",".//*[@id='firstName-sfxid_3']", "obama", "FirstName");
		ReusableMethod.enterText("xpath",".//*[@id='middleName-sfxid_4']", "b", "MiddleName");
		ReusableMethod.enterText("xpath",".//*[@id='lastName-sfxid_5']", "washington", "LastName");
		ReusableMethod.selectDropdown("css", "#suffix-sfxid_6", "Sr");
		Thread.sleep(3000);
		ReusableMethod.enterText("css","#street1-sfxid_7", "washington ave", "Stree Address");
		ReusableMethod.enterText("css","#street2-sfxid_8", "1234", "Apt/Suit Number");
		ReusableMethod.enterText("xpath",".//*[@id='primaryApplicantDOBId']/div[1]/input", "11", "Month");
		ReusableMethod.enterText("xpath",".//*[@id='primaryApplicantDOBId']/div[3]/input", "12", "Date");
		ReusableMethod.enterText("xpath",".//*[@id='primaryApplicantDOBId']/div[5]/input", "1985", "Year");
		ReusableMethod.clickObj("css","#buttonContinueId > span", "Continue");
		

	}
	public static void healthQuote() throws InterruptedException, IOException{
		driver.get("https://www.statefarm.com/");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='insurance-menuitem']/span", "Insurance");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "select[name='productName']", "Health");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "#sState", "California");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div/input[2]", "Go");
		Thread.sleep(3000);
		ReusableMethod.selectCheckBox("xpath", ".//*[@id='coppaIndicatorIdCB']", "Check box");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='sfxid_12']/span", "OK");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='existingCustomer1']", "No");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='availProductList1']", "Medicare Supplement");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='medProductList0']", "Plan A");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='buttonContinueId']/span", "Continue");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "#countyId-sfxid_3", "Lake");
		Thread.sleep(3000);
		ReusableMethod.enterText("xpath",".//*[@id='dobId']/div[1]/input", "11", "Month");
		ReusableMethod.enterText("xpath",".//*[@id='dobId']/div[3]/input", "11", "Date");
		ReusableMethod.enterText("xpath",".//*[@id='dobId']/div[5]/input", "1985", "Year");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='buttonContinueId']/span", "Continue");
		Thread.sleep(3000);
	}
	public static void repairFacility() throws InterruptedException, IOException{
		driver.get("https://www.statefarm.com/");
		Thread.sleep(3000);
		ReusableMethod.mouseHoverObj("xpath", ".//*[@id='insurance-menuitem']/span", "Insurance");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='insurance']/div[1]/ul/li[1]/a", "Auto");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='left-channel-links']/ul/li[2]/ul/li[3]/a", "Find a Select Service Repair Facility");
		Thread.sleep(3000);
		ReusableMethod.enterText("xpath",".//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div/input[1]", "95436", "Zipcode");
		Thread.sleep(3000);
		ReusableMethod.clickObj("xpath",".//*[@id='content']/div[1]/div[2]/div/div[1]/div[2]/form/div/input[2]", "Go");
		Thread.sleep(3000);
		ReusableMethod.selectDropdown("css", "#SearchBean_languageId-sfxid_12", "Polish");
		Thread.sleep(3000);
		ReusableMethod.clickObj("css","#find>span", "Find");
		Thread.sleep(3000);
	}
	public static void claimsResourcesFindAgent() throws Exception{
		driver.get("https://www.statefarm.com/");
		driver.manage().window().maximize(); //maximize the window
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ReusableMethod.clickObj("xpath", "//*[@id='claims-menuitem']", "claims");
		Thread.sleep(5000);
		ReusableMethod.clickObj("xpath", "//*[@id='claims']/div[1]/ul/li[7]/a", "resources");
		Thread.sleep(5000);
		ReusableMethod.enterText("xpath", "//*[@id='content']/div[3]/div[1]/div/div/div[2]/form/div/input[1]", "94538", "zipcode");
		ReusableMethod.clickObj("xpath", "//*[@id='content']/div[3]/div[1]/div/div/div[2]/form/div/input[2]", "submit");
		Thread.sleep(5000);
		ReusableMethod.clickObj("xpath", "//*[@id='addressTab']", "By Address");
		Thread.sleep(5000);
		ReusableMethod.enterText("xpath", "//*[@id='SearchBean_addressId-sfxid_3']", "Test street", "SearchBean.address");
		ReusableMethod.enterText("xpath", "//*[@id='SearchBean_addressZipCodeId-sfxid_4']", "94538", "SearchBean.addressZipCode");
		ReusableMethod.selectDropdown("xpath", "//*[@id='SearchBean.addressRadius-sfxid_5']", "10 Miles");
		ReusableMethod.clickObj("xpath", "//*[@id='find']", "Find");
		Thread.sleep(5000);
		ReusableMethod.clickObj("xpath", "//*[@id='cityTab']", "By City");
		Thread.sleep(5000);
		ReusableMethod.enterText("xpath", "//*[@id='SearchBean_cityId-sfxid_6']", "Fremont", "SearchBean.city");
		ReusableMethod.selectDropdown("xpath", "//*[@id='SearchBean_cityStateId-sfxid_7']", "California");
		ReusableMethod.clickObj("xpath", "//*[@id='find']", "Find");
		Thread.sleep(5000);
		ReusableMethod.clickObj("xpath", "//*[@id='nameTab']", "By Name");
		Thread.sleep(5000);
		ReusableMethod.enterText("xpath", "//*[@id='SearchBean_nameId-sfxid_8']","Stephens" , "SearchBean.name");
		ReusableMethod.selectDropdown("xpath", "//*[@id='SearchBean_nameStateId-sfxid_9']", "California");
		ReusableMethod.clickObj("xpath", ".//*[@id='find']", "Find");
	}
}
