package com.Vtiger.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement productlink;




	public WebElement getProductlink() {
		return productlink;
	}
	
	@FindBy(name="search")
	private WebElement searchele3;




	public WebElement getSearch() {
		return searchele3;
	}



}
