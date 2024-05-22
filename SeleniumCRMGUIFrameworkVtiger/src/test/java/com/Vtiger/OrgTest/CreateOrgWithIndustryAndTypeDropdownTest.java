package com.Vtiger.OrgTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.BaseClass.BaseClass;
import com.Vtiger.Pomclass.CreateOrganisationPage;
import com.Vtiger.Pomclass.HomePage;
import com.Vtiger.Pomclass.InformationOrganizationPage;
import com.Vtiger.Pomclass.OrganizationPage;
import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.webdriverutility.JavaUtility;

public class CreateOrgWithIndustryAndTypeDropdownTest extends BaseClass {

	@Test(groups = "smoke")
	public void orgWithIndustryAndTypeDropdown() throws Throwable {
		// To Read Data From Property File

		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		String ORGNAME = eutil.getDataFromExcelfile("org", 4, 2) + jutil.getRandomNumber();
		String INDUSTRY = eutil.getDataFromExcelfile("org", 4, 3);
		String TYPE = eutil.getDataFromExcelfile("org", 4, 4);

		// click icon organisation link
		HomePage hp = new HomePage(driver);
		hp.getOrganizationlink().click();

		// click on create organisation icon
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationicon().click();

		// enter the org name
		CreateOrganisationPage cop = new CreateOrganisationPage(driver);
		cop.getLastnametextfeild().sendKeys(ORGNAME);

		// select the industry dropdown
		WebElement industry = cop.getIndustrydropdown();
		wutil.toHandleDropdownVisibleText(industry, INDUSTRY);

		// Select the type dropdown
		WebElement type = cop.getTypedropdown();
		wutil.toHandleDropdownVisibleText(type, TYPE);

		// click on save
		cop.getSavebutton().click();

		// verification of industry dropdown
		InformationOrganizationPage iop = new InformationOrganizationPage(driver);
		String actindustry = iop.getIndustryverify().getText();
		Assert.assertTrue(actindustry.equals(INDUSTRY));
		String acttype = iop.getTypeverify().getText();
		Assert.assertTrue(acttype.equals(TYPE));
		
	}

}
