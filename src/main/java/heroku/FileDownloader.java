package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownloader {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Acer\\Downloads\\Selenium\\geckodriver.exe");
			String downloadFilepath = "C:\\Test\\";
			
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.helperApps.alwaysAsk.force", false);
			options.addPreference("browser.download.dir", downloadFilepath); 
			options.addPreference("browser.download.defaultFolder",downloadFilepath); 
			options.addPreference("browser.download.manager.showWhenStarting", false);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk","multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
			
			driver = new FirefoxDriver(options);
			driver.get("https://the-internet.herokuapp.com/download");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test() {
			driver.findElement(By.cssSelector("#content > div > a:nth-child(4)")).click();
	}
}