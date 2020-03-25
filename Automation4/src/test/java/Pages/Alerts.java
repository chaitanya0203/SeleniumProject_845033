package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Alerts {
	WebDriver driver; // All the locators are given
	By Demosite = By.xpath("//*[@id=\"menu-item-251\"]/a");
	By Switch = By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a");
	By alerts = By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[1]/a");
	By button = By.xpath("//*[@id=\"OKTab\"]/button");

	public Alerts(WebDriver driver) { // Constructor is used to call the methods from the stepdefinitions
		this.driver = driver;
	}

	public void url(String browser) { // Method to launch the browser may be chrome, firefox, ie
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

	public void loginpage() // Method to launch the URL
	{
		driver.get("http://practice.automationtesting.in/");

	}

	public void alertoperation() { // Method to run the alert scenario
		driver.findElement(Demosite).click();
		Actions act = new Actions(driver);
		WebElement we = driver.findElement(Switch);
		act.moveToElement(we);
		WebElement we1 = driver.findElement(alerts);
		act.moveToElement(we1).click().build().perform();
	}

	public void gettext() throws InterruptedException // Method to print the alert message
	{
		driver.findElement(button).click();
		Alert aler = driver.switchTo().alert();
		String msg = aler.getText();
		System.out.println(msg);
		Thread.sleep(3000);
	}

	public void quit() { // Method to close the browser
		driver.close();
	}

}
