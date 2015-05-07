import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Facebook {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver= new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		List<WebElement> allTextArea=driver.findElements(By.tagName("input"));
		for(int i=0;i<allTextArea.size();i++){
//			if(allTextArea.get(i).getAttribute("name").equals("firstname")){
//				allTextArea.get(i).sendKeys("skdke");
//			}
//			else if(allTextArea.get(i).getAttribute("name").equals("lastname")){
//				allTextArea.get(i).sendKeys("dkekek");
//			}
//			else if(allTextArea.get(i).getAttribute("name").equals("reg_email__")){
//				allTextArea.get(i).sendKeys("dkdk@dkdk.com");
//			}
//			else if(allTextArea.get(i).getAttribute("name").equals("reg_email_confirmation__")){
//				allTextArea.get(i).sendKeys("dkdk@dkdk.com");
//			}
//			else if(allTextArea.get(i).getAttribute("name").equals("reg_passwd__")){
//				allTextArea.get(i).sendKeys("dkdk@dkdk.com");
//			}
			if(allTextArea.get(i).getAttribute("aria-label")!=null){
				
				switch(allTextArea.get(i).getAttribute("aria-label")){
				case "First name":
					allTextArea.get(i).sendKeys("skdke");
					break;
				case "Last name":
					allTextArea.get(i).sendKeys("dkekek");
					break;
				case "Email or mobile number":
					allTextArea.get(i).sendKeys("dkdk@dkdk.com");
					break;
				case "Re-enter email or mobile number":
					allTextArea.get(i).sendKeys("dkdk@dkdk.com");
					break;
				case "New password":
					allTextArea.get(i).sendKeys("dkdk@dkdk.com");
					break;
				default:
					break;
					
				}
			}
		}
		
		

	}

}
