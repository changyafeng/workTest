package stateFarm;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class IntialScrip {
static WebDriver driver;
	static int resultFlag=2;
	public static void main(String[] args) throws Exception {
		  // Launch FF browser
		
		String dataTablePath="/Users/yafeng/Desktop/testCross2.xls";
		String[][] recData = ReusableMethod.readXlSheet(dataTablePath, "工作表1");
		
		
		for(int i=1; i<recData.length; i++ ){
			String controller=recData[i][1];
			if(controller.equalsIgnoreCase("Y")){
				
				String scriptName = recData[i][2];
				ReusableMethod.startReport(scriptName, "/Users/yafeng/Desktop/report");
				if(recData[i][3].equalsIgnoreCase("Y")){
					resultFlag=0;
					driver = new FirefoxDriver();
					Method ts = AutomationScript.class.getMethod(scriptName);
					ts.invoke(ts);
					driver.close();
					if(resultFlag == 1){
						ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 3,"Y");
					}else if(resultFlag==0){
						ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 3, "Y");
					}else{
						ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 3, "Y");
					}
					
				}
				else{
					ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 3, "N");
				}
				if(recData[i][4].equalsIgnoreCase("Y")){
					resultFlag=0;
					ChromeDriverService ds=new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("/Users/yafeng/Documents/javalearn/chromedriver"))
					.withSilent(true)
					.build();
					ds.start();
					driver= new RemoteWebDriver(ds.getUrl(),DesiredCapabilities.chrome());
					Method ts = AutomationScript.class.getMethod(scriptName);
					ts.invoke(ts);
					driver.close();
					ds.stop();
					if(resultFlag == 1){
						ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 4, "Y");
					}else if(resultFlag==0){
						ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 4, "Y");
					}else{
						ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 4, "Y");
					}
					
				}
				else{
					ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 4, "N");
				}
				if(recData[i][5].equalsIgnoreCase("Y")){
					resultFlag=0;
					driver = new SafariDriver();
					Method ts = AutomationScript.class.getMethod(scriptName);
					ts.invoke(ts);
					driver.close();
					if(resultFlag == 1){
						ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 5, "Y");
					}else if(resultFlag==0){
						ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 5, "Y");
					}else{
						ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 5, "Y");
					}
					
				}
				else{
					ReusableMethod.writeXlSheet(dataTablePath, "工作表1", i, 5, "N");
				}
				ReusableMethod.bw.close();
//				
			}
			
			
		}
		try {
			Runtime.getRuntime().exec("open /Users/yafeng/Desktop/testCross2.xls");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
//		  // Recipient's email ID needs to be mentioned.
//	      String to = "282221264@qq.com";
//
//	      // Sender's email ID needs to be mentioned
//	      String from = "chang123yfde@gmail.com";
//
//	      final String username = "manishaspatil";//change accordingly
//	      final String password = "******";//change accordingly
//
//	      // Assuming you are sending email through relay.jangosmtp.net
//	      String host = "relay.jangosmtp.net";
//
//	      Properties props = new Properties();
//	      props.put("mail.smtp.auth", "true");
//	      props.put("mail.smtp.starttls.enable", "true");
//	      props.put("mail.smtp.host", host);
//	      props.put("mail.smtp.port", "25");
//
//	      // Get the Session object.
//	      Session session = Session.getInstance(props,
//	         new javax.mail.Authenticator() {
//	            protected PasswordAuthentication getPasswordAuthentication() {
//	               return new PasswordAuthentication(username, password);
//	            }
//	         });
//
//	      try {
//	         // Create a default MimeMessage object.
//	         Message message = new MimeMessage(session);
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         message.setRecipients(Message.RecipientType.TO,
//	            InternetAddress.parse(to));
//
//	         // Set Subject: header field
//	         message.setSubject("Testing Subject");
//
//	         // Create the message part
//	         BodyPart messageBodyPart = new MimeBodyPart();
//
//	         // Now set the actual message
//	         messageBodyPart.setText("This is message body");
//
//	         // Create a multipar message
//	         Multipart multipart = new MimeMultipart();
//
//	         // Set text message part
//	         multipart.addBodyPart(messageBodyPart);
//
//	         // Part two is attachment
//	         messageBodyPart = new MimeBodyPart();
//	         String filename = "/home/manisha/file.txt";
//	         DataSource source = new FileDataSource(filename);
//	         messageBodyPart.setDataHandler(new DataHandler(source));
//	         messageBodyPart.setFileName(filename);
//	         multipart.addBodyPart(messageBodyPart);
//
//	         // Send the complete message parts
//	         message.setContent(multipart);
//
//	         // Send message
//	         Transport.send(message);
//
//	         System.out.println("Sent message successfully....");
//	  
//	      } catch (MessagingException e) {
//	         throw new RuntimeException(e);
//	      }
//		
		
	
		
		
		
		
	}
  
  

  
}
