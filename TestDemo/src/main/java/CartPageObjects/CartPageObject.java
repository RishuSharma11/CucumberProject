package CartPageObjects;
	
	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import UtilClasses.TestBase;

	//Inheriting the TestBase class (Parent class), CartPageObjects is child of TestBase
	public class CartPageObject extends TestBase {

		/* WebElements for Cart Page */

	/* By using CacheLookup we are creating one cache memory and this element will be stored in that memory, 
	 it will help in improving script's performance, As it will not go to the browser and look for this element, 
	 it will fetch the details from Cache memory only. 
	*/
		
		@FindBy(xpath = "//input[@id='small-searchterms']")
		@CacheLookup
		public WebElement SearchBox;
		
		@FindBy(xpath = "//input[@id='q']")
		@CacheLookup
		public WebElement SearchKeyword;

		@FindBy(xpath = "//button[@class='button-1 search-box-button']")
		@CacheLookup
		public WebElement SearchButton;
		
		@FindBy(xpath = "//button[@class='button-1 search-button']")
		@CacheLookup
		public WebElement SearchKeyButton;
		
		@FindBy(xpath = "//span[@class='cart-qty']")
		@CacheLookup
		public WebElement CartQty;
		
		@FindBy(xpath = "//button[@id='add-to-cart-button-3' and @type='button']")
		@CacheLookup
		public WebElement AddToCartButton;	
		
		
		@FindBy(xpath = "//input[@id='product_enteredQuantity_3']")
		@CacheLookup
		public WebElement ProductQty;
		
		@FindBy(xpath="//a[text()='Lenovo IdeaCentre 600 All-in-One PC']")
		@CacheLookup
		public WebElement LenovoPC;
		
		@FindBy(xpath = "//span[@class='cart-label']")
		@CacheLookup
		public WebElement ShoppingCart;
		
		@FindBy(xpath = "//a[@class='product-name']")
		@CacheLookup
		public WebElement ShoppingList;
		
		//Registration - - - - - - - - - - - - - - - - - - - - - - 
		
		@FindBy(xpath = "//a[text()='Register']")
		@CacheLookup
		public WebElement Register;
	
		@FindBy(className = "male")
		@CacheLookup
		public WebElement Gender;
		
		@FindBy(id = "FirstName")
		@CacheLookup
		public WebElement FName;
		
		@FindBy(id = "LastName")
		@CacheLookup
		public WebElement LName;
		
		@FindBy(name="DateOfBirthDay")
		@CacheLookup
		public WebElement DoBD;
		
		@FindBy(name="DateOfBirthMonth")
		@CacheLookup
		public WebElement DoBM;
		
		@FindBy(name="DateOfBirthYear")
		@CacheLookup
		public WebElement DoBY;
		
		@FindBy(id="Email")
		@CacheLookup
		public WebElement Email;
		
		@FindBy(id="Company")
		@CacheLookup
		public WebElement Company;
		
		@FindBy(id="Password")
		@CacheLookup
		public WebElement Password;
		
		@FindBy(id="ConfirmPassword")
		@CacheLookup
		public WebElement ConfirmPassword;
		
		@FindBy(id="register-button")
		@CacheLookup
		public WebElement RegisterButton;
		
		@FindBy(xpath = "//div[@class='result']")
		@CacheLookup
		public WebElement RegSuccessmsg;
		
		@FindBy(id = "FirstName-error")
		@CacheLookup
		public WebElement FNameErrormsg;
		
		@FindBy(id = "LastName-error")
		@CacheLookup
		public WebElement LNameErrormsg;
		
		@FindBy(id = "Email-error")
		@CacheLookup
		public WebElement EmailErrormsg;
		
		@FindBy(id = "Password-error")
		@CacheLookup
		public WebElement PassErrormsg;
		
//--------Login--------------------------------
		@FindBy(xpath = "//a[text()='Log in']")
		@CacheLookup
		public WebElement Login;
		
		@FindBy(xpath = "//button[normalize-space()='Log in']")
		@CacheLookup
		public WebElement LoginButton;
		
		
		@FindBy(xpath = "//li[normalize-space()='No customer account found']")
		@CacheLookup
		public WebElement NoUserFound;
		
		@FindBy(xpath = "//li[normalize-space()='The credentials provided are incorrect']")
		@CacheLookup
		public WebElement WrongCred;
		
		@FindBy(xpath = "//img[@alt='nopCommerce demo store']")
		@CacheLookup
		public WebElement HomeLogo;
		
//-----------------ForgotPassword-------------------	
		@FindBy(xpath = "//a[normalize-space()='Forgot password?']")
		@CacheLookup
		public WebElement ForgotPassword ;
		
		@FindBy(xpath = "//button[normalize-space()='Recover']")
		@CacheLookup
		public WebElement RecoverButton ;
		
		@FindBy(xpath = "//div[@class='result']")
		@CacheLookup
		public WebElement Recoverylink ;
		
		@FindBy(xpath = "//div[@class='result']")
		@CacheLookup
		public WebElement emailNotFound ;
		
		//Search Product
		
		@FindBy(xpath = "//div[@class='no-result']")
		@CacheLookup
		public WebElement noProductFound ;
		
		@FindBy(xpath="//h1[normalize-space()='Lenovo Thinkpad X1 Carbon Laptop']")
		@CacheLookup
		public WebElement LenovoPC1;
		
		
	// To initialize the Page objects WebElements in defined in this Cart Page class, create the constructor of Cart Page

		public void CartPageObjects() {           
		        PageFactory.initElements(driver, this);
		}

}
