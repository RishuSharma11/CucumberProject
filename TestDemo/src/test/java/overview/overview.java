package overview;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class overview
{ 
	List<String> listelem = new ArrayList<String>();

	WebDriver driver ;
	@BeforeTest
	public void main() {
		System.setProperty("webdriver.chrome.driver","C:\\CromeDriverFile\\chromedriver.exe");	
		driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	
	// @AfterTest
	// public void close() {
	// driver.close();
	}
	@Test(priority=1)
	public void URL()throws InterruptedException {
		String title = driver.getTitle();
		String actTitle = "nopCommerce demo store";
		Assert.assertEquals(title,actTitle);
	}
	@Test(enabled=false)
	public void registerName() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		//WebElement gender =driver.findElement(By.cssSelector(".female") );
		// gender.click();
		WebElement name = driver.findElement(By.cssSelector("#FirstName"));
		String actName = "Teju";
		name.sendKeys(actName);
		String getName = name.getAttribute("value");
		Assert.assertEquals(actName,getName);
	}
	@Test(enabled=false)
	public void gender() {
		WebElement gender =driver.findElement(By.cssSelector(".female") );
		gender.click();
		
		Assert.assertEquals(gender.isSelected(),false);
	}
	@Test(enabled=false)
	public void email()
	{
		WebElement email = driver.findElement(By.cssSelector("input[name^=Email]"));
		String actEmail ="tt@gmail.com";
		email.sendKeys("tt@gmail.com");
		String getEmail = email.getAttribute("value");
		Assert.assertEquals(actEmail,getEmail);
		email.clear();
		email.sendKeys("xyz");
		driver.findElement(By.cssSelector("input[name=Company]")).click();
		String actError = driver.findElement(By.cssSelector("#Email-error")).getText();
		String emailError ="Wrong email";
		Assert.assertEquals(actError,emailError);
		
	}
	@Test(enabled=false)
	public void password() {
		driver.findElement(By.cssSelector("#Password") ).sendKeys("1334");
		driver.findElement(By.cssSelector("#ConfirmPassword") ).click();
		String PassError = driver.findElement(By.cssSelector("span[id='Password-error'] ul li")).getText();
		String ActualPassError = "must have at least 6 characters";
		Assert.assertEquals(PassError,ActualPassError);
	}
	@Test(enabled=false)
	public void loginDetails() throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
		WebElement email = driver.findElement(By.cssSelector("#Email"));
		String actEmail = "xyz";
		email.sendKeys(actEmail);
		driver.findElement(By.cssSelector("#Password")).click();
		String actError = driver.findElement(By.cssSelector("#Email-error")).getText();
		String emailError ="Wrong email";
		Assert.assertEquals(actError,emailError);
		email.clear();
		email.sendKeys("tt@gmail.com");
		WebElement password = driver.findElement(By.cssSelector("#Password"));
		password.sendKeys("123");
		driver.findElement(By.cssSelector("button[class='button-1 login-button']")).click();
		String invalidPassErr = driver.findElement(By.cssSelector("div[class='message-error validation-summary-errors'] ul li")).getText();
		String actinvalidPassErr = "The credentials provided are incorrect";
		Assert.assertEquals(invalidPassErr,actinvalidPassErr);
		Thread.sleep(2000);
		email.clear();
		//password.clear();
		email.sendKeys("t@gmail.com");
		driver.findElement(By.cssSelector("#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("button[class='button-1 login-button']")).click();
		Thread.sleep(2000);
		String invalidUserErr = driver.findElement(By.cssSelector("div[class='message-error validation-summary-errors'] ul li")).getText();
		String actinvalidUserErr = "No customer account found";
		Assert.assertEquals(invalidUserErr,actinvalidUserErr);
	}
	@Test(enabled=false)
	public void registration() throws InterruptedException {
		

		driver.findElement(By.xpath("//a[text()='Register']")).click();
		


		WebElement name = driver.findElement(By.cssSelector("#FirstName"));
		String actName = "Teju";
		name.sendKeys(actName);
		String getName = name.getAttribute("value");	
		System.out.println(getName);
		driver.findElement(By.cssSelector(".female") ).click();
		driver.findElement(By.cssSelector("input[name=Company]")).sendKeys("IVLGlobal");
		
		driver.findElement(By.cssSelector("input[name*=LastName]")).sendKeys("KM");
		driver.findElement(By.cssSelector("input[name^=Email]")).sendKeys("tt@gmail.com");
		driver.findElement(By.cssSelector("input[name$=Password]")).sendKeys("1234567") ;
		driver.findElement(By.cssSelector("#ConfirmPassword") ).sendKeys("1234567");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("select[name=DateOfBirthDay]>option:nth-of-type(13)") ).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("select[name=DateOfBirthMonth]>option:nth-of-type(9)") ).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("select[name=DateOfBirthYear]>option:nth-of-type(89)") ).click();
		driver.findElement(By.cssSelector("#register-button") ).click();
		String ErrorMsg = driver.findElement(By.cssSelector(" div[class='message-error validation-summary-errors'] ul li") ).getText();
		String actErrorMsg ="The specified email already exists";
		Assert.assertEquals(ErrorMsg,actErrorMsg);
		driver.navigate().back();
		
	}

	@Test(priority=1)
	public void addItemsCart() throws InterruptedException {
		driver.findElement(By.cssSelector(".master-wrapper-page") ).click();
		driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']")).click();
		driver.findElement(By.xpath("//input[@id='product_attribute_3_6']")).click();
		driver.findElement(By.cssSelector("select[name=product_attribute_2]>option:nth-of-type(2)") ).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
		//WebElement ele = driver.findElement(By.xpath("//button[@id='add-to-wishlist-button-1']"));
		//Actions act= new Actions(driver);
		//act.click(ele);
		driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")).click();
		driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Fahrenheit 451 by Ray Bradbury')]")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-37']")).click();
		driver.findElement(By.cssSelector("#topcartlink")).click();
		
		
		
		int row = driver.findElements(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td")).size();
		System.out.println("Row count ::: " + row);
		
		
		
		


		int column = driver.findElements(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr")).size();
		System.out.println("Column count ::: " + column);
		for(int i=1; i<column+1; i++)
		{for(int j=0; j<row; j++) {
			if(j==0 || j==5) {
				List<WebElement> elem = driver.findElements(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr["+ i +"]/td"));
				String elem1 = elem.get(j).getText();
				
				listelem.add(elem1);
				System.out.println(elem1);
			}


		}
		}
		String elem1Name ="COMP_CUST";
		String elem1Price = "$1,315.00";
		String elem2Name = "FR_451_RB";
		String elem2Price = "$27.00";
		Assert.assertEquals(elem1Name,listelem.get(0));
		Assert.assertEquals(elem1Price,listelem.get(1));
		Assert.assertEquals(elem2Name,listelem.get(2));
		Assert.assertEquals(elem2Price,listelem.get(3));
		

	}
}