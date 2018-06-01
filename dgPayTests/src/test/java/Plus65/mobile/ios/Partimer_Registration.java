package Plus65.mobile.ios;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import ArrowMiiPages.ArrowMiiAdminHome;
//import ArrowMiiUtils.Setup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Partimer_Registration {

    //private AppiumDriver<IOSElement> driver;
    private static AppiumDriver driver;
    

    private WebElement row;

    @Before
    public void setUp() throws Exception {
        
    	// set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File("/Users/chamaraperera/Library/Developer/Xcode/DerivedData/dgpay-cdrxsfdtvbkmycbdnqgdsverdina/Build/Products/Debug-iphonesimulator/");
        
        File app = new File(appDir, "dgpay.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.3");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("newCommandTimeout", 800);
        //capabilities.setCapability("bundleId", "com.plus65dev.partimer");
        //driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        
    }

    @Test
    public void mockiOSTest() {
    	
    	//driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Mobile No. (e)\"]")).click();
    	//driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Mobile No. (e)\"]")).clear();
    driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Mobile No. (e)\"]")).sendKeys("+6545063457");
    //driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Mobile No. (e)\"]")).click();
    	
    	//driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Password (e)\"]")).click();
    	//driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Password (e)\"]")).clear();
    	driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Password (e)\"]")).sendKeys("1234qwer");
    	//driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Password (e)\"]")).click();
    	
    	driver.findElement(By.name("Login (e)")).click();
    	//driver.findElement(By.xpath("//*[@name=\"Login (e)\"])/[2]")).click();
    	//driver.findElement(By.xpath("//XCUIElementTypeOther[contains(text(),\"Login (e)\")]")).click();
    //(//XCUIElementTypeOther[@name="Login (e)"])[1]
    	
    	//driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Total (USD) 16,454.54 \"]")).click();

    	driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"  Settings\"]")).click();
    	driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\" Logout (e) \"]")).click();
    	driver.findElement(By.name("Signup (e)")).click();
    	
    	driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Country Code (e)\"]")).click();
    	
    }
    /*
    @Test	
    public void testMethod() throws InterruptedException
    {
    	
       Thread.sleep(1000);
        if(driver.findElementsByAccessibilityId("Allow").size()>=1)
        	driver.findElementByAccessibilityId("Allow").click();
        Thread.sleep(1000);
       
        IOSElement version = (IOSElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText[starts-with(@name, 'V')]"));
        
        for(int i=1; i<=7; i++)
        {
//        	JavascriptExecutor js = (JavascriptExecutor) driver;
//        	HashMap<String, String> scrollObject = new HashMap<String, String>();
//        	scrollObject.put("direction", "down");
//        	js.executeScript("mobile: scroll", scrollObject);
        	TouchAction ta = new TouchAction(driver);
        	ta.press(version).release().perform();
//        	int x, y;
//                x = version.getSize().height/2;
//                y = version.getSize().width/2;
//                ta.tap(x,y).perform();
                //((AppiumDriver) driver).tap(1, x, y, 100);
                try {
                    Thread.sleep(10);
                } catch (Exception e1) {
                }
//            new TouchAction((AppiumDriver) driver).longPress(version).release().perform();
//            new TouchAction((AppiumDriver) driver).press(version.getLocation().x, version.getLocation().y + version.getSize().height + 10).waitAction(50).release().perform();
        }
        
        driver.findElement(By.xpath("//*[@name='Staging']")).click();
        

        Thread.sleep(1000);
        
    	driver.findElementByAccessibilityId("CREATE AN ACCOUNT").click();
    	driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' First Name']/XCUIElementTypeTextField")).sendKeys("FirstName");
    	driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Last Name']/XCUIElementTypeTextField")).sendKeys("LastName");
    	
    	int acNo;
        acNo =39;
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Email Address']/XCUIElementTypeTextField")).sendKeys("testautomation65+partmobile"+acNo+"@gmail.com");
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Password']/XCUIElementTypeSecureTextField")).sendKeys("1234qwer");
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Confirm Password']/XCUIElementTypeSecureTextField")).sendKeys("1234qwer");
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Referral Code (Optional)']/XCUIElementTypeTextField")).sendKeys(Keys.RETURN);
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
    	HashMap<String, String> scrollObject = new HashMap<String, String>();
    	scrollObject.put("direction", "down");
    	js.executeScript("mobile: scroll", scrollObject);
    	
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name='  CREATE NOW']")).click();

        Thread.sleep(2000);
		
		TakesScreenshot screen =(TakesScreenshot)new Augmenter().augment(driver);
	    File ss = new File("/Screens/screenshot.png");
	    screen.getScreenshotAs(OutputType.FILE).renameTo(ss);
	  //Assert.
//    	System.out.println("Success");
    	
	    
	  
	    	if(driver.findElements(By.xpath("//XCUIElementTypeOther[contains(@text, 're almost there')]")).size()>=1)
	    		System.out.println(driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name, 'testautomation65+partmobile')]")).getText());
	    	else
	    		System.out.println("Fail");
    }
    */
    @After
    public void tearDown() throws Exception {
       //driver.quit();
    }
}