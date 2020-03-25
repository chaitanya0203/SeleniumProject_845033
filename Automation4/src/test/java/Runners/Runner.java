package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resorces/feature/testcase.feature", // Giving the address of feature file
		plugin = { "html:target/cucumber-html-report" }, // Extracting the reports in target folder
		tags = { "@TC_01", "@TC_02", "@TC_03", "@TC_04", "@TC_05" }, // Giving the tags of the scenarios to run
		glue = { "StepDefinition" }, // To store the methods generated from feature file
		monochrome = true // Output for the Cucumber test are readable
)
public class Runner {

}
