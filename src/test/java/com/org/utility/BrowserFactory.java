package com.org.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	
	public static WebDriver startApplication(WebDriver driver, String BrowserName, String appURL) {
		if (BrowserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (BrowserName.equalsIgnoreCase("firefox")) {
           driver = new FirefoxDriver();
        } else if (BrowserName.equalsIgnoreCase("edge")) {
           driver = new EdgeDriver();
        }
        else {
        	System.out.println("Browser not supported for automation");
        }
        driver.manage().window().maximize();
        driver.get(appURL);
       
        return driver;
		
	}
	
	
	public static void quitBrowser(WebDriver driver){
		
		driver.quit();
	}
}
