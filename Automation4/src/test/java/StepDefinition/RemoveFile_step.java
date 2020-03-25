package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Pages.RemoveFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RemoveFile_step {
	WebDriver driver;
	RemoveFile rf = new RemoveFile(driver); // Creating instance of the RemoveFile class using the constructor

	@Given("^the url is opened in the website$")
	public void the_url_is_opened_in_the_website() {
		rf.url("chrome"); // Calling the url method
		rf.loginpage(); // Calling the login page method
	}

	@When("^the more is mouse overed and click on the File Upload$")
	public void the_more_is_mouse_overed_and_click_on_the_File_Upload() throws InterruptedException, IOException {
		rf.fileup();
		rf.screenshot("Screenshots//afteruploading.png");
		
	}

	@When("^File is Selected$")
	public void file_is_Selected() throws IOException, InterruptedException {
		rf.filerem(); // Calling the filerem method
		rf.screenshot("Screenshots//afterremoving.png"); // Calling the screenshot method
	}

	@Then("^remove the uploaded file$")
	public void remove_the_uploaded_file() {
		rf.quit(); // Calling the quit method
	}

}
