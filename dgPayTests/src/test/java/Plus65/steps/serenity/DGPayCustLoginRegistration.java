package Plus65.steps.serenity;

import Plus65.pages.*;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.constraints.AssertTrue;



public class DGPayCustLoginRegistration {

	DGPayCustomerHomePage dgPayCustHomePage;

	@Step
	public void navigateCustomerLoginPage() {
		dgPayCustHomePage.open();
	}
	
	@Step
	public void loginWithValidCredentials(String phoneNumber, String password) {
		dgPayCustHomePage.enterPhoneNumber(phoneNumber);
		dgPayCustHomePage.enterPassword(password);
		dgPayCustHomePage.clickLoginBtn();
	}
	
	
	

	
}
