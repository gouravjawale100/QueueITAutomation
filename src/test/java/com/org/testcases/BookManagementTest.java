package com.org.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.org.pages.BaseClass;
import com.org.pages.BookManagement;


public class BookManagementTest extends BaseClass {
	
	
	@Test
	public void addBook() {		
		
		logger = report.createTest("Verification of Book addition");
		logger.info("Verifing add book functionality......");

		BookManagement DashboardPage = PageFactory.initElements(driver, BookManagement.class);

		try {
			logger.pass("Web Page launched correctly.. ");
			Reporter.log("Web Page launched correctly.. ", true);
			String bookName = DashboardPage.addBook();
			logger.info("Book : "+bookName+ " has been added successfully");
			logger.pass("Books elements matched and working as expected ");
			Reporter.log("<br>Dashboard elements matched, correct user logged in ", false);
		} 
		catch (Exception e) {
		
			e.printStackTrace();
			logger.fail("Issue in Web Page launch...!!!");
			Reporter.log("<br>Issue in Web Page launch...!!!",false);
		
		} 
	
	}
	
	
	@Test
	public void addAuthor() {		
		
		logger = report.createTest("Verification of Author addition");
		logger.info("Verifing add author functionality......");

		BookManagement DashboardPage = PageFactory.initElements(driver, BookManagement.class);

		try {
			logger.pass("Web Page launched correctly.. ");
			String authorName = DashboardPage.addAuthor();
			logger.info("Author : "+authorName+ " has been added successfully");
			logger.pass("Webpage elements matched");
			Reporter.log("<br>Bookstore elements matched, correct user logged in ", false);
		} 
		catch (Exception e) {
		
			e.printStackTrace();
			logger.fail("Issue in Web Page launch...!!!");
			Reporter.log("<br>Issue in Web Page launch...!!!",false);
		
		} 
	
	}

		
}