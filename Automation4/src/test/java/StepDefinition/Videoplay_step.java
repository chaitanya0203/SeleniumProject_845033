package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Pages.Videoplay;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Videoplay_step {
	WebDriver driver;
	Videoplay vp = new Videoplay(driver); // Creating the instance for the class Videoplay

	@Given("^the url is opened in the browser$")
	public void the_url_is_opened_in_the_browser() {
		vp.url("chrome"); // Calling the url method
		vp.loginpage(); // Calling the loginpage method
	}

	@When("^the url is launched click on demosite$")
	public void the_url_is_launched_click_on_demosite() throws InterruptedException {
		vp.vplay(); // Calling the vplay method
	}

	@When("^mouseover to the video and click on vimeo$")
	public void mouseover_to_the_video_and_click_on_vimeo() throws IOException {
		vp.screenshot("Screenshots//play.png"); // Calling the screenshot method
	}

	@When("^play the video$")
	public void play_the_video() {

	}

	@Then("^tap on escape key and quit$")
	public void tap_on_escape_key_and_quit() {
		vp.quit(); // Calling the quit method
	}
}
