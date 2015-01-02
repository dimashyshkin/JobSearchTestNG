package com.TestNG.JobSearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

@SuppressWarnings("unused")
public class CareerbuilderSearch extends Browser {
	
	//DATA
	String user;
	private String login;
	private String password;
	private String keywords;
	private String expectedTitle;
	private String city1;
	private String city2;
	private String city3;
	private String salary;

	@Parameters("user")
	@Test
	public void testCareerbuilderSearch(String user) throws Exception {
		if (user.equals("dima")) {
			login = Data.dima_login;
			password = Data.dima_password;
			keywords = Data.dima_careerbuilder_keywords;
			expectedTitle = Data.dima_careerbuilder_expectedTitle;
			city1 = Data.dima_careerbuilder_city1;
			city2 = Data.dima_careerbuilder_city2;
			city3 = Data.dima_careerbuilder_city3;
			salary = Data.dima_careerbuilder_salary;
		}
		
		if (user.equals("olya")) {
			login = Data.olya_login;
			password = Data.olya_password;
			keywords = Data.olya_careerbuilder_keywords;
			expectedTitle = Data.olya_careerbuilder_expectedTitle;
			city1 = Data.olya_careerbuilder_city1;
			city2 = Data.olya_careerbuilder_city2;
			city3 = Data.olya_careerbuilder_city3;
			salary = Data.olya_careerbuilder_salary;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		System.out.println(ourBrowser +": Open and login");
		driver.get("http://www.careerbuilder.com/");
		driver.findElement(By.id("_ctl6_SignIn")).click();
		driver.findElement(By.id("JobSeekerLoginV3_cbsys_login_email")).clear();
		driver.findElement(By.id("JobSeekerLoginV3_cbsys_login_email")).sendKeys(login);
		driver.findElement(By.id("JobSeekerLoginV3_cbsys_login_password")).clear();
		driver.findElement(By.id("JobSeekerLoginV3_cbsys_login_password")).sendKeys(password);
		driver.findElement(By.id("btnsignin")).click();
		driver.findElement(By.id("_ctl1_NavBar_Home")).click();
		driver.findElement(By.id("_ctl6_NavBar_ucQuickBar_advSearch")).click();
		driver.findElement(By.id("advancedSearch_s_rawwords")).clear();
		driver.findElement(By.id("advancedSearch_s_rawwords")).sendKeys(keywords);
		new Select(driver.findElement(By.id("advancedSearch_s_use"))).selectByVisibleText("Any of these words");
		driver.findElement(By.xpath("//input[@class='advancedSearch_s_freeloc_1_clean']")).clear();
		driver.findElement(By.xpath("//input[@class='advancedSearch_s_freeloc_1_clean']")).sendKeys(city1);
		driver.findElement(By.xpath("//input[@class='advancedSearch_s_freeloc_2_clean']")).clear();
		driver.findElement(By.xpath("//input[@class='advancedSearch_s_freeloc_2_clean']")).sendKeys(city2);
		driver.findElement(By.xpath("//input[@class='advancedSearch_s_freeloc_3_clean']")).clear();
		driver.findElement(By.xpath("//input[@class='advancedSearch_s_freeloc_3_clean']")).sendKeys(city3);
		new Select(driver.findElement(By.id("advancedSearch_s_freshness"))).selectByVisibleText("Last 3 Days");
	    new Select(driver.findElement(By.id("advancedSearch_s_jobtypes"))).selectByVisibleText("Information Technology");
	    driver.findElement(By.xpath("(//input[@class='s_emptype_JTPT'])")).click();
	    driver.findElement(By.xpath("(//input[@class='s_emptype_JTIN'])")).click();
	    driver.findElement(By.xpath("(//input[@class='s_emptype_JTSE'])")).click();
		driver.findElement(By.id("advancedSearch_exkw")).clear();
		driver.findElement(By.id("advancedSearch_exkw")).sendKeys("manager");
		driver.findElement(By.id("advancedSearch_exjl")).clear();
		driver.findElement(By.id("advancedSearch_exjl")).sendKeys("manager");
		new Select(driver.findElement(By.id("advancedSearch_s_paylow"))).selectByVisibleText(salary);
		driver.findElement(By.id("SearchBtn")).click();
		String title = driver.getTitle();
		if (expectedTitle.equals(title)) {
	    	System.out.println("Done");
	    }
	}
}
