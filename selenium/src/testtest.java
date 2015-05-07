import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumtest.ReusableMethod;


public class testtest {
static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		driver=new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		ReusableMethod.enterText("//*[@id='username']", "282221264@qq.com", "UserName");
		
		/*Enter Pwd*/
		ReusableMethod.enterText("//*[@id='password']']", "woshitiancai223", "Password");
		
		/*Click Login to SFDC*/
		ReusableMethod.clickObj("//button[@id='Login']", "Login to SFDC");
		
		driver.close();
	}

}
