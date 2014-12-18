package com.TestNG.JobSearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

@SuppressWarnings("unused")
public class Browser {

	WebDriver driver;
	String ourBrowser;
	@BeforeMethod   /* The annotated method will be run before all tests in this suite have run */

	//browser is the name of parameter that we have used in xml
	@Parameters("browser")  /* this annotation is used to insert parameter in test*/
	public void openBroswer(String browser){
	
	/*Comparing the value of parameter name if this is FF then It would launch Firefox and script that would run is as follows */
		if(browser.equalsIgnoreCase("FF"))	{
		ourBrowser = "Firefox";
		driver = new FirefoxDriver();
		}	else if(browser.equalsIgnoreCase("GH"))	{
			ourBrowser = "Chrome";
			System.setProperty("webdriver.chrome.driver", "C:/Users/dmitry.shyshkin/WebDriverDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			}	else	{
				ourBrowser = "IE";
				System.setProperty("webdriver.ie.driver", "c:/Users/Dima/workspace/win32IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				}
		System.out.println(ourBrowser + " driver would be used");
	}
	
//	@AfterMethod /* this annotation would run once test script execution would complete*/
//	public void closeBrowser() {
//		try{
//		driver.wait(15000);
//		} catch(Exception e){}
//		driver.close();
//		driver.quit();
//	}
}