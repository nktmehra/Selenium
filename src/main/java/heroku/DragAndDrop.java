package heroku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {

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
	public void test() throws InterruptedException, IOException {
		String data= "";
		driver.findElement(By.cssSelector("a[href^='/drag']")).click();
		WebElement source = driver.findElement(By.xpath("//div[@id='column-a']"));
		System.out.println(source.getAttribute("id"));
		WebElement target = driver.findElement(By.xpath("//div[@id='column-b']"));
		File file = new File("C:\\Users\\Acer\\Documents\\dragDrop");
		Scanner myReader = new Scanner(file);
		while(myReader.hasNextLine()) {
			data=data.concat(myReader.nextLine()+"\n");
		}
		myReader.close();
		

		JavascriptExecutor js = (JavascriptExecutor)driver; 
   		js.executeScript(data+"$('#"+source.getAttribute("id")+"').simulateDragDrop({dropTarget:'#"+target.getAttribute("id")+"'});");
		Thread.sleep(3000);
	}
	
		
	
}
