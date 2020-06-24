package com.parameter.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParametersTest {
	
	WebDriver driver;
	@BeforeMethod
	public void startUp()
	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	//This will get the test data from testng.xml file where parameters are defined
	@Test
	@Parameters({"url","username","password"})
	public void parameterAnnoTest(String url ,String username, String password) throws Exception {	
		//hit url
		driver.get(url);
		//Enter email & password
				driver.findElement(By.id("user-name")).sendKeys(username);
				driver.findElement(By.id("password")).sendKeys(password);
				Thread.sleep(2000);

				//Click on Login button
				driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
				Thread.sleep(2000);
			
	}
	@AfterMethod
	public void tearDown()
	{		
		//Close the browser			
		driver.close();
	}

}
