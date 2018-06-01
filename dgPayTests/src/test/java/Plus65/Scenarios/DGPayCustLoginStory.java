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
	DGPayCustLoginRegistration dgpCustLogin;
	DGPayCustLoginRegistration dgpCustRegister;
	
    @Managed
    WebDriver browser;
    private String validphoneNumber = "+6565748394";
    private String validpassword = "qwer1234";
    private String invalidphoneNumber = "+6565748394";
    private String invalidpassword = "qwer1234";
    

    @Test
    @Title ("Login with valid credentials")
    public void validCustLogin() {
    		dgpCustLogin.loginWithValidCredentials(validphoneNumber, validpassword);
    }
    
    @Test
    @Title ("Login with valid credentials")
    public void invalidCustLogin() {
    		dgpCustLogin.loginWithValidCredentials(invalidphoneNumber, invalidpassword);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    @Test
    
    @Title ("Register new partimer and Login")
    public void A_validate_A_NewPartimer_Registration_And_Login() throws InterruptedException
    {	
//    	email="testautomation65+729@gmail.com";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.entersNewAccountDetails(firstName, lastName, email, password2, password_confirmation, referral_code);
    	partimerNav.clicksOnCreateNowButton();
    	partimerNav.shouldSeeText("A Confirmation Email Has Been Sent");
    	partimerNav.isAtGmailLoginPage();
    	partimerNav.verifiesPartimerEmailRegistration(gmailEmail, gmailPassword);
    	int max = 99999;
		int min = 11111;
		int value = rand.nextInt((max - min) + 1) + min;
		partimerNav.partimerLogsInAfterEmailVerification(email, password2, "G3"+Integer.toString(value)+"6K", "Construction", "Dishwasher");
    
    }
    
    
    
    @Test
    @Title ("Login with no email & password")
    public void B_validate_Login_With_No_Password() throws InterruptedException
    {
    	String lemail = "";
    	String noPassword = "";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(lemail, noPassword);
    	Thread.sleep(2000);
    	//Then
    	partimerNav.shouldSeeText("The email field is required.");
    	partimerNav.shouldSeeText("The password field is required.");
    }
    
    
    
    @Test
    @Title ("Login with wrong password")
    public void C_validate_Login_With_Incorrect_Password() throws InterruptedException
    {
    
    	String incorrectPassword = "wrongPassword";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(email, incorrectPassword);
    	//Then
    	Thread.sleep(2000);
    	partimerNav.shouldSeeText("Incorrect Password.");
    }
    
    @Test
    @Title ("Login with an unregistred email")
    public void D_validate_Login_With_Unregistered_Email() throws InterruptedException
    {
    	String email = "test@test.com";
    	String incorrectPassword = "wrongPassword";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(email, incorrectPassword);
    	//Then
    	Thread.sleep(2000);
    	partimerNav.shouldSeeText("Email Address Is Incorrect.");
    }
       
    
    @Test
    @Ignore
    @Title ("Forgot Password, Reset Password and Login")
    public void E_validate_Forgot_Password() throws InterruptedException
    {
    	

    	String newPassword = "1234qwer123";
    	String newPasswordConfirmation = "1234qwer123";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.clickOnForgotPasswordAndResetPassword(email);
    	partimerNav.shouldSeeText("Password Reset Sent!");
    	partimerNav.isAtGmailLoginPage();
    	partimerNav.resetsPartimersPassword(gmailEmail, gmailPassword);
    	partimerNav.enterNewPasswordForReset(newPassword, newPasswordConfirmation);
    	//Then
    	partimerNav.shouldSeePageTitle("Success");
    	
    }
    
    @Test
    @Title ("Try forgot password for unregistered email")
    public void F_validate_Forgot_Password_For_Unregistered_Email() throws InterruptedException
    {
    	
    	String email = "test@test.com";

    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.clickOnForgotPasswordAndResetPassword(email);

    	//Then
    	partimerNav.shouldSeeText("The selected email is invalid.");
    	
    }
    
    
    @Test
    @Title ("Click on Back to Sign in page")
    public void G_validate_BacktoSignIn()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.clickOnCreateNewAccountButton();
    	partimerNav.clickOnBackToSignIn();
    	//Then
    	partimerNav.shouldSeePageTitle("ArrowMii - Login");
    }
    
    @Test
    @Title ("Create user without filling required fields")
    public void H_validate_RequiredFields_Partimer_Registarion()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.entersNewAccountDetails("", "", "", "", "", "");
    	partimerNav.clicksOnCreateNowButton();
    	//Then
    	partimerNav.shouldSeeRequiredFieldsAlert();
    }
    
    
    @Test
    @Title ("Password min requirement validation")
    public void I_validate_Password_For_Min_Char() throws InterruptedException
    {
    	
    	String[] invalidPassword = {"pw1","12345678","qwertyui"};
    	
    	for (int i=0; i<invalidPassword.length; i++ )
    	{
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.entersNewAccountDetails(firstName, lastName, email, invalidPassword[i], password_confirmation, referral_code);
    	partimerNav.clicksOnCreateNowButton();
    	Thread.sleep(2000);
    	//Then
			if (invalidPassword[i].equals("pw1")) {
				partimerNav.shouldSeeText("Your password must be at least 8 characters.");
					  
			} else {
				partimerNav.shouldSeeText("Please include at least a digit and a character.");
    	}
    	}
    }
    
    @Test
    @Title ("Mismatching Password and Confirm Password")
    public void K_validate_Password_And_ConfirmedPassword_Mismatch()
    {
    	String mismatchingConfirmationPassword = "1234qwer1";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.entersNewAccountDetails(firstName, lastName, email, password, mismatchingConfirmationPassword, referral_code);
    	partimerNav.clicksOnCreateNowButton();
    	partimerNav.shouldSeeText("The password confirmation does not match.");
    	//Then
    	
    }
    */

}
