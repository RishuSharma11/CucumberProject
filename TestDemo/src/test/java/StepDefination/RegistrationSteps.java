package StepDefination;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import CartPageObjects.CartPageObject;
import UtilClasses.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegistrationSteps extends TestBase  {
static WebDriver driver ;
	
	CartPageObject pom;

	//REGISTRATION URL VERIFICATION
	@Given("User is on the registration page")
	public void user_is_on_the_registration_page() throws IOException {
		driver = initializeDriver();
		pom = new CartPageObject();	
		pom.CartPageObjects();
		pom.Register.click();
	}

	@When("User clicks on register button")
	public void user_clicks_on_register_button() {
		
	}

	@Then("User should be redirected to the registration page.")
	public void user_should_be_redirected_to_the_registration_page() throws InterruptedException {
		String actualUrl="https://demo.nopcommerce.com/register?returnUrl=%2F";
		Assert.assertEquals(actualUrl , driver.getCurrentUrl());
		Teardown();
		
	}

	//REGISTRATION WITH VALID DETAIL
	@When("Selects the gender")
	public void selects_the_gender() {
		pom.Gender.click();
	}
	@When("User enters following details {string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_enters_following_details_and(String Firstname, String Lastname, String DOBD, String DOBM, String DOBY,
			String Email, String Company, String Password, String Cpassword) {
		pom.FName.sendKeys(Firstname);
		pom.LName.sendKeys(Lastname);
		pom.DoBD.sendKeys(DOBD);
		pom.DoBM.sendKeys(DOBM);;
		pom.DoBY.sendKeys(DOBY);;
		pom.Email.sendKeys(Email);
		pom.Company.sendKeys(Company);
		pom.Password.sendKeys(Password);
		pom.ConfirmPassword.sendKeys(Cpassword);
		
	}
	@When("Clicks on register button")
	public void clicks_on_register_button() {
		pom.RegisterButton.click();
	}

	@Then("Registration should be successfully done")
	public void registration_should_be_successfully_done() { }

	@Then("A message a should be displayed")
	public void a_message_a_should_be_displayed() {		
		String successMsg = pom.RegSuccessmsg.getText();
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "Your registration completed");
		Teardown();
	}
	
	
	//MANDATORY FIELD INPUTS
	 @When("User enters {string} and {string}")
	 public void user_enters_and(String Firstname, String Lastname) {
		pom.FName.sendKeys(Firstname);
		pom.LName.sendKeys(Lastname);
	 }

	@When("Clears both the field")
	public void clears_both_the_field() {
		pom.FName.sendKeys(Keys.BACK_SPACE);
		pom.LName.sendKeys(Keys.BACK_SPACE);
	}

	@Then("An error message of mandatory field should be displayed")
	public void an_error_message_of_mandatory_field_should_be_displayed() {
		String firstNameError = pom.FNameErrormsg.getText();
		String lastNameError  = pom.LNameErrormsg.getText();
		System.out.println(firstNameError+"\n"+lastNameError);
		Assert.assertEquals(firstNameError,"First name is required.");
		Assert.assertEquals(lastNameError,"Last name is required.");
		Teardown();
	}
	
	
	//INVALID EMAIL OR BLANK FIELD
	@When("User enters invalid email")
	public void user_enters_invalid_email() {
		pom.Email.sendKeys("abc");
		pom.FName.click();
	}

	@Then("An error message should be displayed")
	public void an_error_message_should_be_displayed() {
		String emailError = pom.EmailErrormsg.getText();
		System.out.println(emailError);
		Assert.assertEquals(emailError, "Wrong email");
		Teardown();
	}
	
	
	
	//WEEK PASSWORD VERIFICATION
	@When("User Enters A week password")
	public void user_enters_a_week_password() {
		pom.Password.sendKeys("vi");
		pom.ConfirmPassword.click();
	    
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
		String s = pom.PassErrormsg.getText();
		System.out.println(s);
		Teardown();
	}

}