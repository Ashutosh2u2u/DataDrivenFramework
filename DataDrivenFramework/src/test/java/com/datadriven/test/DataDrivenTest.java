package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {
	WebDriver driver;
	String Uname;
	String pwd;
@BeforeClass
	public void setUp()  throws InterruptedException
	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");	
		Xls_Reader reader=new Xls_Reader("./testData/TestData.xlsx");
		Uname=reader.getCellData("Register", 0, 2);
		pwd=reader.getCellData("Register", 1, 2);
		System.out.println(Uname +" **** "+ pwd);
	}
@Test(priority=1)
public void registration() throws Exception {
		
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		Thread.sleep(2000);

		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='register']")).click();
		Thread.sleep(2000);
}
@Test(priority=2)
public void signIn() throws Exception {
	
		driver.findElement(By.xpath("//a[contains(text(),'sign-in')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(2000);
		Actions act=new Actions(driver) ;	
		WebElement Cruises=driver.findElement(By.xpath("//a[contains(text(),'Cruises')]"));
		act.doubleClick(Cruises);		
		Thread.sleep(2000);
				//{

		 }
@AfterClass
public void tearDown() {
	
		driver.close();
	}
}



