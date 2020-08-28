package fillo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class FilloDemoUsingSelenium extends FilloDemo {

	@Test(dataProvider="TestData",dataProviderClass = DataProviderDemo.class)
	public void test1(HashMap<String,String> testData) {
		System.out.println(testData.get("FirstName"));
		
	}
	
	
	
	
}
