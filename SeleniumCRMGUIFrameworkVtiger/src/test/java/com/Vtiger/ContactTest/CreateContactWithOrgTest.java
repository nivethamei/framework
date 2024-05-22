package com.Vtiger.ContactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.BaseClass.BaseClass;
import com.Vtiger.Pomclass.ContactPage;
import com.Vtiger.Pomclass.CreateContactPage;
import com.Vtiger.Pomclass.CreateOrganisationPage;
import com.Vtiger.Pomclass.HomePage;
import com.Vtiger.Pomclass.InformationContactPage;
import com.Vtiger.Pomclass.LoginPage;
import com.Vtiger.Pomclass.OrgChildBrowser;
import com.Vtiger.Pomclass.OrganizationPage;
import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.fileutility.PropertyFileUtility;
import com.Vtiger.generic.webdriverutility.JavaUtility;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;

public class CreateContactWithOrgTest extends BaseClass {

	@Test(groups = "smoke")
	public void createContactWithOrgTest() throws Throwable {
		// To Read Data From Property File

		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();

		// To Read Data From Excel file
		String CONTACTNAME = eutil.getDataFromExcelfile("contact", 7, 3) + jutil.getRandomNumber();
		String ORGNAME = eutil.getDataFromExcelfile("contact", 7, 2) + jutil.getRandomNumber();

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

		// click on contact link
		Thread.sleep(3000);
		hp.getContactlink().click();

		// click on create contact icon
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontacticon().click();

		// enter the lastname
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getContactnametextfeild().sendKeys(CONTACTNAME);

		String parentid = driver.getWindowHandle();

		// click on org icon
		ccp.getContactorgicon().click();

		// Switch to child browser
		wutil.switchToWindowOnTitle(driver, "Accounts&action");

		// select the org name
		OrgChildBrowser ocg = new OrgChildBrowser(driver);
		ocg.getSearchtextfeild().sendKeys(ORGNAME);
		ocg.getSearchbutton().click();
		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();

		// switch to parent window
		driver.switchTo().window(parentid);

		// save the data
		ccp.getSavebutton().click();

		// verify the orgname
		InformationContactPage icp = new InformationContactPage(driver);
		String actorgname = icp.getContactorgname().getText();
		Assert.assertTrue(actorgname.contains(ORGNAME));
		// verify the lastname
		String headermsg = icp.getContactheadermsgverify().getText();
		Assert.assertTrue(headermsg.contains(CONTACTNAME));
		

	}
	
	
	

}
