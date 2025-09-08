package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T203 {

    // Task 3: Browser Size and Position

    static WebDriver driver;

        /*Test 1:
        Navigate to https://www.bbc.com.
        Set browser size to 800x600 and assert the window size
        */

    @Test
    void test1() {
        driver.get("https://www.bbc.com");

        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);

        Dimension actualSize = driver.manage().window().getSize();
        assertEquals(800, actualSize.getWidth(), "Width isn't 800 ");
        assertEquals(600, actualSize.getHeight(), "Height isn't 600 ");
    }


        /*
        Test 2:
        Move the window to position (100, 100) and assert its position.
        */

    @Test
    void test2() {
        Point newPosition = new Point(100, 100);
        driver.manage().window().setPosition(newPosition);

        Point actualPosition = driver.manage().window().getPosition();
        assertEquals(100, actualPosition.getX(), "X position isn't 100 ");
        assertEquals(100, actualPosition.getY(), "Y position isn't 100 ");
    }


        /*
        Setup:
        Open Chrome in @BeforeEach.
        */

    @BeforeEach
    void beforEach() {
        driver = new ChromeDriver();
    }


       /*
       Teardown:
       Close the browser.
       */

    @AfterEach
    void afterEach() {
        driver.quit();
    }
}