package heroku;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRemoveElements {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Acer\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	@Test
	public void test() {
		driver.findElement(By.cssSelector("a[href^='/add']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement addBtn = driver.findElement(By.xpath("//button[text()='Add Element']"));
		js.executeScript("addElement()");
		js.executeScript("addElement()");
		WebElement delBtn = driver.findElement(By.cssSelector("div[id='elements']>button:nth-child(2)"));
		delBtn.click();
		System.out.println(delBtn.isDisplayed());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
