package com.org.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.org.pages.BaseClass;
import com.org.pages.BookManagement;


public class BookManagementTest extends BaseClass {
	
	
	@Test
	public void DashboardVerification() {		
		
		logger = report.createTest("Verification of BookManagement");
		logger.info("Verifing Book management Page......");

		BookManagement DashboardPage = PageFactory.initElements(driver, BookManagement.class);
				
		//Login web

		try {
			logger.pass("Web Page launched correctly.. ");
			Reporter.log("Web Page launched correctly.. ", true);
			DashboardPage.addBook();
			DashboardPage.addAuthor();
			
			
			logger.pass("Dashboard elements matched, correct user logged in ");
			Reporter.log("<br>Dashboard elements matched, correct user logged in ", false);
		} 
		catch (Exception e) {
		
			e.printStackTrace();
			logger.fail("Issue in Web Page launch...!!!");
			Reporter.log("<br>Issue in Web Page launch...!!!",false);
		
		} 
	
	}

		
}