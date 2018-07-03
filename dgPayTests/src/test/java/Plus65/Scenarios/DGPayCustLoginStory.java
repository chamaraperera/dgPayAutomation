package Plus65.Scenarios;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import Plus65.steps.serenity.DGPayCustLoginRegistration;
import Plus65.steps.serenity.DGPayCustSelectLanguage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DGPayCustLoginStory {

	@Steps
	DGPayCustSelectLanguage dpgLangSelect;
	DGPayCustLoginRegistration dgpCustLogin;
	DGPayCustLoginRegistration dgpCustRegister;

	@Managed
	WebDriver browser;
	private String validphoneNumber = "+6582065852";
	private String validpassword = "qwer1234A";
	private String invalidphoneNumber = "+6565748394";
	private String invalidpassword = "qwer1234";

	@Test
	@Title("Login with valid credentials")
	public void validCustLogin() {
		//dpgLangSelect.selectMalayLanguage();
		//dpgLangSelect.selectEnglishLanguage();
		dpgLangSelect.dismissWarning();
		//dpgLangSelect.clickNextBtn();
		
		// dgpCustLogin.loginWithValidCredentials(validphoneNumber, validpassword);
	}

	@Test
	@Ignore
	@Title("Login with valid credentials")
	public void invalidCustLogin() {
		dgpCustLogin.loginWithValidCredentials(invalidphoneNumber, invalidpassword);
	}

	

}
