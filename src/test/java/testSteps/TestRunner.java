package testSteps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/features" },
		glue = { ".testSteps" },  
		plugin = {"pretty",
				"html:target/cucumber-reports"},
		monochrome = true,
		tags= "@AllWebTable")

public class TestRunner {

}
