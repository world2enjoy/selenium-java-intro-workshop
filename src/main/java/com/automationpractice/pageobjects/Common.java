package com.automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object for common elements shared across the site.
 *
 * @author nickg
 */
public class Common {

    private WebDriver driver;

    /**
     * Constructs an instance of Common.
     *
     * @param driver the WebDriver.
     */
    public Common(WebDriver driver) {

        // Default Constructor

        this.driver = driver;
    }

    By searchInput = By.className("search_query_top");
    By shoppingCartWidget = By.className("shopping_cart");







}
