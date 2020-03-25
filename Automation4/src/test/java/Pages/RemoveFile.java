package Pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class RemoveFile {
	WebDriver driver; // All locators are declared
	By Demo = By.xpath("//a[text()='Demo Site']");
	By More = By.xpath("//a[text()='More']");
	By fileup = By.xpath("//a[text()='File Upload']");
	By Browse = By.xpath("//input[@id='input-4']");
	By Remove = By.xpath("/html/body/section/div[1]/div/div/div[1]/button[1]/span");

	public RemoveFile(WebDriver driver) { // Constructor to call the declared methods from this broswer
		this.driver = driver;
	}

	public void url(String browser) { // Method to launch the specific browser
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

	public void loginpage() { // Method to launch the browser
		driver.get("http://practice.automationtesting.in/");

	}

	public void filerem() throws InterruptedException { // Method to remove the uploaded file
		driver.findElement(Demo).click();
		Actions act = new Actions(driver);
		WebElement we = driver.findElement(More);
		WebElement we1 = driver.findElement(fileup);
		act.moveToElement(we);
		act.moveToElement(we1).click().build().perform();
		driver.findElement(Browse).sendKeys("UploadFiles//Automation3.xlsx");
		Thread.sleep(3000);
		driver.findElement(Remove).click();
		Thread.sleep(5000);
	}

	public void screenshot(String path) throws IOException { // Method to take the screenshot
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path));
	}

	public void quit() { // Method to close the browser
		driver.close();
	}
}
