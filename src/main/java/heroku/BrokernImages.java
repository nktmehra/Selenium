package heroku;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokernImages {
	
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
	public void test() throws ClientProtocolException, IOException {
		int count = 0;
		driver.findElement(By.cssSelector("a[href^='/broken']")).click();
		List<WebElement> imageList = driver.findElements(By.cssSelector(".example>img"));
		
		System.out.println("Total no of images "+ imageList.size());
		for(WebElement e: imageList) {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(e.getAttribute("src"));
			HttpResponse response = client.execute(request);
			int code = response.getStatusLine().getStatusCode();
			Predicate<Integer> p = i->(code !=200);
			if(p.test(code)) {
				count++;
			}
		}
		
		System.out.println("No of invalid images are - "+ count);
	}

}
