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
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.fileutility.PropertyFileUtility;

public class CreateOrgWithIndustryAndTypeDropdown {

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
		        String ORGNAME = eutil.getDataFromExcelfile("org",4, 2)+RANDOM;
		        String INDUSTRY =eutil.getDataFromExcelfile("org", 4, 3);
		        String TYPE = eutil.getDataFromExcelfile("org", 4, 4);
		        
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
				
				//select the industry dropdown
				WebElement industry = driver.findElement(By.name("industry"));
				Select sel1=new Select(industry);
				sel1.selectByVisibleText(INDUSTRY);
				
				//Select the type dropdown
				WebElement type = driver.findElement(By.name("accounttype"));
				Select sel2=new Select(type);
				sel2.selectByVisibleText(TYPE);
				
				//click on save
				driver.findElement(By.name("button")).click();
				
				//verification of industry dropdown
				String actindustry = driver.findElement(By.id("dtlview_Industry")).getText();
				if(actindustry.equals(INDUSTRY))
				{
					System.out.println(INDUSTRY+" Is displayed====>PASS");
					
				}
				else
				{
					System.out.println(INDUSTRY+" Is not displayed====>FAIL");
					
				}
				String acttype = driver.findElement(By.id("dtlview_Type")).getText();
				if(acttype.equals(TYPE))
				{
					System.out.println(TYPE+" Is displayed====>PASS");
					
				}
				else
				{
					System.out.println(TYPE+" Is not displayed====>FAIL");
					
				}
				
				
				//logout
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				driver.findElement(By.linkText("Sign Out")).click();
				
			   driver.close();


		        
		        
				
				

	}

}
