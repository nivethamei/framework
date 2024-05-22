package com.Vtiger.OrgTest;


import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
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
import com.Vtiger.generic.webdriverutility.UtilityClassObjects;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

@Listeners(com.Vtiger.Listeners.ListenersImpementation.class)

public class ToCreateOrgTest extends BaseClass {
	
	
   @Test(groups = "regression")
	public void CreateOrgTest() throws Throwable {

	   //test.log(Status.INFO, "read data from excel file");
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();

		// To Read Data From Excel file
		//test.log(Status.INFO, "read data from excel file");
		String ORGNAME = eutil.getDataFromExcelfile("org", 1, 2) + jutil.getRandomNumber();
		
		// click ion organisation link
		HomePage hp = new HomePage(driver);
		hp.getOrganizationlink().click();
	     UtilityClassObjects.getTest().log(Status.INFO, "clicked on organisation link");

		// click on create organisation icon
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationicon().click();
		UtilityClassObjects.getTest().log(Status.INFO, " successfully clicked on create org icon");

		// enter the org name
		CreateOrganisationPage cop = new CreateOrganisationPage(driver);
		cop.getLastnametextfeild().sendKeys(ORGNAME);
		UtilityClassObjects.getTest().log(Status.INFO, "org name is done succesffully");

		// click on save
		cop.getSavebutton().click();

		// verification of header msg
		InformationOrganizationPage iop = new InformationOrganizationPage(driver);
		String title = iop.getOrgheadermsg().getText();
		UtilityClassObjects.getTest().log(Status.INFO, "verification of header org name done successfully");
		Assert.assertTrue(title.contains(ORGNAME));
		//org.testng.Assert.fail();

		// verification of orgname
		String actorgname = iop.getOrgtextfeildverify().getText();
		Assert.assertEquals(ORGNAME, actorgname);
		UtilityClassObjects.getTest().log(Status.INFO, "verification of  org name done successfully");

	}

}
