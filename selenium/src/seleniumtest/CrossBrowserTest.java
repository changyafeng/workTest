package seleniumtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CrossBrowserTest {
	static WebDriver driver;
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	// TODO Auto-generated method stub
		String dataTablePath="/Users/yafeng/Desktop/testCross.xls";
		String[][] recData =readXlSheet(dataTablePath, "工作表1");
			if(loginFirefox()){
				
				writeXlSheet(dataTablePath, "工作表1", 1, 3, recData[1][3]);
			}
			else{
				writeXlSheet(dataTablePath, "工作表1", 1, 3, recData[1][3]);
			}
			if(loginChrome()){
				writeXlSheet(dataTablePath, "工作表1", 1, 4, recData[1][4]);
			}
			else{
				writeXlSheet(dataTablePath, "工作表1", 1, 4, recData[1][4]);
			}
		
		
	}
	public static boolean loginFirefox() throws IOException, InterruptedException{
//		try{
			driver=new FirefoxDriver();
			driver.get("https://login.salesforce.com/");
			Thread.sleep(5000);
			ReusableMethod.enterText("//*[@id='username']", "282221264@qq.com", "UserName");
			
			/*Enter Pwd*/
			ReusableMethod.enterText("//*[@id='password']']", "woshitiancai223", "Password");
			
			/*Click Login to SFDC*/
			ReusableMethod.clickObj("//button[@id='Login']", "Login to SFDC");
			
			driver.close();
			return true;
			
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//			return false;
//		}
	}
	public static boolean loginChrome() throws IOException{
		try{
			ChromeDriverService ds=new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("/Users/yafeng/Documents/javalearn/chromedriver"))
					.withSilent(true)
					.build();
			ds.start();
			driver= new RemoteWebDriver(ds.getUrl(),DesiredCapabilities.chrome());
			System.out.println(ds.getUrl());
//			System.setProperty("webdriver.chrome.driver", "/Users/yafeng/Documents/javalearn/chromedriver"); 
//			driver = new ChromeDriver(); 
			driver.get("https://login.salesforce.com/");
			Thread.sleep(5000);
//			ReusableMethod.enterText("//input[@id='username']", "282221264@qq.com", "UserName");
//			
//			/*Enter Pwd*/
//			ReusableMethod.enterText("//input[@id='password']", "woshitiancai223", "Password");
//			
//			/*Click Login to SFDC*/
//			ReusableMethod.clickObj("//button[@id='Login']", "Login to SFDC");
			driver.close();
			return true;
		}catch(Exception e){
			
			return false;
		}
	}
	public static void writeXlSheet(String dataTablePath,String SheetName,int iRow, int iCol, String report ) throws IOException{

		/*Step 1: Get the XL Path*/
		File xlFile = new File(dataTablePath);

		/*step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);


		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(SheetName);

		/*Access Row*/
		HSSFRow row = sheet.getRow(iRow);

		/*Access the column*/
		HSSFCell  cell = row.getCell(iCol);
		if(cell==null){
			cell = sheet.getRow(iRow).createCell(iCol);
		}
		/* Set string Type */
		cell.setCellValue(HSSFCell.CELL_TYPE_STRING);

		cell.setCellValue(report);
		/* Set Color */
		
		if(report.equalsIgnoreCase("Y")){
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}else if(report.equalsIgnoreCase("N")){
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}else{
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.YELLOW().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}

		FileOutputStream fout = new FileOutputStream(dataTablePath);
		wb.write(fout);
		fout.flush();
		fout.close();
	}
public static String[][] readXlSheet(String dataTablePath, String SheetName) throws IOException{
		

		/*Step 1: Get the XL Path*/
		File xlFile = new File(dataTablePath);

		/*step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);


		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(SheetName);

		int iRowCount = sheet.getLastRowNum()+1;
		int iColCount = sheet.getRow(0).getLastCellNum();


		String[][] xlData = new String[iRowCount][iColCount];

		for(int i =0; i < iRowCount; i ++){
			for(int j = 0; j < iColCount; j++){
				/*Step5: Access Cell*/
				HSSFCell cell  = sheet.getRow(i).getCell(j);
				if(cell==null){
					cell = sheet.getRow(i).createCell(j);
				}
				xlData[i][j] = cell.getStringCellValue();
				
				
			}
		}

		return xlData; 
	}
}
