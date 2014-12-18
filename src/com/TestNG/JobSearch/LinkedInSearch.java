package com.TestNG.JobSearch;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class LinkedInSearch extends Browser {
	
	//DATA
	String user;
	private String login;
	private String password;
	private String keywords;
	private String zipcode;
	private String expectedResult;

	@Test
	public void testLinkedIn() throws Exception {
		//User
		user = Data.user;
		if (user.equals("dima")) {
			login = Data.dima_login;
			password = Data.dima_password;
			keywords = Data.dima_linkedin_keywords;
			zipcode = Data.dima_zipcode;
			expectedResult = Data.dima_linkedin_expectedResult;
		}
		
		if (user.equals("olya")) {
			login = Data.olya_login;
			password = Data.olya_password;
			keywords = Data.olya_linkedin_keywords;
			zipcode = Data.olya_zipcode;
			expectedResult = Data.olya_linkedin_expectedResult;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);	
		System.out.println("Open and login");
		driver.get("http://www.linkedin.com/");
		driver.findElement(By.id("session_key-login")).clear();
		driver.findElement(By.id("session_key-login")).sendKeys(login);
		driver.findElement(By.id("session_password-login")).clear();
		driver.findElement(By.id("session_password-login")).sendKeys(password);

		driver.findElement(By.id("signin")).click();


		System.out.println("Submit search");
		driver.findElement(By.linkText("Jobs")).click();
	    driver.findElement(By.id("toggle-advanced")).click();
	    driver.findElement(By.linkText("More options")).click();
	    driver.findElement(By.id("advs-keywords")).clear();
	    driver.findElement(By.id("advs-keywords")).sendKeys(keywords);
	    driver.findElement(By.id("advs-postalCode")).clear();
	    driver.findElement(By.id("advs-postalCode")).sendKeys(zipcode);
	    new Select(driver.findElement(By.id("advs-distance"))).selectByVisibleText("35 mi (55 km)");
	    driver.findElement(By.xpath("//legend[contains(text(),'Date Posted')]")).click();
	    driver.findElement(By.id("adv-1-TP-ffs")).click();
	    driver.findElement(By.id("adv-2-TP-ffs")).click();
	    driver.findElement(By.name("submit")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='pivot-reset']")));
		String result = driver.findElement(By.xpath("//div[@id='results_count']/p")).getText();
		System.out.println(result);
		if (result.contains(expectedResult)) {
	    	System.out.println("Done");
	    }
	}
}
