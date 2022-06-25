package com.bottomline.com.amazontests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bottomline.com.pages.HomePage;
import com.bottomline.com.pages.ResultsPage;
import com.bottomline.com.utils.BaseClass;
import com.bottomline.com.utils.JavaScriptUtils;

public class Amazontest extends BaseClass{

	List<String> matchingBooks = new ArrayList<String>();
	
	HomePage hp;
	ResultsPage rp;
	
	@BeforeMethod
	public void setUp(){
		IntialSetup();
		driver.get(BASEURL);
		JavaScriptUtils.setUp(driver);
		JavaScriptUtils.CheckifPageIsLoaded(driver);
		actions = new Actions(driver);
		hp=new HomePage(driver);
		hp=hp.intialize();
	}
	


	@Test
	public void HapptPathTest() {
		
		String bookName = "the Lost World by Arthur Conan Doyle";
		
		String largestBookName=hp.performSearchOperation(bookName)
				.printTotalNoOfBooks(bookName)
				.checkEnglishCheckBox()
				.printTotalNoOfBooks(bookName)
				.getAllBooksTitleName(bookName)
				.printMatchingBooks()
				.getLargestMatchingBook();
				

		Assert.assertTrue(largestBookName.length() < 70,
				"Book length is more than 70 characters i.e " + largestBookName.length());
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
