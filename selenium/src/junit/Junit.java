package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Junit {
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before Class method is executing...");
	}
	@Before
	public void beforeMethod(){
		System.out.println("Before Method is executing...");
	}
	@Test
	public void runMe(){
		System.out.println("RunMe is executing...");
	}
	@Test
	public void stopMe(){
		System.out.println("StopMe is executing...");
	}
	@After
	public void afterMethod(){
		System.out.println("After Method is executing...");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("After Class is executing...");
	}
}
