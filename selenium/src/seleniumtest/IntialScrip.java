package seleniumtest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class IntialScrip {
static WebDriver driver;
	static int resultFlag=2;
	public static void main(String[] args) throws Exception {
		  // Launch FF browser
		
		String dataTablePath="/Users/yafeng/Desktop/ConfigFile.xls";
		String[][] recData = ReusableMethod.readXlSheet(dataTablePath, "工作表1");
		
		
		for(int i=1; i<recData.length; i++ ){
			String controller=recData[i][1];
			if(controller.equalsIgnoreCase("Y")){
				
				String scriptName = recData[i][2];
				ReusableMethod.startReport(scriptName, "/Users/yafeng/Desktop/report");
				resultFlag=0;
				driver = new FirefoxDriver();
				Method ts = AutomationScript.class.getMethod(scriptName);
				ts.invoke(ts);
				ReusableMethod.bw.close();
				String hyperLink=ReusableMethod.htmlname;
				ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i,4, "file:///"+hyperLink);
				driver.close();
			}
			
			if(resultFlag == 1){
				ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 3, "Fail");
			}else if(resultFlag==0){
				ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 3, "Pass");
			}else{
				ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 3, "No Run");
			}
			
		}
		try {
			Runtime.getRuntime().exec("open /Users/yafeng/Desktop/ConfigFile.xls");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	
		
		
		
		
	}
  
  

  
}
