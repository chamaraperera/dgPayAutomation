package Plus65.mobile.android;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;

//import Plus65.pages.MobileDriver;
//import Plus65.steps.serenity.AdminNavigation;
import Plus65.steps.serenity.DGPayCustLoginRegistration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Partimer_Registration {

    //private AppiumDriver<IOSElement> driver;
   
	/*
    private WebElement row;
    
    @Steps
    DGPayCustLoginRegistration partimer;
 

    
    @Managed
    WebDriver browser;
    @Ignore
    @Test	
    @Title ("Android Device - Register new partimer and Login")
    public void validate_A_NewPartimer_Registration_And_Login_On_Android() throws InterruptedException
    {
    	MobileDriver.setupAndroidDriver();
    	partimer.clickOnCreateNewAccountButton();	
    	Integer acNo;
        acNo =5;
    	partimer.entersNewAccountDetails("Android",acNo.toString(), "testautomation65+"+acNo.toString()+"@gmail.com", "1234qwer", "1234qwer", "");
    	partimer.clicksOnCreateNowButton();
    	partimer.shouldSeeText("testautomation65+"+acNo.toString()+"@gmail.com");
        
//        TouchAction tAction=new TouchAction(driver);
//    	int startx = driver.findElement(By.xpath("//*[@text='Password']/../*[@class='android.widget.EditText']")).getLocation().getX();
//    	int starty = driver.findElement(By.xpath("//*[@text='Password']/../*[@class='android.widget.EditText']")).getLocation().getY();
//    	int endx = driver.findElement(By.xpath("//*[@text='First Name']/../*[@class='android.widget.EditText']")).getLocation().getX();
//    	int endy = driver.findElement(By.xpath("//*[@text='First Name']/../*[@class='android.widget.EditText']")).getLocation().getY();
//    	System.out.println(startx + " ::::::: " + starty + " ::::::: " + endx +  " ::::::: " +	endy);
//
//    	//First tap on the screen and swipe it right using moveTo function
//    	tAction.press(startx+20,starty+20).moveTo(endx+20,endy+20).release().perform(); 
//    	Thread.sleep(1000);
    	
    	
//      List <AndroidElement> elements = ((AndroidDriver) driver).findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className('android.widget.TextView'), 'CREATE')");
//    	System.out.println(elements.get(0).getText());
       
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//    	HashMap<String, String> scrollObject = new HashMap<String, String>();
//    	scrollObject.put("direction", "down");
////    	scrollObject.put("element", ((RemoteWebElement) element).getId());
//    	js.executeScript("mobile: scroll", scrollObject);
        

    }
    
    

    @Test	
    @Title ("IOS Device - Register new partimer and Login")
    public void validate_A_NewPartimer_Registration_And_Login_On_IOS() throws InterruptedException
    {
    	MobileDriver.setupIOSDriver();
    	partimer.clickOnCreateNewAccountButton();	
    	Integer acNo;
        acNo =6;
    	partimer.entersNewAccountDetails("Android",acNo.toString(), "testautomation65+"+acNo.toString()+"@gmail.com", "1234qwer", "1234qwer", "");
    	partimer.clicksOnCreateNowButton();
    	partimer.shouldSeeText("testautomation65+"+acNo.toString()+"@gmail.com");
    }
    
    */
}

