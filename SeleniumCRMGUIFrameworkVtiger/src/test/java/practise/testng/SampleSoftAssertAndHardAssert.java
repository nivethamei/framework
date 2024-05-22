package practise.testng;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SampleSoftAssertAndHardAssert {
	
	@Test
	public void VerifyHomePage(Method mtd) {
		System.out.println(mtd.getName()+" start");
		SoftAssert sa=new SoftAssert();
		
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertEquals("home", "home");
		System.out.println("step-3");
		System.out.println("step-4");
		sa.assertEquals("vtigerHrm", "vtiger hm");
		//sa.assertAll();
		System.out.println(mtd.getName()+"end");
		sa.assertAll();
	}
		
		
		@Test
		public void verifyHomePageLogo(Method mtd){
			System.out.println(mtd.getName()+" start");
		    Assert.assertTrue(true);
			System.out.println(mtd.getName()+"end");
		}

}
