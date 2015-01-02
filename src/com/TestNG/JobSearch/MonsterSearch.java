package com.TestNG.JobSearch;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")
public class MonsterSearch extends Browser {
	
	//DATA
	String user;
	private String login;
	private String password;
	private String zipcode;
	private String keyword1;
	private String keyword2;
	private String keyword3;
	private String expectedTitle;

	@Parameters("user")
	@Test
	public void testMonsterSearch(String user) throws Exception {
		if (user.equals("dima")) {
			login = Data.dima_login;
			password = Data.dima_password;
			keyword1 = Data.dima_monster_keyword1;
			keyword2 = Data.dima_monster_keyword2;
			keyword3 = Data.dima_monster_keyword3;
			zipcode = Data.dima_zipcode;
			expectedTitle = Data.dima_monster_expectedTitle;
		}
		
		if (user.equals("olya")) {
			login = Data.olya_login;
			password = Data.olya_password;
			keyword1 = Data.olya_monster_keyword1;
			keyword2 = Data.olya_monster_keyword2;
			keyword3 = Data.olya_monster_keyword3;
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
		driver.findElement(By.xpath("//input[@name='txJobTitle_0']")).sendKeys(keyword1);
		driver.findElement(By.xpath("//input[@name='txJobTitle_1']")).clear();
		driver.findElement(By.xpath("//input[@name='txJobTitle_1']")).sendKeys(keyword2);
		driver.findElement(By.xpath("//a[@title='Add another job title']")).click();
		driver.findElement(By.xpath("//input[@name='txJobTitle_2']")).clear();
		driver.findElement(By.xpath("//input[@name='txJobTitle_2']")).sendKeys(keyword3);
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
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} 	catch (NoSuchElementException e) {
			return false;
			}
	}
}
