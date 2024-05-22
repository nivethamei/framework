package com.Vtiger.ContactTest;

import java.io.FileInputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.BaseClass.BaseClass;
import com.Vtiger.Pomclass.ContactPage;
import com.Vtiger.Pomclass.CreateContactPage;
import com.Vtiger.Pomclass.HomePage;
import com.Vtiger.Pomclass.InformationContactPage;
import com.Vtiger.Pomclass.LoginPage;
import com.Vtiger.generic.fileutility.ExcelFileUtility;
import com.Vtiger.generic.fileutility.PropertyFileUtility;
import com.Vtiger.generic.webdriverutility.JavaUtility;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;

public class CreateContactWithSupportDateTest extends BaseClass {

	@Test(groups = "smoke")
	public void createContactWithSupportDateTest()throws Throwable {
		
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		
		// To Read Data From Excel file
		String CONTACTNAME = eutil.getDataFromExcelfile("contact", 7, 3) + jutil.getRandomNumber();

		// click on contact link
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();

		// click on create contact icon
	    ContactPage cp=new ContactPage(driver);
	    cp.getCreatecontacticon().click();

		// enter the lastname
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getContactnametextfeild().sendKeys(CONTACTNAME);

		// enter the today date [startdate]
		String STARTDATE = jutil.getSystemDateYYYYMMDD();
		System.out.println(STARTDATE);
		String ENDDATE = jutil.getRequiredDate(30);
		System.out.println(ENDDATE);

		ccp.getSupportstartdate().clear();
		ccp.getSupportstartdate().sendKeys(STARTDATE);
		ccp.getSupportenddate().clear();
		ccp.getSupportenddate().sendKeys(ENDDATE);

		// click on save
		Thread.sleep(2000);
		ccp.getSavebutton().click();

		// verify the startdate
		InformationContactPage iop=new InformationContactPage(driver);
		String actstartdate = iop.getSupportdateverify().getText();
		Assert.assertEquals(STARTDATE, actstartdate);

		// verify the end date
		String actenddate = iop.getSupportenddate().getText();
		System.out.println(actenddate);
		Assert.assertEquals(ENDDATE, actenddate);
		
	}

}
