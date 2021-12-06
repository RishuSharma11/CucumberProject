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

public class LoginSteps extends TestBase  {
	static WebDriver driver ;
	
	CartPageObject pom;
	
	//BACKGROUND
	@Given("User is on the Login page")
	public void user_is_on_the_login_page() throws IOException {
		driver = initializeDriver();
		pom = new CartPageObject();	
		pom.CartPageObjects();
		pom.Login.click();
	}
	
	//LOGIN URL VERIFICATION
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		pom.LoginButton.click();
	}

	@Then("User should be redirected to the Login page")
	public void user_should_be_redirected_to_the_login_page() {
		String Loginurl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		Assert.assertEquals(driver.getCurrentUrl(),Loginurl);
		Teardown();
	}
    //LOGIN WITH VALID USER DETAILS
	@When("User enters the {string} and {string}")
	public void user_enters_the_and(String Username, String Password) {
		pom.Email.sendKeys(Username);
		pom.Password.sendKeys(Password);
	}

	@When("Clicks on login button")
	public void clicks_on_login_button() {
		pom.LoginButton.click();

	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		driver.findElement(By.xpath("//a[@class='ico-account']")).click();
		String fname = pom.FName.getAttribute("value");
		String lname = pom.LName.getAttribute("value");
		System.out.println(fname+" "+lname);
		Assert.assertEquals(fname+" "+lname, "Seema roy");
		Teardown();
	}
	
	//LOGIN WITH EMPTY FIELDS	
	@When("User keeps the email and password field empty")
	public void user_keeps_the_email_and_password_field_empty() {
	   
	}

	@When("Clicks on the login button")
	public void clicks_on_the_login_button() {
		pom.LoginButton.click();
	}

	@Then("An error message should be displayed to the user")
	public void an_error_message_should_be_displayed_to_the_user() {
		String s = pom.EmailErrormsg.getText();
		System.out.println(s);
		Assert.assertEquals(s,"Please enter your email");
		Teardown();
	}
	
	//LOGIN WITH INVALID USERNAME AND PASSWORD

	@When("User enters the invalid username and password")
	public void user_enters_the_invalid_username_and_password() {
		pom.Email.sendKeys("axvcd@gmail.com");
		pom.Password.sendKeys("aksjc123");
	}

	@Then("An error message should be displayed to user")
	public void an_error_message_should_be_displayed_to_user() {
		String errormsg = pom.NoUserFound.getText();
		System.out.println(errormsg);
		//System.out.println("Login was unsuccessful. Please correct the errors and try again.\nNo customer account found ");
		Assert.assertEquals(errormsg,"No customer account found");
		Teardown();
	}
	
	//LOGIN WITH VALID USERNAME AND INVALID PASSWORD
	@When("User enters the valid {string} and invalid {string}")
	public void user_enters_the_valid_username_and_invalid_password(String username, String password) {
		pom.Email.sendKeys(username);
		pom.Password.sendKeys(password);
	}

	@Then("User should recieve an error message")
	public void user_should_recieve_an_error_message() {
		String errormsg = pom.WrongCred.getText();
		System.out.println(errormsg);
		//System.out.println("Login was unsuccessful. Please correct the errors and try again.\nNo customer account found ");
		Assert.assertEquals(errormsg,"The credentials provided are incorrect");
		Teardown();
	}
	
}