package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class T405 {

//    Task 7: Multi-Select Operations
//    Launch browser
//    Open https://demoqa.com/select-menu
//    Select Standard Multi-Select using element id
//    Verify element is multi-select
//    Select 'Opel' using index, then deselect using index Select 'Saab' using value, then deselect using value
//    Deselect all options
//    Close browser

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void testStandardMultiSelect() {

        //    Select Standard Multi-Select using element id
        WebElement Standard = driver.findElement(By.id("cars"));
        Select select = new Select(Standard);

        //    Verify element is multi-select
        Assertions.assertTrue(select.isMultiple());

       //    Select 'Opel' using index, then deselect using index Select 'Saab' using value, then deselect using value
        select.selectByIndex(2);
        select.deselectByIndex(2);
        select.selectByValue("saab");
        select.deselectByValue("saab");

        //    Deselect all options
        select.deselectAll();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
