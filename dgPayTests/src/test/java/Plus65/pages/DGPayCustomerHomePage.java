package Plus65.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;


//@DefaultUrl("https://uat.arrowmii.com/en/auth/login")
@DefaultUrl("https://staging.dgpayglobal.com")

public class DGPayCustomerHomePage extends PageObject {

	@Override
    public WebDriver getDriver() { 
		return super.getDriver();
	}
	
	// Initial Warning Errors Elements
	// Click on and dismiss them after checking if they are visible.
	
	
	// Login page Phone Number field
	public void enterPhoneNumber(String phoneNumber) {
		getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"Mobile No. (e)\"]")).sendKeys(phoneNumber);;
	}
	
	// Login page Password field
		public void enterPassword(String password) {
			getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"Password (e)\"]")).sendKeys(password);
	}
		
	// Login page Password field
		public void clickLoginBtn() {
			getDriver().findElement(By.name("Login (e)")).click();
	}
		
	// Login page Password field
		public void clickSignUp() {
			getDriver().findElement(By.name("Sign up (e)")).click();
	}
			
		
	
}
