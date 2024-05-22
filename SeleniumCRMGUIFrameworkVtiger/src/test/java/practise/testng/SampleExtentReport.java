package practise.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

@Listeners(com.Vtiger.Listeners.ListenersImpementation.class)
public class SampleExtentReport  {
	ExtentReports report;
	ExtentTest test;
	@Test
	public void toCreateContact() {
		//test = report.createTest("toCreateContact");
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigated to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("hfdc")) {
			test.log(Status.PASS,"contact is created");
		}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
		test.log(Status.INFO,"contact end");
		report.flush();
	}
	
	@Test
	public void toCreateOrg() {
		 test = report.createTest("toCreateOrg");
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigated to org page");
		test.log(Status.INFO,"create org");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"org is created");
		}
		else {
			test.log(Status.FAIL,"org is not created");
		}
		test.log(Status.INFO,"org end");
		report.flush();
		
	}
}
