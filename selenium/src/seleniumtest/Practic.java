package seleniumtest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practic {
	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new FirefoxDriver();
		
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("282221264@qq.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("woshitiancai223");
		driver.findElement(By.xpath("//button[@id='Login']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='owner-choice']/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-callout-close']/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("itarget");
		String display;
		display = driver.findElement(By.xpath("//*[@id='layout']/div[1]/div/div/h2")).getText();
		System.out.println(display);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='Account_Tab']/a")).click();
		Thread.sleep(3000);
		takeScreenShot();
		driver.close();
	}
	public static void takeScreenShot() throws IOException{ 
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File("/Users/yafeng/Desktop/ReportLog/pic.jpg")); 
	} 

}
