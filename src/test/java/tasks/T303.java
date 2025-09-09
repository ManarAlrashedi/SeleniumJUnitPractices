package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T303 {

    ChromeDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    void faker() throws InterruptedException {

        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        Faker faker = new Faker();

        String name = faker.name().fullName();
        String emailAddress = faker.internet().emailAddress();
        String currAddress = faker.address().fullAddress();
        String permAddress = faker.address().fullAddress();

        fullName.sendKeys(name);
        email.sendKeys(emailAddress);
        currentAddress.sendKeys(currAddress);
        permanentAddress.sendKeys(permAddress);

        WebElement submit = driver.findElement(By.id("submit"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        Thread.sleep(500);

        submit.click();

        Assertions.assertTrue(driver.findElement(By.id("name")).getText().contains(name));
        Assertions.assertTrue(driver.findElement(By.id("email")).getText().contains(emailAddress));
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@id='currentAddress']")).getText().contains(currAddress));
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText().contains(permAddress));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
