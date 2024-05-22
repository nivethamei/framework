package com.Vtiger.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationicon;
	
	@FindBy(name = "search_text")
	private WebElement searchorg;
	
	@FindBy(name = "search_field")
	private WebElement searchdropdown;
	
	@FindBy(name = "submit")
	private WebElement searchbutton;
	
	public WebElement getSearchorg() {
		return searchorg;
	}

    public WebElement getSearchdropdown() {
		return searchdropdown;
	}


     public WebElement getSearchbutton() {
		return searchbutton;
	}

     public WebElement getCreateOrganizationicon() {
		return createOrganizationicon;
	}
	
	
}
