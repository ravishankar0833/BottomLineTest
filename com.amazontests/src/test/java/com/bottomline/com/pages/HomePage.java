package com.bottomline.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageObject {
	
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@id='nav-signin-tooltip']/*/span[@class='nav-action-inner' and contains(text(),'Sign in')]")
	WebElement signInButton;
	
	@FindBy(xpath="//span[@class='a-button-text'][1]")
	WebElement declineButton;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTextBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(xpath ="//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']")
	WebElement selectCategory;
	
	@FindBy(xpath="//span[@class='icp-nav-flag icp-nav-flag-us']/parent::span/span[2]")
	WebElement select_lang;
	
	
	public HomePage intialize() {
		/*try {
			this.signInButton.click();
			new Actions(driver).moveToElement(signInButton).click().perform();
		}catch(Exception e) {
			
		}*/
		try {
			new Actions(driver).moveToElement(declineButton).click().perform();		
		}catch(Exception e) {
			
		}		
		
		return this;
		
	}
	
	public ResultsPage performSearchOperation(String name) {

		this.searchTextBox.click();
		searchTextBox.sendKeys(name);
		Select categorySelect= new Select(selectCategory);
		categorySelect.selectByVisibleText("Books");
		searchButton.click();
		return new ResultsPage(this.driver);
	}

}
