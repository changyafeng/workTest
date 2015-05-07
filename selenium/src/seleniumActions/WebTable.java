package seleniumActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTable {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver=new FirefoxDriver();
		driver.get("http://www.espncricinfo.com/west-indies-v-england-2015/engine/match/766931.html");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='st_1']")).click();
		List<WebElement> totalRows= driver.findElement(By.xpath(".//*[@id='full-scorecard']/div[2]/div/table[1]/tbody")).findElements(By.tagName("tr"));
		System.out.println("Total Number of Rows: "+totalRows.size());
		for(int i=0;i<totalRows.size();i++){
			List<WebElement> totalCol = totalRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<totalCol.size();j++){
				try{
					String name= totalCol.get(j).getText();
					System.out.print(name+" ");
					
				}catch(Exception e){
					
				}
				
			}
			System.out.println();
		}
		driver.close();
	}

}
