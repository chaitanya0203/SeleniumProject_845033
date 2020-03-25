package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Pages.Login;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_step {
	WebDriver driver;
	Login lg = new Login(driver); // Creating instance of the Logout class using the constructor

	@Given("^open the url$")
	public void open_the_url() {
		// lg.url("chrome"); // Calling the url method
	}

	@When("^url is launched login to the application$")
	public void url_is_launched_login_to_the_application() throws IOException {

		// lg.loginpage(); // Calling the loginpage
		// lg.MyAccount(); // Calling the MyAccount method

		for (int i = 1; i <= 4; i++) {
			lg.url("chrome");
			lg.loginpage();
			lg.MyAccount();
			lg.logindetails(i);
			lg.login();
			lg.screenshot("Screenshots//login" + i + ".png");
			// lg.logout();
			lg.quit();
		}

	}

	@When("^enters the email and password and click on login$")
	public void enters_the_email_and_password_and_click_on_login() {
		// lg.logindetails(); // Calling the logindetails method
		// lg.login(); // Calling the login method
	}

	@Then("^click on logout$")
	public void click_on_logout() throws IOException {
		// lg.logout(); // Calling the logout method
		// lg.screenshot("Screenshots//logout.png"); // Calling the screenshot method
		// lg.quit(); // Calling the quit method
	}

}
