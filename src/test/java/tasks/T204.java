package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T204 {


    // Task 4: Multiple Navigation and Verification

    static WebDriver driver;

       /*
       Test 1:
       Navigate Google → YouTube → LinkedIn.
       Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
       */

    @Test
    void test1() {

        driver.get("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"), "Title doesn't contain Google");

        driver.get("https://www.youtube.com");
        assertTrue(driver.getTitle().contains("YouTube"), "Title doesn't contain YouTube");

        driver.get("https://www.linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"), "Title doesn't contain LinkedIn");
    }


        /*
        Test 2:
        Navigate back twice and assert the URL of Google.
        Navigate forward twice and assert URL of LinkedIn.
        */

    @Test
    void test2() {

        driver.get("https://www.google.com");
        driver.get("https://www.youtube.com");
        driver.get("https://www.linkedin.com");

        driver.navigate().back();
        driver.navigate().back();
        assertTrue(driver.getCurrentUrl().contains("google"), "Didn't go back to Google!");

        driver.navigate().forward();
        driver.navigate().forward();
        assertTrue(driver.getCurrentUrl().contains("linkedin"), "Didn't go forward to LinkedIn!");
    }

        /*
        Teardown:
        Use @AfterAll to quit the browser.
        */

    @AfterAll
    static void afterAll(){
        driver.quit();
    }

        /*
        Setup:
        Launch Chrome and maximize in @BeforeEach.
        */

    @BeforeEach
    void beforEach() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

}
