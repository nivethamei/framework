package practise.datadruiventesting;

import org.testng.annotations.Test;

public class  ReadRunTimeParameterTest {

	@Test
	public void runtimeparamtertest()
	{
		
		String URL= System.getProperty("url");
		String BROWSER= System.getProperty("browser");
		String USERNAME= System.getProperty("username");
		String PASSWORD= System.getProperty("password");
		System.out.println("data=======>"+URL);
		System.out.println("data=======>"+BROWSER);
		System.out.println("data=======>"+USERNAME);
		System.out.println("data=======>"+PASSWORD);

	}

}
