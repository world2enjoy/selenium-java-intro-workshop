package com.automationpractice.firstdemo;

// Java File

// Selenium
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Test Class
 * @author nickg
 *
 */
public class FirstTest {

	// 
	public WebDriver driver;
	
	/**
	 * First Test Case verifies that user that enters the correct username and password 
	 * receives the expected Successful Alert.
	 * @throws InterruptedException 
	 */
	@Test
	public void firstTest() throws InterruptedException {

		// Optional, if not specified, WebDriver will search your path for driver exe.
		System.setProperty("webdriver.gecko.driver", "C:/Users/Nick/WebDriver/Gecko/geckodriver.exe");
		
		// Create a new Chrome WebDriver (browser) object and maximize the browser window (optional)
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();

		// Navigate to the website address.
		driver.get("http://automationpractice.com/index.php");

		/*
		 * Login
		 */
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_query_top")));

		// click MY ACCOUNT, then click Login...
        searchInput.sendKeys("Skinny Jeans");
        searchInput.submit();  // simulate clicking Enter button

        // Wait for the alert to display an assert that there are no results
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-warning")));
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Page title doesn't match.", "Search - My Store", pageTitle);

        // let's assert that there are no results by checking the results counter and the text of the alert box.
        String alertText = driver.findElement(By.className("alert-warning")).getText();

        Assert.assertTrue("Results were found when expected not to.", //
                driver.findElement(By.className("heading-counter")).getText().contains("results have been found."));
        Assert.assertTrue("Text doesn't match.", alertText.contains("No results were found for your search"));

	}
	
}
