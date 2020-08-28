package heroku;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Yatan {
	public WebDriver driver;
	
	
	@BeforeTest
	public  void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Acer\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println(driver);
		Dimension d = new Dimension(500, 500);
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public  void tearDown() {
		driver.quit();
	}
	
	@Test()
	public void CheckBoxDemo() throws InterruptedException {
		System.out.println("This is a Checkbox Demo");
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
		String actual = driver.findElement(By.xpath("//div[@id='txtAge']")).getText();
		Assert.assertEquals(actual, "Success - Check box is checked");
		driver.findElement(By.xpath("//input[@id='check1']")).click();
		String string = driver.findElement(By.xpath("//input[@id='check1']")).getAttribute("value");
		System.out.println(string);
		if (string.contains("Uncheck All")) {
			driver.findElement(By.xpath("//input[@id='check1']")).click();
			System.out.println("All Checkboxes Clicked");
		}
	}

	@Test()
	public void RadioButtons() {
		String sex = "Male";
		String ageGroup = "5 - 15";
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		driver.findElement(
				By.xpath("//div[@class='panel-body']//div//label[@class='radio-inline'][contains(text(),'Male')]"))
				.click();
		driver.findElement(By.xpath("//label[contains(text(),'5 to 15')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Get values')]")).click();

		String values = driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();
		System.out.println(values);
		if ((values.contains(sex)) && (values.contains(ageGroup))) {
			System.out.println("Its working as Expected");
		}
		Assert.assertEquals(true, (values.contains(sex)) && (values.contains(ageGroup)), "Issue with Assert Function");
	}
}
