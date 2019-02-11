package com.automationpractice.thirdDemo;

import com.automationpractice.pageobjects.Landing;
import com.automationpractice.pageobjects.MyAccount;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.pageobjects.LogIn;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Test with simple setup and teardown methods called.
 *
 * @author nickg
 */
public class SetupTearDownTest {

	private WebDriver driver;
	
	/*
	 * Setup the driver and navigate to the webpage
	 */
	@Before
	public void setUpTest() throws InterruptedException {

		// Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");

		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");

		Landing landingPage = new Landing(driver);
		landingPage.goToPage();
		landingPage.goToLogin();

	}
	
	
	/*
	 * Verify that login username cannot be null.
	 */
	@Test
	public void userWithNoEmailCannotLogin() {
		String email = "";
		String password = "banana";

		LogIn.SignIn signIn = new LogIn(driver).new SignIn();

		signIn.with(email, password);

        Assert.assertTrue("Login error did not display.",
                signIn.dangerAlertDisplayed());
		
	}
	
	
	/*
	 * Verify that a user with valid credentials can login
	  * and view the My Account page.
	 */
	// TODO: Test site login not working at the moment, find a new site.
	//@Test
	public void userWithValidCredentialsCanLogin() {
		String email = "demo@seleniumkc.com";
		String password = "mydemopassword123";

		LogIn.SignIn signIn = new LogIn(driver).new SignIn();
		MyAccount myAccount = new MyAccount(driver);

		signIn.with(email, password);

		String expectedTitle = "MY ACCOUNT";
		String actualTitle = myAccount.getTitleText().trim();
		//System.out.println(actualTitle);

        Assert.assertEquals("Actual page did not match expected",
                expectedTitle, actualTitle);

	}
	
	/*
	 * Happens after each Test Method.
	 * Quit the driver.
	 */
	@After
	public void tearDownTest() {
		
		driver.quit();
	}
	
	
	
}
