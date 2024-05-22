package createorgtestcase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.fileutility.PropertyFileUtility;

public class CreateOrgWithPhonenumber {

	public static void main(String[] args) throws Throwable {
		//To Read Data From Property File
		PropertyFileUtility putil=new PropertyFileUtility();
		
        String URL =putil.getDataFromPropertyFile("url");
        String BROWSER =putil.getDataFromPropertyFile("browser");
        String USERNAME=putil.getDataFromPropertyFile("username");
        String PASSWORD=putil.getDataFromPropertyFile("password");
        
        
      //To generate random number
        Random r=new Random();
        int RANDOM = r.nextInt(1000);
        
       //To Read Data From Excel file
        ExcelFileUtility eutil=new ExcelFileUtility();
        String ORGNAME = eutil.getDataFromExcelfile("org",7, 2)+RANDOM;
        String PHONENUM = eutil.getDataFromExcelfile("org",7, 3);
        
         WebDriver driver=null;
        if(BROWSER.equals("chrome")) {
        	driver=new ChromeDriver();
        }
        else if(BROWSER.equals("edge"))
        {
        	driver=new EdgeDriver();
        }
	    else if(BROWSER.equals("firefox"))
	    {
	    	driver=new FirefoxDriver();
	    }
        
        System.out.println("browser launched successfully");
		driver.manage().window().maximize();
		System.out.println("browser maximized successfully");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
		System.out.println("navigated to url");
		//Log in
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("login successfull");
		
		//click ion organisation link
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organisation icon
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//enter the org name
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//enter the mob num
		driver.findElement(By.id("phone")).sendKeys(PHONENUM);
		
		//click on save
		driver.findElement(By.name("button")).click();
		
		//verify the phonenum
		String actphnum = driver.findElement(By.id("dtlview_Phone")).getText();
		if(actphnum.equals(PHONENUM))
		{
			System.out.println(PHONENUM+"Is displayed successfully");
		}
		else
		{
			System.out.println(PHONENUM+"Is not displayed ");
		}
		
		
		
		//logout
		Thread.sleep(2000);
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(logout).click().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	   driver.close();


        
        
		
		



	}

}
