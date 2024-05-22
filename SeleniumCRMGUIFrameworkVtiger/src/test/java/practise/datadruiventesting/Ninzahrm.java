package practise.datadruiventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class Ninzahrm {

	public static void main(String[] args) throws SQLException, InterruptedException {
		
		//create a project in GuI
		String PROJECTNAME = "fb80";
		Boolean flag=false;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://106.51.90.215:8084/");
        driver.findElement(By.id("username")).sendKeys("rmgyantra");
        driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        driver.findElement(By.linkText("Projects")).click();
        driver.findElement(By.xpath("//span[text()='Create Project']")).click();
        driver.findElement(By.name("projectName")).sendKeys(PROJECTNAME);
        Thread.sleep(2000);
        //driver.findElement(By.name("teamSize")).sendKeys("4");
        driver.findElement(By.name("createdBy")).sendKeys("aks");
        Thread.sleep(2000);
        WebElement statusdropdown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
        Select select=new Select(statusdropdown);
        select.selectByIndex(1);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        
        //Verify the project is added in backend [database]
        
        //To load And register the driver
        Driver driverref=new Driver();
        DriverManager.registerDriver(driverref);
        
        //to connect to database
        Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
        
        //to get a statement
        Statement stat = conn.createStatement();
        
        //to execute the query and get the result
        ResultSet res = stat.executeQuery("select * from project");
        while(res.next())
        {
        	String actualprojectname = res.getString(4);
        	if(PROJECTNAME.equals(actualprojectname))
        	{
        		flag=true;
        		System.out.println(PROJECTNAME+"is prosent");
        	}
        }
        if(flag==false) {
        	System.out.println(PROJECTNAME+"is not prsent");
        }
        conn.close();
        
        
        
        
        
	}

}
