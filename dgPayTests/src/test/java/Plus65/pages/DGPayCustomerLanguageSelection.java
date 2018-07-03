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
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

@DefaultUrl("https://staging.dgpayglobal.com")

public class DGPayCustomerLanguageSelection extends PageObject {

	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}

	// Initial Warning Errors Elements
	// Click on and dismiss them after checking if they are visible.

	// Choose your language label
	public void checkLanguagePageLabel() {
		getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Choose Your language (e)\"]"));
	}

	// Language page English language button
	public void clickEnglishLangButton() {
		getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"English\"]")).click();
	}

	// Language page Chinese language button
	public void clickChineseLangButton() {
		getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"简体中文\"]")).click();
	}

	// Language page Chinese2 language button
	public void clickChinese2LangButton() {
		getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"繁体中文\"]")).click();
	}

	// Language page Malay language button
	public void clickMalayLangButton() {
		getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"Malay\"]")).click();
	}
	
	// Language page Next language button
	public void clickNextButton() {
		getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"Next (e)\"]")).click();
	}
	
	// Language page warning bar
	public void clickOrangeWarningBar() {
		getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"Next (e)\"]")).click();
	}
	
	public void clickWarningArea() {
		TouchAction tap = new TouchAction((PerformsTouchActions) super.getDriver());
		tap.press(163, 644);
	}

}
