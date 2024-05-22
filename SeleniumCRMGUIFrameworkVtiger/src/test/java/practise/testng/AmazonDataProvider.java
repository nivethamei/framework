package practise.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;

public class AmazonDataProvider {
	
	@Test(dataProvider = "getContactData")
	public void getPriceOfIPhone(String brandname,String productname) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.flipkart.com");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(brandname,Keys.ENTER);
		
		String price = driver.findElement(By.xpath("(//a[text()='"+productname+"'])[1]/../a[3]/div/div[1]")).getText();
		System.out.println(price);
	}
	@DataProvider
	public Object [][] getContactData() throws Throwable{
		ExcelFileUtility eutil=new ExcelFileUtility();
          int rowcount = eutil.getRowCount("product");
          
        Object[][]objarr=new Object[rowcount][2];
        for(int i=0;i<rowcount;i++)
        {
		objarr[i][0]=eutil.getDataFromExcelfile("product", i+1, 0);
		objarr[i][1]=eutil.getDataFromExcelfile("product", i+1, 1);
        }
		
		
		
		return objarr;
	}

}
