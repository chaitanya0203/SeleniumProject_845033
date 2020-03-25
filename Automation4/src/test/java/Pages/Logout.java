package Pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Logout {
	WebDriver driver; // All the locators are declared here
	By MyAccount = By.xpath("//*[@id=\"menu-item-50\"]/a");
	By UserEmail = By.id("username");
	By Password = By.id("password");
	By Login = By.name("login");
	By Logout = By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a");

	public Logout(WebDriver driver) { // Constructor to make use of the methods from stepdefinition
		this.driver = driver;
	}

	public void url(String browser) { // Method to launch the browser
		try {
			if (browser == "chrome") {
				System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser == "firefox") {
				System.setProperty("webdriver.gecko.driver", "Drivers//geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser == "ie") {
				System.setProperty("webdriver.internetexplorer.driver", "Drivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		} catch (WebDriverException e) {
			System.out.println("Please give valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void loginpage() { // Method to launch the URL
		driver.get("http://practice.automationtesting.in/");

	}

	public void MyAccount() { // Method to click on MyAccount tab
		driver.findElement(MyAccount).click();
	}

	public void logindetails() { // Method to login into the account

		driver.findElement(UserEmail).sendKeys("koradabhanu@gmail.com");
		driver.findElement(Password).sendKeys("koradabhanu");
	}

	public void login() { // Method to click on login
		driver.findElement(Login).click();
	}

	public void logout() { // Method to click on Logout
		driver.findElement(Logout).click();
	}

	public void screenshot(String path) throws IOException { // Methofd to take a screenshot
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path));
	}

	public void quit() { // Method to close browser
		driver.close();
	}
}
