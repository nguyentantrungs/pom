package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		format = {"pretty", "json:target/cucumber.json", "html:target/cucumber-pretty"},
		glue= {"stepDefinition"}

		)



public class testrunner  {

}