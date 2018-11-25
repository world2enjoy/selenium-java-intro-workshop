package com.automationpractice.pageobjects;

import com.google.common.collect.MoreCollectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Page object model for PHP Travels flights page.
 */
public class SearchResults {

    WebDriver driver;

    WebDriverWait wait;

    /**
     * Default constructor.
     *
     * @param driver the webdriver.
     */
    public SearchResults(WebDriver driver) {
        this.driver = driver;
    }

    By products = By.className("product-container");
    // children of products
    By productPrice = By.cssSelector(".right-block .content_price > span");
    By productName = By.className("product-name");

    By warningAlertBox = By.className("alert-warning");
    By productCounter = By.className("product-count");
    By productContainers = By.className("");


    /**
     * Prints out a list of product names returned by search.
     *
     * @return an instance of SearchResults.
     */
    public SearchResults listAllProductNames() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement producsDiv = wait.until(ExpectedConditions.elementToBeClickable(By.className("product_list")));

        List<WebElement> productsList = driver.findElements(products);

        System.out.println(productsList.size());
        for (WebElement product : productsList) {
            WebElement productName = product.findElement(By.className("product-name"));

           System.out.println(productName.getAttribute("title").toString());
        }

        return this;
    }

    public int returnProductCount() {

        int count;

        List<WebElement> productsList = driver.findElements(products);

        count = productsList.size();

        return count;
    }

    /**
     * Get a particular product by the name of the product.
     * Note: it's possible to have more than one product with a given name.  Use with caution.
     *
     * @param name the name of the product.
     * @return
     */
    public WebElement findProductByName(String name) {

        List<WebElement> productsList = driver.findElements(products);

        WebElement product = productsList.stream() //
                .filter(it -> it.findElement(productName).getAttribute("title").equals(name)) //
                .findFirst() //
                .get();

        return product;
    }

    /**
     * Find a specific product from a list of products by the name and price.
     *
     * @param name the name of the product.
     * @param price the price of the product.
     * @return a product WebElement.
     */
    public WebElement findProductByNameAndPrice(String name, String price) {

        List<WebElement> productsList = driver.findElements(products);

        WebElement product = productsList.stream() //
                .filter(it -> it.findElement(By.className("product-name")).getAttribute("title").equals(name) //
                        && it.findElement(By.cssSelector(".right-block .content_price > span")).getText().trim().contains(price)) // TODO: have to fix this.
                        .findFirst() //
                        .get();

        return product;
    }

    /**
     * Tester method to make sure our elements are valid.
     * lists the name and price for each product.
     *
     */
    public void returnNamesPrices() {

        String results;

        List<WebElement> productsList = driver.findElements(products);

        for (WebElement product : productsList) {
            WebElement productName = product.findElement(By.className("product-name"));
            // price span moves depending on hover, so it's tricky to nail down the locator
            WebElement productPrice = product.findElement(By.cssSelector(".right-block .content_price > span"));

            String modifiedText = productPrice.getText().replace("\n", "").replace("\t", "").trim();
            results = productName.getAttribute("title").toString() + " " +
                    modifiedText;
            System.out.println(results);
        }

    }





}
