package runnner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		
		features = ".//Features/Herokuapp.feature",
		glue = "stepDefinitions",
		dryRun=false,
		monochrome=true,
		//strict=true,
		plugin = { "pretty", "json:target/cucumber.json" }
		)
public class TestRunn {

}
