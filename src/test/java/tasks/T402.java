package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T402 {

    // Take 4

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement button = driver.findElement(By.xpath("//button[text()='Remove']"));
        button.click();

        WebElement mess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String text = mess.getText();

        Assertions.assertEquals("It's gone!", text);
    }

@AfterEach
public void teardown() {
    driver.quit();
}

}

