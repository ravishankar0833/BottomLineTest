package com.bottomline.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	
	WebDriver driver;
	
    public PageObject(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
