package tasks;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T201 {

    //Task 1: Browser History Exploration

    static WebDriver driver;

    /*
    Test 1:
    Navigate to https://www.wikipedia.org.
    Navigate to https://www.google.com.
    Navigate back and forward multiple times, asserting the correct title at each step.
    */

    @Test
    void test1() {

        driver.get("https://www.wikipedia.org");
        String wikipediaTitle = driver.getTitle();
        assertTrue(wikipediaTitle.contains("Wikipedia"), "Title does not contain Wikipedia!");

        driver.get("https://www.google.com");
        String googleTitle = driver.getTitle();
        assertTrue(googleTitle.contains("Google"), "Title does not contain Google!");

        driver.navigate().back();
        String backTitle = driver.getTitle();
        assertTrue(backTitle.contains("Wikipedia"), "Back navigation failed!");

        driver.navigate().forward();
        String forwardTitle = driver.getTitle();
        assertTrue(forwardTitle.contains("Google"), "Forward navigation failed!");

        driver.navigate().back();
        assertTrue(driver.getTitle().contains("Wikipedia"), "Second back navigation failed!");

        driver.navigate().forward();
        assertTrue(driver.getTitle().contains("Google"), "Second forward navigation failed!");
    }

    /*
    Test 2:
    Use driver.navigate().refresh() on Google and assert the title still contains "Google".
    */

    @Test
    void test2() {
        driver.get("https://www.google.com");
        driver.navigate().refresh();
        String refreshedTitle = driver.getTitle();
        assertTrue(refreshedTitle.contains("Google"), "Title does not contain Google after refresh!");
    }


    /*
    Setup:
    Use @BeforeEach to launch Chrome and maximize.
    */

    @BeforeEach
    void beforEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*
    Teardown:
    Use @AfterEach to close the browser
    */

    @AfterEach
    void afterEach() {
        driver.quit();
    }


}
