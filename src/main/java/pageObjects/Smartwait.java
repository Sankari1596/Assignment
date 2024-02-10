package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Smartwait {

	    public static void setImplicitWait(WebDriver driver, long seconds) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	    }
	    
	    
	
}
	   
	

