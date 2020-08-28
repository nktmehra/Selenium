package fillo;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderDemo extends FilloDemo{
	
	@DataProvider(name="TestData")
	public Object[][] data(Method m) throws Exception{
		return new Object[][] {
			{
			readTestDataHashMap(m.getName())
			}
		};
		
	}
}
