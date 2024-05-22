package practise.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.BaseClass.BaseClass;

@Listeners(com.Vtiger.Listeners.ListenersImpementation.class)
public class ListenersClass extends BaseClass {
	
	@Test(retryAnalyzer = practise.testng.RetryAnalyzerClass.class)
	public void InvoiceTest() {
		System.out.println("Invoicetest started");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	      String acttitle = driver.getTitle();
	      Assert.assertTrue(acttitle.contains("home"));
	      System.out.println("invoicetest end");
	}

	
	
}
