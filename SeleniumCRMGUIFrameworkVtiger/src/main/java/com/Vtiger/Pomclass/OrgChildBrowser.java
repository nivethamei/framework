package com.Vtiger.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgChildBrowser {
	
	public OrgChildBrowser(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(id = "search_txt")
	private WebElement searchtextfeild;
	
	@FindBy(name = "search")
	private WebElement searchbutton;

	public WebElement getSearchtextfeild() {
		return searchtextfeild;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}
	
	

}
