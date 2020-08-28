package heroku;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxes {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Acer\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href^='/checkboxes']")).click();
		List<WebElement> checkboxesList = driver.findElements(By.cssSelector("input[type='checkbox']"));
		Thread.sleep(3000);
		System.out.println("No of checkboxes are "+checkboxesList.size());
		for(WebElement e : checkboxesList) {
			if(e.isSelected()) {
				e.click();
			}
			Thread.sleep(3000);
			e.click();
			Thread.sleep(3000);
			e.click();
		}
	}

}
