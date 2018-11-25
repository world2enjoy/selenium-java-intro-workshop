package com.automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {

    private WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;

    }

    public Enum Option; {

    }

    By pageTitle = By.className("page-heading");
    By accountMenuOptions = By.className("myaccount-link-list");


    /**
     * Using an Enum value above select the desired menu item.
     *
     * @return an instance of MyAccount
     */
    public MyAccount selectAccountOption() {

        return this;
    }

    public String getTitleText() {

        String text = driver.findElement(pageTitle).getText();

        return text;
    }
}
