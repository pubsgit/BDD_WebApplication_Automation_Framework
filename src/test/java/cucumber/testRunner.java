package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features", // Features to run
		glue = "pageobjects"  //Package Name
		)
public class testRunner extends AbstractTestNGCucumberTests {

}
