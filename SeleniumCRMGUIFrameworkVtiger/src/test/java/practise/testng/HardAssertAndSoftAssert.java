package practise.testng;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.BaseClass.BaseClass;

public class HardAssertAndSoftAssert extends BaseClass {
	
	@Test
	public void VerifyHomePage(Method mtd) {
		System.out.println(mtd.getName()+" start");
		String expectedhome="Home1";
		String actualhome = driver.findElement(By.partialLinkText("Home")).getText();
		Assert.assertEquals(actualhome, expectedhome);
		System.out.println(mtd.getName()+"end");
	}
		
		
		@Test
		public void verifyHomePageLogo(Method mtd){
			System.out.println(mtd.getName()+" start");
			boolean expectedlogo = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
			Assert.assertTrue(expectedlogo);
			System.out.println(mtd.getName()+"end");
		}
	}


