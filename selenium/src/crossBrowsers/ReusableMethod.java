package crossBrowsers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethod extends IntialScrip {
	static BufferedWriter bw = null; 
	static BufferedWriter bw1 = null; 
	static String htmlname; 
	static String objType; 
	static String objName; 
	static String TestData; 
	static String rootPath; 
	static int report; 
	 
	 
	static Date cur_dt = null; 
	static String filenamer; 
	static String TestReport; 
	int rowcnt; 
	static String exeStatus = "True"; 
	static int iflag = 0; 
	static int j = 1; 
	 
	static String fireFoxBrowser; 
	static String chromeBrowser; 
	 
	static String result; 
	 
	static int intRowCount = 0; 
	static String dataTableRePath; 
	static int i; 
	static String browserName;
	
	public static By getBy(String locatorType, String locatorValue) {
		By by = null;
		switch (locatorType) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "css":
			by = By.cssSelector(locatorValue);
			break;
		case "xpath":
			by=By.xpath(locatorValue);
			break;
		case "class":
			by = By.className(locatorValue);
			break;
		default:
			break;
		}
		//
		return by;
	}
	
	/* Name of the Method: enterText
	 * Method Description: Enter text to textbox
	 * Arguments: objXpath --> Xpath of an object, textValue --> Value needs to be entered, objName --> Name of the object
	 * Created By:  Script- Kings
	 * Creation Date: Apr 14 2015
	 * Last Modified: Apr 14 2015 
	 * */
	public static void enterText(String type, String locValue, String textValue, String objName) throws IOException{
		WebElement ele = driver.findElement(getBy(type, locValue));
		if(ele.isDisplayed()){
			ele.clear();
			ele.sendKeys(textValue);
			Update_Report("Pass", "enterText",  textValue + " is entered in " + objName + " Field");
			System.out.println("Pass: " + textValue + " is entered in " + objName + " Field");
		}else{
			resultFlag = 1;
			
			Update_Report("Fail", "enterText", objName + " field does not exist, please check the application ");
			System.out.println("Fail: " + objName + " field does not exist, please check the application ");
		}	
	}

	/* Name of the Method: clickObj
	 * Method Description: Click object
	 * Arguments: objXpath --> Xpath of an object, objName --> Name of the object
	 * Created By: Script- Kings
	 * Creation Date: Apr 14 2015
	 * Last Modified: Apr 14 2015 
	 * */
	public static void clickObj(String type, String locValue,String objName) throws IOException{
//		WebElement ele = driver.findElement(getBy(type, locValue));
		WebElement ele = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(getBy(type, locValue)));
		if(ele.isDisplayed()){
			ele.click();
			Update_Report("Pass", "clickObj", objName+ " is clicked");
			System.out.println("Pass: " + objName+ " is clicked");
		}else{
			resultFlag = 1;
			Update_Report("Fail", "clickObj", objName + " field does not exist, please check the application ");
			System.out.println("Fail: " + objName + " field does not exist, please check the application ");
		}
	}
	/* Name of the Method: mouseHoverObj
	 * Method Description: Hover the curser to the web element 
	 * Arguments: locatorType --> Locator type of an object, locatorValue --> Locator value of an object, objName --> Name of the object
	 * Created By:  Script- Kings
	 * Creation Date: Apr 28 2015
	 * Last Modified: Apr 28 2015 
	 * */
	
		public static void mouseHoverObj(String locatorType, String locatorValue, String objName) throws IOException{
			
			
			if(driver.findElement(getBy(locatorType,locatorValue)).isDisplayed()){
				//WebElement elems = driver.findElement(getBy(locatorType,locatorValue));
				Actions builder = new Actions(driver);
				Actions hoverOverRegistrar = builder.moveToElement(driver.findElement(getBy(locatorType,locatorValue)));
				hoverOverRegistrar.perform();
				Update_Report("Pass", "mouseHoverObj", objName+ " is hovered");
				System.out.println("Pass: " + objName+ " is hovered");
			}else{
				resultFlag = 1;
				Update_Report("Fail", "mouseHoverObj", objName + " field does not exist, please check the application ");
				System.out.println("Fail: " + objName + " field does not exist, please check the application ");
			}
			
		}
	/* Name of the Method: selectCheckBox
	 * Method Description: Select check box if it is not selected
	 * Arguments: objXpath --> Xpath of an object, objName --> Name of the object
	 * Created By:  Script- Kings
	 * Creation Date: Apr 15 2015
	 * Last Modified: Apr 15 2015 
	 * */
	public static void selectCheckBox(String type, String locValue,String objName) throws IOException{
		WebElement ele = driver.findElement(getBy(type, locValue));
		if(ele.isDisplayed()){
			if(ele.isSelected()){
				Update_Report("Pass", "selectCheckBox", objName+ " is already selected");
				System.out.println("Check box '" + objName + "' is already selected");
			}else{
				ele.click();
				Update_Report("Pass", "selectCheckBox", objName+ " is selected");
				System.out.println("Pass: Check box " + objName+ " is selected");
			}
			
		}else{
			resultFlag = 1;
			Update_Report("Fail", "selectCheckBox", objName+ " field does not exist, please check the application");
			System.out.println("Fail: " + objName + " field does not exist, please check the application ");
		}
		
		
		
	}
	
	/* Name of the Method: deSelectCheckBox
	 * Method Description: DeSelect check box if it is not selected
	 * Arguments: objXpath --> Xpath of an object, objName --> Name of the object
	 * Created By:  Script- Kings
	 * Creation Date: Apr 15 2015
	 * Last Modified: Apr 15 2015 
	 * */
	public static void deSelectCheckBox(String type, String locValue,String objName) throws IOException{
		WebElement ele = driver.findElement(getBy(type, locValue));
		if(ele.isDisplayed()){
			if(ele.isSelected()){
				ele.click();
				Update_Report("Pass", "deselectCheckBox", objName+ " is already deselected");
				System.out.println("Pass: Check box " + objName+ " is already deselected");
				
			}else{
				Update_Report("Pass", "deselectCheckBox", objName+ " is deselected");
				System.out.println("Check box '" + objName + "' is deselected");
			}
			
		}else{
			resultFlag = 1;
			Update_Report("Fail", "deselectCheckBox", objName+ " field does not exist, please check the application");
			System.out.println("Fail: " + objName + " field does not exist, please check the application ");
		}
		
	}
	public static void selectDropdown(String type, String locValue,String label) throws IOException{
		WebElement ele = driver.findElement(getBy(type, locValue));
		
		if(ele.isDisplayed()){
			
			Select droplist=new Select(ele);
			droplist.selectByVisibleText(label);	
				Update_Report("Pass", "selectDropdown", label+ " is already deselected");
			System.out.println("Pass: Drop Down " + label+ " is selected");
				
			
			
		}else{
			resultFlag = 1;
			Update_Report("Fail", "selectDropdown", label+ " field does not exist, please check the application");
			System.out.println("Fail: " + label + " field does not exist, please check the application ");
		}
		
	
	}
	
	public static void validateText(String type, String locValue, String expectedText, String objName) throws IOException{
		String actualText;
		WebElement ele = driver.findElement(getBy(type, locValue));
		if(ele.isDisplayed()){
			actualText = ele.getText();
			if(expectedText.equals(actualText)){
				System.out.println("Pass: Actual text matches with expected text" + expectedText);
			}else{
				resultFlag = 1;
				Update_Report("Fail", "validateText", objName+ " field does not exist, please check the application");
				System.out.println("Fail: Actual text " + actualText+ " did not match with exected text " + expectedText );
			}
		}else{
			resultFlag = 1;
			Update_Report("Fail", "validateText", objName+ " field does not exist, please check the application");
			System.out.println("Fail: " + objName + " field does not exist, please check the application ");
		}
		
	}
	
	
	public static void startReport(String scriptName, String ReportsPath) throws IOException{
		
		String strResultPath = null;
		
		
		String testScriptName =scriptName;
		
		
		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 
			
			ReportsPath = "/Users/yafeng/Desktop";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName + "/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";
		
		

		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#A4A4A4 WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#A4A4A4 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#A4A4A4 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#A4A4A4 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#A4A4A4 WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detailed Report</B></FONT></TD></TR>");


	}
	
	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			/*Code to take screen shot*/
			
			String imagePath = "/Users/yafeng/Desktop/ReportLog/"+Action+"_"+str_time+".jpg";
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File(imagePath));
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ imagePath
					+ "  style=\"color: #FF0000\"> Failed </a>"

					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ result + "</FONT></TD></TR>");

		} 
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
//	cell.setCellValue(HSSFCell.CELL_TYPE_STRING);
//	cell.setCellValue(report);
	/* Set Color */
	String temp=cell.getStringCellValue();
	if(temp.equalsIgnoreCase("Y")){
		HSSFCellStyle titleStyle = wb.createCellStyle();
		titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(titleStyle);
		//add code here for hyperlink
		HSSFHyperlink url_link=new HSSFHyperlink(HSSFHyperlink.LINK_URL);
		url_link.setAddress("file://"+htmlname);
		cell.setHyperlink(url_link);

	}else if(temp.equalsIgnoreCase("N")){
		HSSFCellStyle titleStyle = wb.createCellStyle();
		titleStyle.setFillForegroundColor(new HSSFColor.BLUE().getIndex());
		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(titleStyle);
		//add code here for hyperlink
//		HSSFHyperlink url_link=new HSSFHyperlink(HSSFHyperlink.LINK_URL);
//		url_link.setAddress("file://"+htmlname);
//		cell.setHyperlink(url_link);

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
	public static void takeScreenShot(String methodName) throws IOException{ 
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, new File("/Users/yafeng/Desktop/ReportLog/"+methodName+".jpg")); 
	} 
}
