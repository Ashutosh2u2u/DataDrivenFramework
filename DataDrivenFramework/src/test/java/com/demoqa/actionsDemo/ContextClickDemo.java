package com.demoqa.actionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class ContextClickDemo {
public static void main(String[] args) throws Exception {
	//Open Chrome browser
			System.setProperty("webdriver.chrome.silentOutput", "true");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/tooltip-and-double-click/");
			System.out.println("site open for context click demo");
			Actions act= new Actions(driver);			
			
			WebElement target=driver.findElement(By.id("rightClickBtn"));
			//to right click
			act.contextClick(target).perform();
			Thread.sleep(1000);
			//Copy Me element is not clickable so 1st scroll down and using action class click on copy me eleent
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			act.moveToElement(driver.findElement(By.xpath("//div[text()='Copy Me']"))).click().build().perform();
			System.out.println("click on copy");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
			Thread.sleep(2000);	
			
			
			driver.quit();
}
}
