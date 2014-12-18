package com.TestNG.JobSearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

@SuppressWarnings("unused")
public class DiceSearch extends Browser{
	
	//DATA
	String user;
	private String login;
	private String password;
	private String keywords;
	private String zipcode;
	private String expectedTitle;

	@Test
	public void testDiceSearch() throws Exception {
		//User
		user = Data.user;
		if (user.equals("dima")) {
			System.out.println(ourBrowser +": Search for Dima");
			login = Data.dima_login;
			password = Data.dima_password;
			keywords = Data.dima_dice_keywords;
			zipcode = Data.dima_zipcode;
			expectedTitle = Data.dima_dice_expectedTitle;
		}
		
		if (user.equals("olya")) {
			System.out.println(ourBrowser +": Search for Olya");
			login = Data.olya_login;
			password = Data.olya_password;
			keywords = Data.olya_dice_keywords;
			zipcode = Data.olya_zipcode;
			expectedTitle = Data.olya_dice_expectedTitle;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println(ourBrowser +": Open and login Dice");
		driver.get("http://www.dice.com/");
		driver.findElement(By.cssSelector("#Login_1 > span")).click();
		driver.findElement(By.id("Email_1")).clear();
		driver.findElement(By.id("Email_1")).sendKeys(login);
		driver.findElement(By.id("Password_1")).clear();
		driver.findElement(By.id("Password_1")).sendKeys(password);
		driver.findElement(By.cssSelector("#LoginBtn_1 > span")).click();

		System.out.println(ourBrowser +": Submit search");
		driver.findElement(By.xpath("(//div[@id='title']/a)")).click();
		driver.findElement(By.linkText("Advanced Job Search")).click();
		driver.findElement(By.id("searchTerms")).clear();
		driver.findElement(By.id("searchTerms")).sendKeys(keywords);
		new Select(driver.findElement(By.id("matchMode"))).selectByVisibleText("Boolean");
		driver.findElement(By.id("searchJobTitleOnly1")).click();
		driver.findElement(By.id("excludeValueList1")).clear();
		driver.findElement(By.id("excludeValueList1")).sendKeys("manager");
		new Select(driver.findElement(By.id("zipCodeCityRadius"))).selectByVisibleText("within 30 miles of");
		driver.findElement(By.id("zipCodeCity")).clear();
		driver.findElement(By.id("zipCodeCity")).sendKeys(zipcode);
		new Select(driver.findElement(By.id("travelPct"))).selectByVisibleText("< 100%");
		driver.findElement(By.id("show")).click();
		new Select(driver.findElement(By.id("taxTermList"))).selectByVisibleText("Full-time");
		
		Select termList = new Select(driver.findElement(By.id("taxTermList")));
		termList.selectByVisibleText("Full-time");
		termList.selectByVisibleText("Contract - Corp-to-Corp");
		termList.selectByVisibleText("Contract - Independent");
		termList.selectByVisibleText("Contract - W2");
		termList.selectByVisibleText("Contract to Hire - Corp-to-Corp");
		termList.selectByVisibleText("Contract to Hire - Independent");
		termList.selectByVisibleText("Contract to Hire - W2");
		termList.selectByVisibleText("Part-time");
		new Select(driver.findElement(By.id("daysBack"))).selectByVisibleText("2");
		new Select(driver.findElement(By.id("numPerPage"))).selectByVisibleText("50");
		driver.findElement(By.id("submit2-button")).click();
		String title = driver.getTitle();
		if (expectedTitle.equals(title)) {
	    	System.out.println(ourBrowser +": Done");
	    }
		if (isElementPresent(By.xpath("//button[@id='SubmitAlert_1']"))) {
			driver.findElement(By.xpath("//button[@class='close']")).click();
		}
	}

	private boolean isElementPresent(By by) {
	// Changed implicitlyWait for this statement, because I dont need to wait for 60 seconds here. 
	// If I use it for 'Wait for element NOT present', it will take just 1 second to throw exception, not 60
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} 	catch (Exception e) {
			return false;
			}
	}
}
