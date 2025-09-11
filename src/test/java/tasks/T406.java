package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T406 {


//    Task 8: Free Practice
//    Practice on https://demo.guru99.com/test/newtours/register.php
//    Apply dropdown and form handling techniques


    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }

    @Test
    public void test() {

        driver.findElement(By.name("firstName")).sendKeys("M");
        driver.findElement(By.name("lastName")).sendKeys("N");
        driver.findElement(By.name("phone")).sendKeys("0000000000");
        driver.findElement(By.name("userName")).sendKeys("a@a.com");
        driver.findElement(By.name("address1")).sendKeys(" S Street");
        driver.findElement(By.name("city")).sendKeys("S");
        driver.findElement(By.name("state")).sendKeys("f");
        driver.findElement(By.name("postalCode")).sendKeys("00000");

        WebElement countryDropdown = driver.findElement(By.name("country"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("SAUDI ARABIA");

        driver.findElement(By.name("email")).sendKeys("user");
        driver.findElement(By.name("password")).sendKeys("cccAA987090");
        driver.findElement(By.name("confirmPassword")).sendKeys("cccAA987090");
        driver.findElement(By.name("submit")).click();

        WebElement confirmation = driver.findElement(By.tagName("body"));
        Assertions.assertTrue(confirmation.getText().contains("Thank you for registering"));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}


