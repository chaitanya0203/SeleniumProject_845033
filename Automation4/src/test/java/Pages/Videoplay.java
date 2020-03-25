package Pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Videoplay { // All locators are declared
	WebDriver driver;
	By Demo = By.xpath("//a[text()='Demo Site']");
	By Video = By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[7]/a");
	By Vimeo = By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[7]/ul/li[2]/a");
	By Frame = By.xpath("//*[@id=\"foo\"]");
	By Play = By.xpath("//*[@id=\"player\"]/div[3]");
	By maximize = By.xpath("//*[@id=\"player\"]/div[7]/div[3]/div/button[3]/div[1]/svg");

	public Videoplay(WebDriver driver) { // Constructor to call the declared methods from this broswer
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

	public void vplay() throws InterruptedException // Method to play the sample video in demosite tab
	{
		driver.findElement(Demo).click();
		Actions act = new Actions(driver);
		WebElement we = driver.findElement(Video);
		WebElement we1 = driver.findElement(Vimeo);
		act.moveToElement(we);
		act.moveToElement(we1).click().build().perform();
		WebElement ele = driver.findElement(Frame);
		driver.switchTo().frame(ele);
		driver.findElement(Play).click();
		act.sendKeys(Keys.SPACE);
		driver.findElement(maximize).click();
		Thread.sleep(5000);
		act.sendKeys(Keys.ESCAPE);

	}

	public void screenshot(String path) throws IOException { // Method to take a screenshot
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path));
	}

	public void quit() { // Method to close the browser
		driver.close();
	}
}
