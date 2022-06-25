package com.bottomline.com.pages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bottomline.com.utils.JavaScriptUtils;

public class ResultsPage extends PageObject {

	
	static List<String> matchingBooks = new ArrayList<String>();

	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='a-size-base a-color-base' and contains(text(),'English')]")
	WebElement CheckBox_English;

	@FindBy(xpath = "//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
	WebElement NextPageButton;

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> booksTitle;

	public ResultsPage printTotalNoOfBooks(String bookName) {
		String noOfBooks = driver
				.findElement(By.xpath("//span[contains(text(),'\"" + bookName + "\"')]/parent::div/span[1]")).getText();

		System.out.println(noOfBooks.substring(noOfBooks.lastIndexOf("of") + 2, noOfBooks.length() - 12).trim());

		return this;
	}
	

	public ResultsPage checkEnglishCheckBox() {
		JavaScriptUtils.ScrollToVisibleWebElement(driver, CheckBox_English);
		this.CheckBox_English.click();
		return this;
	}

	public ResultsPage getAllBooksTitleName(String name) {

		while (true) {
			getMatchingBooks(booksTitle, name);

			try {
				
				JavaScriptUtils.ScrollToVisibleWebElement(driver, NextPageButton);

				NextPageButton.click();

			} catch(Exception e) {
				System.out.println("End of the page");
				break;
			}

		}
		
		return this;

	}

	private static void getMatchingBooks(List<WebElement> booksTitle, String bookName) {
		for (WebElement book : booksTitle) {
			String title = book.getText();

			if (title.toLowerCase().contains(bookName.toLowerCase())) {

				matchingBooks.add(title);

			}

		}
	}
	
	public ResultsPage printMatchingBooks() {
		System.out.println("Total number of Books found are " + matchingBooks.size());

		matchingBooks.forEach(v -> System.out.println(v));
		return this;
	}
	
	public String getLargestMatchingBook() {
		return matchingBooks.stream().max(Comparator.comparingInt(String::length)).get();
	}

}
