package contacttestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrg {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		//To Read Data From Property File
				FileInputStream fis=new FileInputStream("./ConfAppData/commondata1.properties");
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
		       FileInputStream fis1=new FileInputStream("./testdata/TestScriptData.xlsx");
		        Workbook wb = WorkbookFactory.create(fis1);
		        String CONTACTNAME = wb.getSheet("contact").getRow(1).getCell(2).toString()+RANDOM;
		        String ORGNAME = wb.getSheet("contact").getRow(7).getCell(2).toString()+RANDOM;
		         wb.close();

		        
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
				
				
				//click on save
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				
				//click on contact link
				Thread.sleep(3000);
				driver.findElement(By.linkText("Contacts")).click();
				
				//click on create contact icon
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//enter the lastname
				driver.findElement(By.name("lastname")).sendKeys(CONTACTNAME);
				
				String parentid = driver.getWindowHandle();
				
				//click on org icon
				driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
				
				//Switch to child browser
				Set<String> childwindow = driver.getWindowHandles();
				childwindow.remove(parentid);
				for(String window:childwindow)
				{
					driver.switchTo().window(window);
					String actualtitle = driver.getTitle();
					if(actualtitle.contains("Accounts&action"))
					{
						break;
					}
				}
				
				//select the org name
				driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
			    driver.findElement(By.name("search")).click();
			    driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
	
	            //switch to parent window		
			    driver.switchTo().window(parentid);
			    
		    	//save the data
			    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			    
			   //verify the orgname
			    String actorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			    if(actorgname.contains(ORGNAME))
			    {
			    	System.out.println(ORGNAME+" is verfied");
			    }
			    else
			    {
			    	System.out.println(ORGNAME+" is not verified");
			    }
			    
			    //verify the lastname
			    String headermsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			    if(headermsg.contains(CONTACTNAME))
			    {
			    	System.out.println(CONTACTNAME+"is verified=====>");
			    }
			    else
			    {
			    	System.out.println(CONTACTNAME+"is not verified====>");
			    }
			   
	        //  logout action
		        Thread.sleep(3000);
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			    driver.findElement(By.linkText("Sign Out")).click();
			    driver.close();
			
			

	}

}
