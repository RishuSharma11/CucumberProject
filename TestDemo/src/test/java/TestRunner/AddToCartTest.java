package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/AppFeatures/AddToCart.feature"},
		glue = {"StepDefination"},
		//tags = "@tag4",
		//plugin = {"pretty"},
//				//"json:target/MyReport/report.json",
//				//"junit:target/MyReport/report.xml"}
		monochrome = true,//Allignment in the output is done
//		dryRun = true
		publish = true
		
		)

public class AddToCartTest extends AbstractTestNGCucumberTests {

}

