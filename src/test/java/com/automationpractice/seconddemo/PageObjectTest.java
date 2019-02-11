package com.automationpractice.seconddemo;

import com.automationpractice.pageobjects.Landing;
import com.automationpractice.pageobjects.SearchResults;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * A test that utilizes the Page Object Design Pattern.
 * Page elements are defined in another class. This simplifies the test code and is easier to maintain.
 */
public class PageObjectTest {

	private WebDriver driver;

    /**
     * Test that the number of Dresses returned in the search equals 7.
     */
	@Test
	public void testNumberofDressesAvailable() {

		// Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");

		// Create a new Chrome WebDriver (browser) object
		driver = new FirefoxDriver();
		Landing landingPage = new Landing(driver);
        SearchResults searchResultsPage = new SearchResults(driver);

        // go to website, and search for desired term.
		landingPage.goToPage();
		landingPage.searchProducts("Dress");

		// set the expected and actual number of products that return in the search
		int expectedCount = 7;
		int actualCount = searchResultsPage.returnProductCount();

		Assert.assertEquals(expectedCount, actualCount);

		driver.quit();
	}

    /**
     * Test that the Item : Blouse costs  $27.00
     */
    @Test
	public void testThatBlouseCostsTwentySevenDollars() {

        // Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.gecko.driver", "C:/Users/Nick/WebDriver/Gecko/geckodriver.exe");

        // Create a new Chrome WebDriver (browser) object
        driver = new FirefoxDriver();
        Landing landingPage = new Landing(driver);
        SearchResults searchResultsPage = new SearchResults(driver);

        // go to website, and search for desired term.
        landingPage.goToPage();
        landingPage.searchProducts("Dress");

		WebElement product = searchResultsPage //
                .findProductByNameAndPrice("Blouse", "$27.00");
		Assert.assertTrue(product.isDisplayed());

        searchResultsPage.returnNamesPrices();

        //driver.quit();
    }

}
