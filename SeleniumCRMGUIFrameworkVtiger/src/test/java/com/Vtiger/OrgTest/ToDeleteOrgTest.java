package com.Vtiger.OrgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Vtiger.BaseClass.BaseClass;
import com.Vtiger.Pomclass.CreateOrganisationPage;
import com.Vtiger.Pomclass.HomePage;
import com.Vtiger.Pomclass.LoginPage;
import com.Vtiger.Pomclass.OrganizationPage;
import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.fileutility.PropertyFileUtility;
import com.Vtiger.generic.webdriverutility.JavaUtility;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;

public class ToDeleteOrgTest extends BaseClass {
	@Test(groups = "regression")
	public void DeleteOrgTest() throws Throwable {

		// To Read Data From Property File
//		PropertyFileUtility putil = new PropertyFileUtility();
      	JavaUtility jutil = new JavaUtility();
	    ExcelFileUtility eutil = new ExcelFileUtility();
//		WebdriverUtility wutil = new WebdriverUtility();
//
//		String URL = putil.getDataFromPropertyFile("url");
//		String BROWSER = putil.getDataFromPropertyFile("browser");
//		String USERNAME = putil.getDataFromPropertyFile("username");
//		String PASSWORD = putil.getDataFromPropertyFile("password");

		// To Read Data From Excel file
		String ORGNAME = eutil.getDataFromExcelfile("org", 10, 2) + jutil.getRandomNumber();
		String DROPDOWNORG = eutil.getDataFromExcelfile("org", 10, 3) + jutil.getRandomNumber();

//		WebDriver driver = null;
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else if (BROWSER.equals("firefox")) {
//			driver = new FirefoxDriver();
//		}
//
//		System.out.println("browser launched successfully");
//		wutil.toMaximize(driver);
//		System.out.println("browser maximized successfully");
//
//		wutil.implicitWait(driver);
//		driver.get(URL);
//		System.out.println("navigated to url");
		// Log in
//		LoginPage lp = new LoginPage(driver);
//		lp.getUsernametextfeild().sendKeys(USERNAME);
//		lp.getPasswordtesxtfeild().sendKeys(PASSWORD);
//		lp.getLoginbutton().click();
//		System.out.println("login successfull");

		// click ion organisation link
		HomePage hp = new HomePage(driver);
		hp.getOrganizationlink().click();

		// click on create organisation icon
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationicon().click();

		// enter the org name
		CreateOrganisationPage cop = new CreateOrganisationPage(driver);
		cop.getLastnametextfeild().sendKeys(ORGNAME);

		// click on save
		cop.getSavebutton().click();

		// click on organisation link
		Thread.sleep(3000);
		hp.getOrganizationlink().click();

		//enter the org name to delete
		op.getSearchorg().sendKeys(ORGNAME);
		op.getSearchdropdown().sendKeys(DROPDOWNORG);
		op.getSearchbutton().click();

		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']/../../td[8]//a[text()='del']")).click();
         wutil.switchToAlertAccept(driver);
		Thread.sleep(3000);
		
		
	}
}
