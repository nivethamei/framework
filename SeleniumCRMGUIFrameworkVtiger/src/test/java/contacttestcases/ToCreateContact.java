package contacttestcases;

import java.io.FileInputStream;
import java.io.IOException;
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

public class ToCreateContact {

	public static void main(String[] args) throws IOException, InterruptedException {
		//To Read Data From Property File
				FileInputStream fis=new FileInputStream("C:\\Users\\Nivetha Shanmugam\\Desktop\\commondata1.properties");
		        Properties prop=new Properties();
		        prop.load(fis);
		        String URL = prop.getProperty("url");
		        String BROWSER = prop.getProperty("browser");
		        String USERNAME= prop.getProperty("username");
		        String PASSWORD= prop.getProperty("password");
		        
		      //To generate random number
		        Random r=new Random();
		        int RANDOM = r.nextInt(1000);
		        
		       //To Read Data From Excel file
		       FileInputStream fis1=new FileInputStream("C:\\Users\\Nivetha Shanmugam\\Desktop\\TestScriptData.xlsx");
		        Workbook wb = WorkbookFactory.create(fis1);
		        String CONTACTNAME = wb.getSheet("contact").getRow(1).getCell(2).toString()+RANDOM;
		    

		        
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
				driver.findElement(By.linkText("Contacts")).click();
				
				//click on create organisation icon
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//enter the lastname
				driver.findElement(By.name("lastname")).sendKeys(CONTACTNAME);
				
			    //click on save
				driver.findElement(By.name("button")).click();
				
				//verfify the lastname
				String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
				if(actlastname.equals(CONTACTNAME))
				{
					System.out.println(CONTACTNAME+"is created successfully");
				}
				else
				{
					System.out.println(CONTACTNAME+"Is not created");
				}
				
				//verify the header msg
				 String headermsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				 if(headermsg.contains(CONTACTNAME))
				 {
					 System.out.println(CONTACTNAME+"Is saved successfully");
				 }
				 else
				 {
					 System.out.println(CONTACTNAME+"Is not saved successfully");
				 }
				 

					//logout
				 Thread.sleep(3000);
					driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
					driver.findElement(By.linkText("Sign Out")).click();
					
				   driver.close();
				
				
				

	}

}
