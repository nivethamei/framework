package com.Vtiger.Pomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "lastname")
	private WebElement contactnametextfeild;
	
	@FindBy(name = "support_start_date")
	private WebElement supportstartdate;
	
	@FindBy(name = "support_end_date")
	private WebElement supportenddate;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement contactorgicon;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebutton;

	
	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> checkbox;
	
  	public WebElement getContactnametextfeild() {
		return contactnametextfeild;
	}

	public WebElement getSupportstartdate() {
		return supportstartdate;
	}

	public WebElement getSupportenddate() {
		return supportenddate;
	}

	public WebElement getContactorgicon() {
		return contactorgicon;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public List<WebElement> getCheckbox() {
		return checkbox;
	}
	


}
