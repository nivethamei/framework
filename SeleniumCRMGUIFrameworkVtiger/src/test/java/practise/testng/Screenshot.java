package practise.testng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		
		//step1:create object for event firing web driver to take a screenshot
	    EventFiringWebDriver efd=new EventFiringWebDriver(driver);
	    
	    //step2:call the screenshot method
	    File temp = efd.getScreenshotAs(OutputType.FILE);
	    
	    //Step3:store it in permanent location
	    File src=new File("./screenshots/flipkart2.jpeg");
	    
	    //step4:call the file utils class of copy file method
	    FileUtils.copyFile(temp, src);

	    
	  
	}

}
