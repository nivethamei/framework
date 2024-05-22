package practise.datadruiventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToCreateOrganistion {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Nivetha Shanmugam\\Desktop\\commondata1.properties");
		Properties prop=new Properties();
		prop.load(fis);
	
		
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME =prop.getProperty("username");
		String PASSWORD =prop.getProperty("password");
		
		//To Read Data From Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\Nivetha Shanmugam\\eclipse-workspace\\SeleniumCRMGUIFramework\\testdata\\TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		String ORGNAME = workbook.getSheet("org").getRow(1).getCell(2).toString();
		
		WebDriver driver=null;
		
		if(BROWSER.equals("chrome"))
		{
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
		else
		{
			driver=new ChromeDriver();
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
		
		//click ion organisation link
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organisation icon
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//enter the org name
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		
		//click on save
		driver.findElement(By.name("button")).click();
		
		//verification 
		String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(title);
		
	//logout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	driver.close();


	}

}
