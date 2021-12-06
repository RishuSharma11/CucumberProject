package UtilClasses;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	// Define the variables globally, make it Public here so that these can be used in TestBase as well as child classes
	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver initializeDriver() throws IOException {
		
		// Read the properties defined in the Config.properties file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties");
		
		//FileInputStream fis = new FileInputStream("D:\\IVL_Selenium@2019\\SeleniumFramework\\src\\test\\resource\\config\\config.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();

		} 
		
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		
		else if (browserName == "IE") {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
/* 
	Create an object of EventFiringWebDriver at Global level - public static EventFiringWebDriver say as: event_driver
	event_driver = new EventFiringWebDriver(driver);
	Then, Create an object of WebEventListener class to register with EventFiringWebDriver class
	event_Listener = new WebEventListener();
	event_driver.register(event_Listener);
	driver = event_driver;
*/
		
/* 
	We can define the pageLoadTimeout and implicitlyWait here as well, but in case wait time increases in future, so we need to update code here. 
	Another approach will be define the wait inside the TestUtil class and use here as below, make the changes in TestUtil class if required. 
*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public static WebDriver Teardown(){
		driver.quit();
		return driver;
		
	}

}
