# Selenium Java Intro Workshop

This is an example web automation testing project using Selenium WebDriver and Java. This project tests some of the functionality of a shopping demo app. This app is hosted as [here](http://automationpractice.com/index.php)

## Project Setup

> **Prerequisites:**
>
> - Java 8+
> - Some IDE, preferably either IntelliJ or Eclipse
> - Apache Maven

### Dependencies


## Running this example

The tests are setup to run on **Chrome** by default but you can easily comment out the setup of Chromedriver and run in **Firefox** instead if you have Geckodriver installed.

### What should I know?
To run any unit tests that test your Selenium framework you just need to ensure that all unit test file names end, or start with "test" and they will be run as part of the build.  

You can run each test individually or you can run all tests usually by selecting the project folder, right-click and select run as > tests.

## Troubleshooting

**Project does not resolve as a Maven Project**
- Ensure that you have imported the project root, not the repository root.
- Make sure to import Maven dependencies if first time. In IntelliJ you can use Alt+Shift+A and use 'Reimport all Maven Projects"

**Selenium or JUnit code contains errors.** 
- Make sure to double check that the dependencies for JUnit or Selenium are declared at the top of your Class.

**java.lang.IllegalStateException: The driver executable does not exist:**
- Ensure that the path to your Driver (chromedriver.exe) is correct and without typos.

**org.openqa.selenium.WebDriverException: unknown error: unhandled inspector error: {"code":-32000,"message":"Cannot navigate to invalid URL"}**
- Make sure the driver.get(); is utlizing a valid, complete URL such as driver.get("http://automationpractice.com/index.php");

