package com.Vtiger.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Vtiger.BaseClass.BaseClass;
import com.Vtiger.generic.webdriverutility.WebdriverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.Vtiger.generic.webdriverutility.JavaUtility;
import com.Vtiger.generic.webdriverutility.UtilityClassObjects;

public class ListenersImpementation implements ITestListener,ISuiteListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public   ExtentTest test;
    WebdriverUtility wutil=new WebdriverUtility();
    JavaUtility jutil=new JavaUtility();
    
	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" start");
		test = report.createTest(methodname);
		UtilityClassObjects.setTest(test);
		test.log(Status.INFO, methodname+" ====>START");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" success");
		test.log(Status.PASS, methodname+" ====>SUCCESS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--Failed");
		
		String screenshotname = methodname+" "+jutil.toGetSystemDateAndTime();
		try {
			String path = wutil.toTakeScreenshot(BaseClass.sdriver, screenshotname);
			test.addScreenCaptureFromPath(path);
			test.log(Status.FAIL, "--failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		test.log(Status.FAIL, methodname+" ====>FAILURE");
		
		
		
		
		
	}

	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReport/test"+jutil.toGetSystemDateAndTime()+".html");
		spark.config().setDocumentTitle("CRM app result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows");
		report.setSystemInfo("browser", "chrome");

		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" skipped");
		test.log(Status.SKIP, methodname+" ====>skipped");
		
		
	}

	
	
	
	
	

}
