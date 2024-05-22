package contacttestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
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
		
		//click on contact link
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact icon
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//enter the lastname
		driver.findElement(By.name("lastname")).sendKeys(CONTACTNAME);
		
		//enter the today date [startdate]
		java.util.Date dateobj=new java.util.Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String STARTDATE = sim.format(dateobj);
		System.out.println(STARTDATE);
		driver.findElement(By.name("support_start_date")).sendKeys(STARTDATE);
		
		//enter the end date
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String ENDDATE= sim.format(cal.getTime());
		System.out.println(ENDDATE);
		 WebElement ele = driver.findElement(By.name("support_end_date"));
		 ele.clear();
		 ele.sendKeys(ENDDATE);
		 System.out.println(ele.getText());
		
		
		//click on save
		driver.findElement(By.name("button")).click();
		
		//verify the startdate
		String actstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstartdate.equals(STARTDATE))
		{
			System.out.println(STARTDATE+" information is verified====>pass");
		}
		else
		{
			System.out.println(STARTDATE+" information is not verified====>fail");
		}
		
		//verify the end date
		String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		System.out.println(actenddate);
	   if(actenddate.equals(ENDDATE))
	   {
		System.out.println(ENDDATE+" information is verified====>pass");
	    }
	    else
		{
			System.out.println(ENDDATE+" information is not verified====>fail");
	    }
	
		//logout
	     Thread.sleep(3000);
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	     driver.findElement(By.linkText("Sign Out")).click();
         driver.close();
		
		
		

	}

}
