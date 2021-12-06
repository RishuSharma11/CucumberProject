package StepDefination;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import CartPageObjects.CartPageObject;
import UtilClasses.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchProductSteps extends TestBase  {
	
	static WebDriver driver ;
	CartPageObject pom;
	

	//BACKGROUND
	@Given("The user is on home page")
	public void the_user_is_on_home_page() throws IOException {
		driver = initializeDriver();
		pom = new CartPageObject();	
		pom.CartPageObjects();
	}

	
	//SEARCH WITH EMPTY SEARCH FIELD
	@When("User leaves the search field empty")
	public void user_leaves_the_search_field_empty() {	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() { 
		pom.SearchButton.click();
	}

	@Then("An alert box with error message should be displayed to the user")
	public void an_alert_box_with_error_message_should_be_displayed_to_the_user() {	
		Teardown();
	}

	
	//SEARCH WITH A NON EXISTING PRODUCT
	@When("User enters a non existing product name")
	public void user_enters_a_non_existing_product_name() {
		pom.SearchBox.sendKeys("xyz");
	}

	@Then("An error of no such product should be displayed")
	public void an_error_of_no_such_product_should_be_displayed() {
		String msg = pom.noProductFound.getText();
		System.out.println(msg);
		Assert.assertEquals(msg,"No products were found that matched your criteria.");	
		Teardown();;
	}
	
	//SUGGESTION BY ENTERING KEYWORD
	@When("User enters a partial name of the product")
	public void user_enters_a_partial_name_of_the_product() throws InterruptedException {
		pom.SearchBox.sendKeys("lap");
		Thread.sleep(3000);
	}

	@Then("User should be given suggestions with respect to the keyword entered")
	public void user_should_be_given_suggestions_with_respect_to_the_keyword_entered() {

	}
	
	@When("User selects one of the suggestions")
	public void user_selects_one_of_the_suggestions() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class='ui-menu-item'][2]")).click();
	}

	@Then("User should be redirected to the page of the selected product")
	public void user_should_be_redirected_to_the_page_of_the_selected_product() {
		String name = pom.LenovoPC1.getText();
		System.out.println(name);
		Assert.assertEquals(name,"Lenovo Thinkpad X1 Carbon Laptop");	
		Teardown();
	}
	
	
	//SEARCH WITH SPECIAL CHARACTER OR NUMBERS
	@When("User enters the input")
	public void user_enters_the_input() {
		pom.SearchBox.sendKeys("1!2@");
	}

}