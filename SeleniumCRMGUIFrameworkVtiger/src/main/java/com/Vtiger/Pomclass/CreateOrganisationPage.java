package com.Vtiger.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {

	
	public CreateOrganisationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);	
	}
	
	@FindBy(name = "accountname")
	private WebElement lastnametextfeild;
	
	@FindBy(id = "phone")
	private WebElement phonenumtextfeild;
	
	@FindBy(name = "industry")
	private WebElement industrydropdown;
	
	@FindBy(name =  "accounttype")
	private WebElement typedropdown;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebutton;

	public WebElement getLastnametextfeild() {
		return lastnametextfeild;
	}

	public WebElement getPhonenumtextfeild() {
		return phonenumtextfeild;
	}

	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}

	public WebElement getTypedropdown() {
		return typedropdown;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	

}
