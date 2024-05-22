package com.Vtiger.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationOrganizationPage {
	
	public InformationOrganizationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgheadermsg;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgtextfeildverify;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phonenumverify;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryverify;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeverify;
	
	

	public WebElement getOrgheadermsg() {
		return orgheadermsg;
	}

	public WebElement getOrgtextfeildverify() {
		return orgtextfeildverify;
	}

	
	public WebElement getPhonenumverify() {
		return phonenumverify;
	}

	public WebElement getIndustryverify() {
		return industryverify;
	}

	public WebElement getTypeverify() {
		return typeverify;
	}
	
	
	

}
