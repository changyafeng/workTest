package testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg {
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class method is executing...");
	}
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before Method is executing...");
	}
	@Test
	public void runMe(){
		System.out.println("Run me is executing...");
	}
	@Test
	public void stopMe(){
		System.out.println("Stop me is executing....");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method is executing...");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("After Class is executing...");
	}

}
