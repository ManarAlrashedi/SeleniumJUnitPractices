package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T404 {

//    Task 6: Old Style Select Menu
//    Launch browser
//    Open https://demoqa.com/select-menu
//    Select Old Style Select Menu using element id
//    Print all dropdown options
//    Select 'Purple' using index
//    Select 'Magenta' using visible text
//    Select an option using value
//    Close browser


    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

        @Test
        void test() {

            // Select Old Style Select Menu using element id
            driver.findElement(By.id("oldSelectMenu"));

            // Print all dropdown options
            Select dropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
            dropdown.getOptions().forEach(option -> System.out.println(option.getText()));

            // Select 'Purple' using index
            dropdown.selectByIndex(4);

            // Select 'Magenta' using visible text
            dropdown.selectByVisibleText("Magenta");

            // Select an option using value
            dropdown.selectByValue("5");

        }

    @AfterEach
     void teardown() {
        driver.quit();
    }
}
