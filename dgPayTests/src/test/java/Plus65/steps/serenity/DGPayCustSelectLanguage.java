package Plus65.steps.serenity;

import Plus65.pages.DGPayCustomerLanguageSelection;
import io.appium.java_client.TouchAction;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.constraints.AssertTrue;



public class DGPayCustSelectLanguage {

	DGPayCustomerLanguageSelection dgPayCustSelectLang;
	
	@Managed
    WebDriver browser;

	@Step
	public void navigateCustomerSelectLangaugePage() {
		dgPayCustSelectLang.open();
	}
	
	@Step
	// selectEnglish
	public void selectEnglishLanguage() {
		dgPayCustSelectLang.clickEnglishLangButton();
	}
	
	@Step
	// selectMalay
	public void selectMalayLanguage() {
		dgPayCustSelectLang.clickEnglishLangButton();
	}
	
	@Step
	// try to dismiss the warnings by clicking on coordinates
	public void dismissWarning() {
		dgPayCustSelectLang.clickWarningArea();
	}
	
	
	
	
	

	
}
