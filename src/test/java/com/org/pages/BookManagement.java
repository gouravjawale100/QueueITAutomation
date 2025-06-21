package com.org.pages;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
		//Input Data Excel Sheet Name
		String ExcelSheet = "BookManagement";
		
		String ExpectedBrowserTitle = ExcelRead.getExcelCellData(ExcelSheet, 0, 1);
		String ExpectedBrowserUrl = ExcelRead.getExcelCellData(ExcelSheet, 1, 1);

		Assert.assertEquals(driver.getTitle(), ExpectedBrowserTitle);
		Assert.assertEquals(driver.getCurrentUrl(), ExpectedBrowserUrl);
		
		bookName.sendKeys(ExcelRead.getExcelCellData(ExcelSheet, 2, 1));
		bookDescription.sendKeys(ExcelRead.getExcelCellData(ExcelSheet, 2, 2));		
		bookPrice.sendKeys(ExcelRead.getExcelCellData(ExcelSheet, 2, 3));
		addBookButton.click();
		
		return ExcelRead.getExcelCellData(ExcelSheet, 2, 1);

	
	}
	
	public String addAuthor() throws EncryptedDocumentException, IOException 
	{
		//Input Data Excel Sheet Name
		String ExcelSheet = "BookManagement";
		
		String ExpectedBrowserTitle = ExcelRead.getExcelCellData(ExcelSheet, 0, 1);
		String ExpectedBrowserUrl = ExcelRead.getExcelCellData(ExcelSheet, 1, 1);

		Assert.assertEquals(driver.getTitle(), ExpectedBrowserTitle);
		Assert.assertEquals(driver.getCurrentUrl(), ExpectedBrowserUrl);
		
		authorName.sendKeys(ExcelRead.getExcelCellData(ExcelSheet, 2, 4));
		dateOfBirth.sendKeys("27-12-1999");		
		addAuthorButton.click();
		
		return ExcelRead.getExcelCellData(ExcelSheet, 2, 4);

	
	}
	
}
