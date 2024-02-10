package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import pageObjects.Smartwait;
import pageObjects.page1;

public class LogIn {

	static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/login");
		Date date =new Date();
		System.out.println(date);
	}

	@Test(groups= {"Negative case"}, priority = 1) 
	//Invalid User//1
	public void tc01() throws InterruptedException{		
		page1 page = new page1(driver);
		page.user("logintest@gmail.com");
		page.pass("login123@");
		page.button();
		page.userError();
		Smartwait.setImplicitWait(driver, 5);
		//Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login was successful");
	}

	@Test(groups= {"Negative case"},priority = 2)
	//Invalid Password //2
	public void tc02() throws InterruptedException {
		page1 page = new page1(driver);
		page.user("logintest123@gmail.com");
		page.pass("login");
		page.button();
		page.userError();
		Smartwait.setImplicitWait(driver, 5);		
	}

	@Test(groups= {"Negative case"},priority = 3)
	//Login with Empty fields //3
	public void tc03() throws InterruptedException {
		page1 page = new page1(driver);
		page.user("");
		page.pass("");
		page.button();
		page.emailError();
		Smartwait.setImplicitWait(driver, 5);		
	}

	@Test(groups= {"Negative case"},priority = 4)
	//Invalid Username and Password //4
	public void tc04() throws InterruptedException {
		page1 page = new page1(driver);
		page.user("logintest@gmail.com");
		page.pass("login");
		page.button();
		page.userError();
		Smartwait.setImplicitWait(driver, 5);		
	}

	@Test(groups= {"Negative case"},priority = 5)
	//Invalid email format //5
	public void tc05() throws InterruptedException {
		page1 page = new page1(driver);
		page.user("logintest.com");
		page.pass("login123@");
		page.button();
		page.emailError();
		Smartwait.setImplicitWait(driver, 5);
	}

	@Test(groups= {"Negative case"}, priority = 6)
	// Click Forgot password and enter invalid email format
	public void tc06() throws InterruptedException {
		page1 page = new page1(driver);
		page.forgotPass();
		page.user("logintest.com");
		page.recoverBtn();
		page.emailError();
		Smartwait.setImplicitWait(driver, 5);
	}

	@Test(groups= {"Negative case"},priority = 7)
	//Click Forgot password and enter invalid email id
	public void tc07() throws InterruptedException {
		page1 page = new page1(driver);
		page.forgotPass();
		page.user("logintest1@gmail.com");
		page.recoverBtn();
		page.invemail();
		Smartwait.setImplicitWait(driver, 5);
	}

	@Test(groups= {"Negative case"},priority = 8)
	//Click Forgot password and click recover with empty field
	public void tc08() throws InterruptedException {
		page1 page = new page1(driver);
		page.forgotPass();
		page.user("");
		page.recoverBtn();
		page.emailError();
		Smartwait.setImplicitWait(driver, 5);
	}

	@Test(groups= {"Positive case"},priority = 9)
	//Login successful
	public void tc09() throws InterruptedException{
		page1 page = new page1(driver);
		page.user("logintest123@gmail.com");
		page.pass("login123@");
		page.button();
		System.out.println(driver.getTitle());
		Smartwait.setImplicitWait(driver, 5);
	}

	@Test(groups= {"Positive case"}, priority = 10)
	//Click Forgot password and give valid email
	public void tc10() throws InterruptedException {
		page1 page = new page1(driver);
		page.forgotPass();
		page.user("logintest123@gmail.com");
		page.recoverBtn();
		page.invemail();
		Smartwait.setImplicitWait(driver, 5);
	}
	//	@DataProvider
	//	public Object[][] getLoginData() {
	//		Object[][] data =new Object[6][2];
	//		data[0][0]="logintest@gmail.com";
	//		data[0][1]="login123@";
	//		data[1][0]="logintest123@gmail.com";
	//		data[1][1]="login";
	//		data[2][0]="";
	//		data[2][1]="";
	//		data[3][0]="logintest@gmail.com";
	//		data[3][1]="login";
	//		data[4][0]="logintest.com";
	//		data[4][1]="login123@";
	//		data[5][0]="logintest123@gmail.com";
	//		data[5][1]="login123@";
	//		return data;
	//	}

	@AfterMethod
	public void afterTest() {
		Date date =new Date();
		System.out.println(date);
		driver.quit();		
	}	
}



