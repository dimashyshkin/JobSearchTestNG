package com.TestNG.JobSearch;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")
public class MonsterSearchTwo extends Browser {
	
	//DATA
	String user;
	private String login;
	private String password;
	private String zipcode;
	private String keyword4;
	private String keyword5;
	private String keyword6;
	private String expectedTitle;

	@Test
	public void testMonsterSearchTwo() throws Exception {
		//User
		user = Data.user;
		if (user.equals("dima")) {
			login = Data.dima_login;
			password = Data.dima_password;
			keyword4 = Data.dima_monster_keyword4;
			keyword5 = Data.dima_monster_keyword5;
			keyword6 = Data.dima_monster_keyword6;
			zipcode = Data.dima_zipcode;
			expectedTitle = Data.dima_monster_expectedTitle;
		}
		
		if (user.equals("olya")) {
			login = Data.olya_login;
			password = Data.olya_password;
			keyword4 = Data.olya_monster_keyword4;
			keyword5 = Data.olya_monster_keyword5;
			keyword6 = Data.olya_monster_keyword6;
			zipcode = Data.olya_zipcode;
			expectedTitle = Data.olya_monster_expectedTitle;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println(ourBrowser +": Open and login");
		driver.get("http://www.monster.com/");
		driver.findElement(By.xpath("//a[@title='Sign In']")).click();
		driver.findElement(By.xpath("//input[@id='EmailAddress']")).clear();
		driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys(login);
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//form/div/input[@value='Sign In']")).click();

		System.out.println(ourBrowser +": Submit search");
		if (isElementPresent(By.xpath("//a[contains(text(),'Skip this Offer')]"))) {
			driver.findElement(By.xpath("//a[contains(text(),'Skip this Offer')]")).click();
		}
		

		driver.findElement(By.xpath("//div[@class='searchBoxFieldsBgd']//a[@title='Advanced Search']")).click();
		driver.findElement(By.xpath("//a[@title='Add another job title']")).click();
		driver.findElement(By.xpath("//input[@name='txJobTitle_0']")).clear();  
		driver.findElement(By.xpath("//input[@name='txJobTitle_0']")).sendKeys(keyword4);
		driver.findElement(By.xpath("//input[@name='txJobTitle_1']")).clear();
		driver.findElement(By.xpath("//input[@name='txJobTitle_1']")).sendKeys(keyword5);
		driver.findElement(By.xpath("//a[@title='Add another job title']")).click();
		driver.findElement(By.xpath("//input[@name='txJobTitle_2']")).clear();
		driver.findElement(By.xpath("//input[@name='txJobTitle_2']")).sendKeys(keyword6);
		driver.findElement(By.xpath("//input[@id='txLocation']")).clear();
		driver.findElement(By.xpath("//input[@id='txLocation']")).sendKeys(zipcode);
		
		new Select(driver.findElement(By.xpath("//select[@title='Posting Date']"))).selectByValue("3");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		String title = driver.getTitle();
		if (expectedTitle.equals(title)) {
	    	System.out.println("Done");
	    }
	}

	private boolean isElementPresent(By by) {
	// Changed implicitlyWait for this statement, because I dont need to wait for 60 seconds here. 
	// If I use it for 'Wait for element NOT present', it will take just 1 second to throw exception, not 60
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} 	catch (NoSuchElementException e) {
			return false;
			}
	}
	
}
