package pages;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	@SuppressWarnings("deprecation")
	public void browserDriverConnection() {
		String projectPath = System.getProperty("user.dir");
		try (InputStream input = new FileInputStream(projectPath + "/src/test/resources/data.properties")) {
			Properties prop = new Properties();

			prop.load(input);

			String browser = prop.getProperty("browser");

			switch (browser) {

			case "chrome":
				System.getProperty("webdriver.chrome.driver",
						projectPath + "src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.getProperty("webdriver.gecko.driver",
						projectPath + "src/test/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			default:
				System.getProperty("webdriver.chrome.driver",
						projectPath + "src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void sendKeys(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	public void clear(By locator) {
		driver.findElement(locator).clear();
	}

	public void clickElement(WebElement webElement) {
		webElement.click();
	}

	public void clickElement(By locator) {
		driver.findElement(locator).click();
	}

	public Boolean getVisibility(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public Boolean getState(WebElement element) {
		return element.isEnabled();
	}

	public String getPage(String url) {
		driver.get(url);
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.quit();
	}

}
