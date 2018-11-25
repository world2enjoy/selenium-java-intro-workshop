package com.automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page object for PHP Travels landing.
 * @author nickg
 *
 */
public class Landing {

	public WebDriver driver;
	
	private String baseUrl = "http://automationpractice.com/index.php";

	By pageLogo = By.id("header_logo");
	By searchInput = By.id("search_query_top");
	By searchSubmit = By.name("submit_search");
	By signInButton = By.className("login");

	/**
	 * Default constructor.
	 *
	 * @param driver the webdriver.
	 */
	public Landing(WebDriver driver) {
		this.driver = driver;

	}


	/**
	 * Navigate to a webpage URL.
	 */
	public void goToPage()
	{
		driver.get(baseUrl);

		// driver.findElement(pageLogo).isDisplayed();

	}

	/**
	 * Clicks the sign-in link navigating the user to the sign-in page.
	 *
	 * @return an instance of Landing.
	 */
	public Landing goToLogin()
	{
		driver.findElement(signInButton).click();

		return this;  // must return this, we're returning the parent class, which is Landing.
	}

	// You want to avoid having locators in your tests for maintainability purposes.
	// Therefore you should externalize interaction with these elements to the page objects.
	/**
	 * Search for products with entered criteria.
	 *
	 * @param searchTerm String search term to search for.
	 * @return an instance of Landing.
	 */
	public Landing searchProducts(String searchTerm) {

		driver.findElement(searchInput).sendKeys(searchTerm);
		driver.findElement(searchSubmit).click();

		return this;
	}

	
}

	
