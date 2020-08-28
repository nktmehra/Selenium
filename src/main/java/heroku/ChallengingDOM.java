package heroku;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChallengingDOM {

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
		driver.findElement(By.cssSelector("a[href^='/challenging']")).click();
		WebElement buttonOne= driver.findElement(By.xpath("//a[contains(@id,'0287e2e5257d')][1]"));
		buttonOne.click();
		Thread.sleep(3000);
		WebElement ReInitialisebuttonOne= driver.findElement(By.xpath("//a[contains(@id,'0287e2e5257d')][1]"));
		ReInitialisebuttonOne.click();
		WebElement tableColumn = driver.findElement(By.cssSelector("div[class='large-10 columns'] tbody>tr:nth-child(3)>td:nth-child(5)"));
		System.out.println(tableColumn.getText());
	}
}
