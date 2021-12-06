package StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import CartPageObjects.CartPageObject;
import UtilClasses.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddToCartSteps extends TestBase {
	static WebDriver driver ;
	
	CartPageObject pom;


	public void Load() throws InterruptedException {
		Thread.sleep(5000);
	}
	

	//BACKGROUND
	@Given("User is on the home page")
	public void user_is_on_the_home_page() throws IOException {
		driver = initializeDriver();
		pom = new CartPageObject();	
		pom.CartPageObjects();
	}

	
	//ADDING A SINGLE PRODUT TO THE CART
	@When("User search a product")
	public void user_search_a_product() {
		pom.SearchBox.sendKeys("Lenovo IdeaCentre 600 All-in-One PC");
		pom.SearchButton.click();
	}

	@When("User clicks on add to cart")
	public void user_clicks_on_add_to_cart() throws InterruptedException{
		pom.AddToCartButton.click();
		Load();
	}

	@Then("The product should be added to the cart")
	public void the_product_should_be_added_to_the_cart() {
		String qty = pom.CartQty.getText();
		System.out.println(qty);
		Assert.assertEquals(qty,"(1)");

	}

	
	
	
	//ADDING SINGLE PRODUCT TO THE CART MULTIPLE TIME 
	@When("User repeates to click on add to cart")
	public void user_repeates_to_click_on_add_to_cart() throws InterruptedException {
		pom.AddToCartButton.click();
		Load();
	}

	@Then("Product should be added to the cart the times user clicked on add to cart")
	public void product_should_be_added_to_the_cart_the_times_user_clicked_on_add_to_cart() {
		String qty = pom.CartQty.getText();
		System.out.println(qty);
		Assert.assertEquals(qty,"(2)");
		Teardown();
	}

	
	
	//ADDING PRODUCT TO THE CART BY ENTERING THE QUANTITY
	@When("User enters the quantity of the product")
	public void user_enters_the_quantity_of_the_product() throws InterruptedException {
		pom.LenovoPC.click();
		Load();
		WebElement a = pom.ProductQty;
		a.click();a.clear();a.sendKeys("5");
	}


	@Then("Product should be added to the cart with given quantity")
	public void product_should_be_added_to_the_cart_with_given_quantity() throws InterruptedException {
		String qty = pom.CartQty.getText();
		System.out.println(qty);
		Assert.assertEquals(qty,"(5)");
		Load();
		Teardown();
	}

	
	
	//ADDING DIFFERENT PRODUCTS TO THE CART
	@When("User search another product")
	public void user_search_another_product() {
		pom.SearchKeyword.clear();
		pom.SearchKeyword.sendKeys("Lenovo Thinkpad X1 Carbon Laptop");
		pom.SearchKeyButton.click();
	}

	@Then("All the product should be added to the cart")
	public void all_the_product_should_be_added_to_the_cart() {
		pom.ShoppingCart.click();
		List<WebElement> list = (List<WebElement>) pom.ShoppingList;
		System.out.println(list.size());
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i).getText());
		}
		Teardown();
	}

}
