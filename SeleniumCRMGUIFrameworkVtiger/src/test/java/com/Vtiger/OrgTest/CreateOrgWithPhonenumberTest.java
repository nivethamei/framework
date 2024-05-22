package com.Vtiger.OrgTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Vtiger.BaseClass.BaseClass;
import com.Vtiger.Pomclass.CreateOrganisationPage;
import com.Vtiger.Pomclass.HomePage;
import com.Vtiger.Pomclass.InformationOrganizationPage;
import com.Vtiger.Pomclass.LoginPage;
import com.Vtiger.Pomclass.OrganizationPage;
import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.fileutility.PropertyFileUtility;
import com.Vtiger.generic.webdriverutility.JavaUtility;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;

public class CreateOrgWithPhonenumberTest extends BaseClass {

	@Test(groups = "smoke")
	public void createOrgWithPhoneNumber() throws Throwable {

		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();

		// To Read Data From Excel file
		String ORGNAME = eutil.getDataFromExcelfile("org", 7, 2) + jutil.getRandomNumber();
		String PHONENUM = eutil.getDataFromExcelfile("org", 7, 3);

		// click ion organisation link
		HomePage hp = new HomePage(driver);
		hp.getOrganizationlink().click();

		// click on create organisation icon
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationicon().click();

		// enter the org name
		CreateOrganisationPage cop = new CreateOrganisationPage(driver);
		cop.getLastnametextfeild().sendKeys(ORGNAME);

		// enter the mob num
		cop.getPhonenumtextfeild().sendKeys(PHONENUM);

		// click on save
		cop.getSavebutton().click();

		// verify the phonenum
		InformationOrganizationPage iop = new InformationOrganizationPage(driver);
		String actphnum = iop.getPhonenumverify().getText();
		Assert.assertTrue(actphnum.equals(PHONENUM));

	}

}
