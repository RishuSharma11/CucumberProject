package StepDefination;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import CartPageObjects.CartPageObject;
import UtilClasses.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeLogoSteps extends TestBase  {
	static WebDriver driver ;
	CartPageObject pom;

	
	@Given("User has browser opened")
	public void user_has_browser_opened() throws IOException {
		driver = initializeDriver();
		pom = new CartPageObject();	
		pom.CartPageObjects();
	}

	@When("User launches the website")
	public void user_launches_the_website() {
		
	}

	@Then("User should be redirected to the home page and the website logo should e visible")
	public void user_should_be_redirected_to_the_home_page_and_the_website_logo_should_e_visible() {
	WebElement ImageFile = pom.HomeLogo;
        
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        String result = "";
        if (!ImagePresent)
        {
        	result = "Image not displayed.";
             System.out.println("Image not displayed.");
        }
        else
        {
        	result = "Image displayed.";
            System.out.println("Image displayed.");
        }
        Assert.assertEquals(result,"Image displayed.");
        Teardown();
	}
	
}
