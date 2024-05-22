package com.Vtiger.Pomclass;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.webdriverutility.WebdriverUtility;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
         PageFactory.initElements(driver,this);	
	}
	
	@FindBy(name="user_name")
	private WebElement usernametextfeild;
	
	@FindBy(name="user_password")
	private WebElement passwordtextfeild;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;

	public WebElement getUsernametextfeild() {
		return usernametextfeild;
	}

	public WebElement getPasswordtesxtfeild() {
		return passwordtextfeild;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	public void loginToApp(String username,String password)
	{
		usernametextfeild.sendKeys(username);
		passwordtextfeild.sendKeys(password);
		loginbutton.click();
	}
	
}
