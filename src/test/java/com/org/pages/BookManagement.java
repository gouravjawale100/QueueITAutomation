package com.org.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.org.utility.ConfigDataProvider;
import com.org.utility.ExcelReader;

public class BookManagement {
	WebDriver driver;
	ExcelReader ExcelRead = new ExcelReader();

	public BookManagement(WebDriver ldriver) 
	{
		
	this.driver = ldriver;	
	}
	
	@FindBy(xpath = "//input[@placeholder='Name']") WebElement bookName;
	@FindBy(xpath = "//input[@placeholder='Description']") WebElement bookDescription;
	@FindBy(xpath = "//input[@placeholder='Price']") WebElement bookPrice;
	@FindBy(xpath = "//button[text()='Add Book']") WebElement addBookButton;
	@FindBy(xpath = "(//input[@placeholder='Name'])[2]") WebElement authorName;
	@FindBy(xpath = "//button[text()='Add Author']") WebElement addAuthorButton;
	@FindBy(xpath = "//input[@placeholder='Birth Date']") WebElement dateOfBirth;

	
	public String addBook() throws EncryptedDocumentException, IOException 
	{
		String ExpectedBrowserTitle = ConfigDataProvider.getDataFromProp("ExpectedTitle");
		String ExpectedBrowserUrl = ConfigDataProvider.getDataFromProp("qaURL");

		Assert.assertEquals(driver.getTitle(), ExpectedBrowserTitle);
		Assert.assertEquals(driver.getCurrentUrl(), ExpectedBrowserUrl);
		
		bookName.sendKeys(ConfigDataProvider.getDataFromProp("Bookname"));
		bookDescription.sendKeys(ConfigDataProvider.getDataFromProp("BookDesc"));		
		bookPrice.sendKeys(ConfigDataProvider.getDataFromProp("price"));
		addBookButton.click();
		
		return ConfigDataProvider.getDataFromProp("Bookname");

	
	}
	
	public String addAuthor() throws EncryptedDocumentException, IOException 
	{
		String ExpectedBrowserTitle = ConfigDataProvider.getDataFromProp("ExpectedTitle");
		String ExpectedBrowserUrl = ConfigDataProvider.getDataFromProp("qaURL");

		Assert.assertEquals(driver.getTitle(), ExpectedBrowserTitle);
		Assert.assertEquals(driver.getCurrentUrl(), ExpectedBrowserUrl);
		
		authorName.sendKeys(ConfigDataProvider.getDataFromProp("Authorname"));
		dateOfBirth.sendKeys("27-12-1999");		
		addAuthorButton.click();
		
		return ConfigDataProvider.getDataFromProp("Authorname");

	
	}
	
}
