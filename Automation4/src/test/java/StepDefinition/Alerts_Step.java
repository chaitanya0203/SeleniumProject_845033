package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Pages.Alerts;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Alerts_Step {
	WebDriver driver;
	Alerts st = new Alerts(driver); // Creating a variable for the Alerts class to use the declared methods

	@Given("^Opens url in the browser$")
	public void opens_url_in_the_browser() {
		st.url("chrome"); // Calling the URL method

	}

	@When("^automation site is opens$")
	public void automation_site_is_opens() { // Calling the LoginPage Method
		st.loginpage();
	}

	@Then("^Click on SwitchTo and alerts$")
	public void click_on_SwitchTo_and_alerts() {
		st.alertoperation(); // Calling the alertoperation method

	}

	@Then("^get the alert text$")
	public void get_the_alert_text() throws InterruptedException, IOException {
		st.gettext(); // Calling the getext method
		st.quit(); // Calling the quit method

	}

}
