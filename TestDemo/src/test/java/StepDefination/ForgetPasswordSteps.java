package StepDefination;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import CartPageObjects.CartPageObject;
import UtilClasses.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ForgetPasswordSteps extends TestBase {
	static WebDriver driver ;
	
	CartPageObject pom;

	//BACKGROUND
	@Given("User is on the password recovery page")
	public void user_is_on_the_password_recovery_page() throws IOException {
		driver = initializeDriver();
		pom = new CartPageObject();	
		pom.CartPageObjects();
		pom.Login.click();
		pom.ForgotPassword.click();
	}

	
	//PASSWORD RECOVERY USING A VALID EMAIL
	@When("User enter the email to recover the password")
	public void user_enter_the_email_to_recover_the_password() {
	  pom.Email.sendKeys("nviraj71@gmail.com");
	}

	@When("clicks on recover password")
	public void clicks_on_recover_password() {
		  pom.RecoverButton.click();
	}

	@Then("user should recieve the email")
	public void user_should_recieve_the_email() {	}

	@Then("A message of recovery link successfully send should be displayed")
	public void a_message_of_recovery_link_successfully_send_should_be_displayed() throws InterruptedException {
		String msg = pom.Recoverylink.getText();
		System.out.println(msg);
		Thread.sleep(3000);
		Assert.assertEquals(msg,"Email with instructions has been sent to you.");	 
		Teardown();
	}
	

	//PASSWORD RECOVERY WITH INVALID EMAIL
	@When("User enter the invalid email")
	public void user_enter_the_invalid_email() {
		 pom.Email.sendKeys("nv@gmail.com");
	}

	@Then("Error message of no email found should be displayed")
	public void error_message_of_no_email_found_should_be_displayed() {
		String errormsg = pom.emailNotFound.getText();
		System.out.println(errormsg);
		Assert.assertEquals(errormsg,"Email not found.");
		Teardown();
	}
	
	//PASSWORD RECOVERY WITH BLANK EMAIL FIEDL
	@When("User leaves the email field empty")
	public void user_leaves_the_email_field_empty() {
		
	}

	@Then("An error message of mandatory email field should be displayed")
	public void an_error_message_of_mandatory_email_field_should_be_displayed() {
		String msg = pom.EmailErrormsg.getText();
		System.out.println(msg);
		Assert.assertEquals(msg,"Enter your email");
		Teardown();
	}
	
}
