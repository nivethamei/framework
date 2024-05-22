package practise.datadruiventesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.Pomclass.ContactPage;
import com.Vtiger.Pomclass.CreateContactPage;
import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.fileutility.PropertyFileUtility;
import com.Vtiger.generic.webdriverutility.JavaUtility;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;

public class ToHandleCheckBoxUsingPom {

	public static void main(String[] args) throws Throwable {
		// To Read Data From Property File
		PropertyFileUtility putil = new PropertyFileUtility();
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebdriverUtility wutil = new WebdriverUtility();

		String URL = putil.getDataFromPropertyFile("url");
		String BROWSER = putil.getDataFromPropertyFile("browser");
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");

		// To Read Data From Excel file
		String CONTACTNAME = eutil.getDataFromExcelfile("contact", 7, 3) + jutil.getRandomNumber();

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		System.out.println("browser launched successfully");
		wutil.toMaximize(driver);
		System.out.println("browser maximized successfully");

		wutil.implicitWait(driver);
		driver.get(URL);
		System.out.println("navigated to url");
		// Log in
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("login successfull");

		// click ion organisation link
		driver.findElement(By.linkText("Contacts")).click();

		// click on create organisation icon
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		CreateContactPage ccp = new CreateContactPage(driver);
		// ccp.getCheckbox().clear();
		for (WebElement e : ccp.getCheckbox()) {
			String notify = driver.findElement(By.name("notify_owner")).getText();
			if(notify.contains("notify")) {
			e.click();
			}
		}

	}

}
