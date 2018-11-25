package com.automationpractice.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Page Object to represent the Log In Page and the elements contained within.
 * 
 * @author nickg
 *
 */
public class LogIn {

	WebDriver driver;

	public LogIn(WebDriver driver) {
		this.driver = driver;
	}

	// Create variables by using By locators, in this case we use the id of the elements
	By createAccountEmailInput = By.id("email_create");
	By createAccountButton = By.id("SubmitCreate");

	By signInEmailInput = By.id("email");
	By signInPasswordInput = By.id("passwd");
	By signInButton = By.id("SubmitLogin");

	
	By dangerAlert = By.className("alert-danger");



	public LogIn signInAsUser(String email, String password)
	{


		return this;
	}

	/**
	 * Click the submit button.
	 */
	public void clickSignIn()
	{
		driver.findElement(signInButton).click();
	}

	/**
	 *
	 */
	public class SignIn
	{

		/**
		 * Method to enter the user name and password and click the submit button.
		 *
		 * @param email the username value to be entered by the user.
		 * @param password the password value to be entered by the user.
		 */
		public void with(String email, String password)
		{

			driver.findElement(signInEmailInput).sendKeys(email);
			driver.findElement(signInPasswordInput).sendKeys(password);
			driver.findElement(signInButton).click();

		}

        /**
         * Method to determine if danger alert is displayed.
         * @return boolean true if displayed, false if not displayed.
         */
        public boolean dangerAlertDisplayed() {

            boolean exists = driver.findElements(dangerAlert).size() != 0;

            return exists;
        }

	}
}
