package heroku;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGrid {


		WebDriver driver;
		

		@BeforeTest
		public void setUp() throws MalformedURLException {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			ChromeOptions option = new ChromeOptions();
			option.merge(cap);
			driver = new RemoteWebDriver(new URL("http://192.168.1.15:4444/wd/hub"),option);
			driver.get("https://www.amazon.in");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		@Test
		public void test() {
			driver.get("https://www.amazon.in");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 11");
		}
		
		@AfterTest
		public void tearDown() {
			driver.quit();
		}
}
