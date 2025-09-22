package tasks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class T901 extends TestBase {


    /*
        1. Navigate to https://www.saucedemo.com/v1/index.html
        2. Log in as the standard user.
        3. Capture screenshots of:
             - The lowest-priced product (including its image, price, and details).
             - The highest-priced product (including its image, price, and details).
        4. Log out of the application.
        5. Assert each step for validation.
        6. Log all steps using Log4j.
        7. Generate an Extent Report containing all steps.
    */

    Logger logger = LogManager.getLogger(T901.class);

    private static ExtentReports extent;
    private static ExtentTest test;

    // Generate an Extent Report containing all steps.

    @BeforeAll
    static void setUpReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/SwagLabReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        test = extent.createTest("SwagLab Test", "Automation Test for SwagLabs E-commerce site");
    }

    @AfterAll
    static void tearDownReport() {
        extent.flush();
    }


    @Test
    void swagLabTest() throws InterruptedException {

//        1. Navigate to https://www.saucedemo.com/v1/index.html
        driver.get("https://www.saucedemo.com/v1/index.html");
        logger.info("Navigated to https://www.saucedemo.com/v1/index.html");


//        2. Log in as the standard user.
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.ENTER);
        logger.info("Logged in as the standard user.");


//        3. Capture screenshots of:
//                - The lowest-priced product (including its image, price, and details).
//                - The highest-priced product (including its image, price, and details).
        WebElement dropDown = driver.findElement(By.tagName("select"));
        new Select(dropDown).selectByVisibleText("Price (low to high)");
        WebElement lowest = driver.findElements(By.xpath("//div[@class='inventory_item']")).getFirst();
        assertTrue(lowest.isDisplayed());
        WebElement highest = driver.findElements(By.xpath("//div[@class='inventory_item']")).getLast();
        assertTrue(highest.isDisplayed());
        takeElementsScreenshot(lowest);
        takeElementsScreenshot(highest);
        logger.info("Captured screenshots of the lowest and highest priced products.");


//        4. Log out of the application.
        JavascriptExecutor js = (JavascriptExecutor) driver;


//      Click the menu button using JavaScript
        WebElement menuButton = (WebElement) js.executeScript("return document.querySelector('.bm-burger-button button')");
        js.executeScript("arguments[0].click();", menuButton);
        logger.info("Clicked the menu button.");


//       Wait briefly for the menu animation to complete
        Thread.sleep(1000);


//      Click the logout link using JavaScript
        WebElement logoutLink = (WebElement) js.executeScript("return document.querySelector('#logout_sidebar_link')");
        js.executeScript("arguments[0].click();", logoutLink);
        logger.info("Clicked the logout link and logged out of the application.");

//        5. Assert each step for validation.
        assertEquals("https://www.saucedemo.com/v1/index.html", driver.getCurrentUrl());
        assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
        assertTrue(driver.findElement(By.id("login-button")).isDisplayed());



    }



}
