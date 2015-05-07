package seleniumActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetAllLink {
	static WebDriver driver;
	public static void main(String [] args) throws InterruptedException{
		driver= new FirefoxDriver();
		driver.get("http://www.bbc.com");
		Thread.sleep(5000);
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for(int i=0; i<allLinks.size();i++){
			if(allLinks.get(i).getText().equals("US admits hostages killed in raid")){
				allLinks.get(i).click();
				System.out.println("The object is "+i);
			}
		}
//		String linkName = allLinks.get(30).getText();
//		System.out.println(linkName);
	}
}
