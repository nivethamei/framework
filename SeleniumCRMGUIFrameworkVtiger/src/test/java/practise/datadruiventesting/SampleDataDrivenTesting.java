package practise.datadruiventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Nivetha Shanmugam\\Desktop\\commondata1.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		System.out.println(prop.getProperty("password"));
		
		

	}

}
