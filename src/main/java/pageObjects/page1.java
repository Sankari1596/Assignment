package pageObjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class page1 {

	WebDriver driver;
	public page1(WebDriver driver) {
		this.driver= driver;
	}

	By textUserName = By.id("Email");
	public void user(String data) {
		driver.findElement(textUserName).sendKeys(data);
	}

	By txtPassword = By.id("Password");
	public void pass(String data) {
		driver.findElement(txtPassword).sendKeys(data);
	}
	By ClckBtn = By.className("login-button");
	public void button() {
		driver.findElement(ClckBtn).click();

	}

	public void userError() {
		String invalidUserError =driver.findElement(By.className("message-error")).getText();
		System.out.println ("Error message : " + invalidUserError);

	}

	public void emailError() {
		String invalidEmail = driver.findElement(By.id("Email-error")).getText();
		System.out.println("Error message : " + invalidEmail);
	}

	By clckFrgtPass = By.linkText("Forgot password?");
	public void forgotPass() {
		driver.findElement(clckFrgtPass).click();
	}

	By clckRecBtn = By.name("send-email");
	public void recoverBtn() {
		driver.findElement(clckRecBtn).click();
	}
	
	public void invemail() {
		String invalidEmail =driver.findElement(By.className("content")).getText();
		System.out.println ("Error message : " + invalidEmail);

	}
	
	
}
