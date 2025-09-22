package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T601 extends TestBase {

    @Test
    void UserRegistrationandScreenshotCapture () {

        driver.get("https://claruswaysda.github.io/homepage.html");

        takeFullPageScreenshot();

        driver.findElement(By.id("userIcon")).click();
        driver.findElement(By.linkText("Register")).click();

        takeFullPageScreenshot();

        driver.findElement(By.id("first-name")).sendKeys("mm");
        driver.findElement(By.id("last-name")).sendKeys("dd");
        driver.findElement(By.id("address")).sendKeys("Riyadh");
        driver.findElement(By.id("phone")).sendKeys("11144119");
        driver.findElement(By.id("username")).sendKeys("mm");
        driver.findElement(By.id("email")).sendKeys("a@g.com");
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.id("confirm-password")).sendKeys("1234567");
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/button")).click();

        takeFullPageScreenshot();

        // website does not show success message and does not appear the login button

//        driver.findElement(By.xpath("//*[@id=\"successMessage\"]/button")).click();
//
//        takeFullPageScreenshot();
//
//        driver.findElement(By.id("username")).sendKeys("mm");
//        driver.findElement(By.id("password")).sendKeys("1234567");
//        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
//
//        takeFullPageScreenshot();
//
//        takeElementsScreenshot(driver.findElement(By.id("clickMeButton")));
//        driver.findElement(By.id("clickMeButton")).click();
//
//        takeFullPageScreenshot();

}
}