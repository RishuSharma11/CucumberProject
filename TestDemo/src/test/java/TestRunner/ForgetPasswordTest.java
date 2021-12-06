package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = {"src/test/resources/AppFeatures/ForgetPassword.feature"},
			glue = {"StepDefination"},
			//tags = "@tag3",
			//plugin = {"pretty"},
//					//"json:target/MyReport/report.json",
//					//"junit:target/MyReport/report.xml"}
			monochrome = true, //Alignment in the output is done
//			dryRun = true
			publish = true
			
			)
public class ForgetPasswordTest extends AbstractTestNGCucumberTests {
	
}
