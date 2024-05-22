package com.Vtiger.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Vtiger.BaseClass.BaseClass;

public class WebdriverUtility {
	/**
	 * This method is for implicit wait
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	/**
	 * This method is for explicit wait
	 * @param driver
	 * @param element
	 */
	
	public void ExplicitWait(WebDriver driver,WebElement element)
	{
	      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	      wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is for switch to child window
	 * @param driver
	 * @param data
	 */
	
	public void switchToWindowOnTitle(WebDriver driver,String data) {
		Set<String> childwindow = driver.getWindowHandles();
		for(String window:childwindow)
		{
			driver.switchTo().window(window);
			String actualtitle = driver.getTitle();
			if(actualtitle.contains(data))
			{
				break;
			}
		}
	}
	/**
	 * This method will perform switch to frame based on index
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrameIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will perform switch to frame based on id
	 * @param driver
	 * @param id
	 */
	public void switchToFrameId(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * This method will perform switch to frame based on name
	 * @param driver
	 * @param name
	 */
	
	public void switchToFrameName(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}
	/**
	 * This method will perform switch to frame based on webelement
	 * @param driver
	 * @param element
	 */
	public void switchToFrameName(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
		
	}
	/**
	 * This method will perform switch back to main page from frame
	 * @param driver
	 * @param element
	 */
	public void switchToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will perform switch back to immediate parent from frame
	 * @param driver
	 * @param element
	 */
	
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will perform switch to alert popup and accept
	 * @param driver
	 * @param element
	 */
	public void switchToAlertAccept(WebDriver driver) {
	     driver.switchTo().alert().accept();
	}
	/**
	 * This method will perform switch to alert and dismiss
	 * @param driver
	 * @param element
	 */
	
	public void switchToAlertDismiss(WebDriver driver) {
	     driver.switchTo().alert().dismiss();
	     
	}
	/**
	 * This method will perform the dropdown by visibletext
	 * @param driver
	 * @param element
	 */
	
	public void toHandleDropdownVisibleText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method will perform the dropdown by value
	 * @param driver
	 * @param element
	 */
	public void toHandleDropdownValue(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByValue(text);
	}
	/**
	 * This method will perform the dropdown by index
	 * @param driver
	 * @param element
	 */
	public void toHandleDropdownIndex(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will perform the double click
	 * @param driver
	 * @param element
	 */
	public void  doubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method will perform move to element
	 * @param driver
	 * @param element
	 */
	public void  moveToElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method will perform the right click
	 * @param driver
	 * @param element
	 */
	
	public void  RightClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method will perform the right click
	 * @param driver
	 * @param element
	 */
	
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public String toTakeScreenshot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./screenshots/"+screenshotname+".jpeg");
		FileHandler.copy(temp, src);
		return src.getAbsolutePath();
	}
	
    
	


}
