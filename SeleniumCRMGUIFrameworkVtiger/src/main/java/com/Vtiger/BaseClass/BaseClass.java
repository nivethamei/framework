package com.Vtiger.BaseClass;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.Vtiger.Pomclass.HomePage;
import com.Vtiger.Pomclass.LoginPage;
import com.Vtiger.generic.databaseutility.DatabaseUtility;
import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.fileutility.PropertyFileUtility;
import com.Vtiger.generic.webdriverutility.JavaUtility;
import com.Vtiger.generic.webdriverutility.UtilityClassObjects;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class BaseClass {

	public DatabaseUtility dutil = new DatabaseUtility();
	public WebdriverUtility wutil = new WebdriverUtility();
	public PropertyFileUtility putil = new PropertyFileUtility();

	public WebDriver driver = null;
	public static WebDriver sdriver;


	@BeforeSuite(groups = { "smoke", "regression" })
	public void createBSmethod() throws SQLException {
		System.out.println("connect to database");
		dutil.getConnection();
	}
	

	//@BeforeTest(groups = { "smoke", "regression" })
	@Parameters("browser")
	@org.testng.annotations.BeforeClass(groups = { "smoke", "regression" })
	public void createBCmethod(String bname) throws IOException {

		String BROWSER =bname;// putil.getDataFromPropertyFile("browser");

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
		sdriver = driver;
		UtilityClassObjects.setDriver(driver);

	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void createBMmethod() throws IOException {

		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");
		String URL = putil.getDataFromPropertyFile("url");
		driver.get(URL);
		System.out.println("navigated to url");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernametextfeild().sendKeys(USERNAME);
		lp.getPasswordtesxtfeild().sendKeys(PASSWORD);
		lp.getLoginbutton().click();
		System.out.println("login successfull");

	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void createAMmethod() {

		HomePage hp = new HomePage(driver);
		hp.getAdministrationicon().click();
		hp.getLogoutbutton().click();
		System.out.println("closing the browser");

	}

	@org.testng.annotations.AfterClass(groups = { "smoke", "regression" })
	public void createACmethod() {
		driver.quit();
		System.out.println("browser closed sucessfully");

	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void createAsmethod() throws SQLException {
		System.out.println("disconnect to database");
		dutil.closeConnection();


	}

}
