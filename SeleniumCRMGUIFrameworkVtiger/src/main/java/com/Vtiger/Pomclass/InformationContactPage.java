package com.Vtiger.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationContactPage {

	public InformationContactPage(WebDriver driver) {
        PageFactory.initElements(driver,this);	
	}
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement contactnameverify;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
    private WebElement contactheadermsgverify;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportdateverify;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement supportenddate;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement contactorgname;
	
	

    
	public WebElement getContactnameverify() {
		return contactnameverify;
	}

	public WebElement getContactheadermsgverify() {
		return contactheadermsgverify;
	}

	public WebElement getSupportdateverify() {
		return supportdateverify;
	}

	public WebElement getSupportenddate() {
		return supportenddate;
	}

	public WebElement getContactorgname() {
		return contactorgname;
	}

	
    

}
