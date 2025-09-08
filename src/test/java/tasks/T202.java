package tasks;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T202 {

    // Task 2: Page Source Validation
    static WebDriver driver;

    /*
    Test 1:
    Navigate to https://www.selenium.dev.
    Verify that the page source contains the word "WebDriver".
    */

    @Test
    void test1(){
        driver.get("https://www.selenium.dev.");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("WebDriver"), "Page source doesn't contain WebDriver ");

    }


    /*
    Test 2:
    Navigate to https://www.python.org.
    Assert the page source contains "Python".
     */

    @Test
    void test2(){
        driver.get("https://www.python.org.");
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("Python"), "Page source doesn't contain Python ");
    }

    /*
    Setup:
    Use @BeforeEach to open Chrome and maximize.
    */

    @BeforeEach
    void beforEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*
    Teardown:
    Close the browser with @AfterEach.
    */
    @AfterEach
    void afterEach() {
        driver.quit();
    }

}
