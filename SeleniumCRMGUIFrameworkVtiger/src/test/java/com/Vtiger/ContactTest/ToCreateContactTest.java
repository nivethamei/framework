package com.Vtiger.ContactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.BaseClass.BaseClass;
import com.Vtiger.Listeners.ListenersImpementation;
import com.Vtiger.Pomclass.ContactPage;
import com.Vtiger.Pomclass.CreateContactPage;
import com.Vtiger.Pomclass.HomePage;
import com.Vtiger.Pomclass.InformationContactPage;
import com.Vtiger.Pomclass.LoginPage;
import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.fileutility.PropertyFileUtility;
import com.Vtiger.generic.webdriverutility.JavaUtility;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class ToCreateContactTest extends BaseClass {

	@Test(groups = { "regression","smoke"})
	public void createContact() throws Throwable {
        
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtility jutil = new JavaUtility();

		// To Read Data From Excel file
		String CONTACTNAME = eutil.getDataFromExcelfile("contact", 7, 3) + jutil.getRandomNumber();
       
		// click on contact link
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// click on create contact icon
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontacticon().click();

		// enter the lastname
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getContactnametextfeild().sendKeys(CONTACTNAME);

		// click on save
		ccp.getSavebutton().click();

		// verfify the lastname
		InformationContactPage iop = new InformationContactPage(driver);
		String actlastname = iop.getContactnameverify().getText();
		Assert.assertEquals(CONTACTNAME, actlastname);
		//org.testng.Assert.fail();
		//org.testng.Assert.fail();
		// verify the header msg
		String headermsg = iop.getContactheadermsgverify().getText();
		Assert.assertTrue(headermsg.contains(CONTACTNAME));
	}

}
