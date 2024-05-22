package com.Vtiger.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement Organizationlink;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contactlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement administrationicon;
    
    @FindBy(linkText = "Sign Out")
    private WebElement logoutbutton;
    
    

	
	public WebElement getOrganizationlink() {
		return Organizationlink;
	}

	public WebElement getContactlink() {
		return Contactlink;
	}
	public WebElement getAdministrationicon() {
		return administrationicon;
	}

	public WebElement getLogoutbutton() {
		return logoutbutton;
	}
	
	@FindBy(linkText = "Products")
	private WebElement productlink;




	public WebElement getProductlink() {
		return productlink;
	}

	

}
