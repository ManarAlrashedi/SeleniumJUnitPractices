package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T502 extends TestBase {

    // Task 4: Drawing Practice

    /* java
    Go to https://claruswaysda.github.io/Draw.html
    Draw a triangle
    Reset
    */


    @Test
    void drawTest() throws InterruptedException {

        // Go to https://claruswaysda.github.io/Draw.html
        driver.get("https://claruswaysda.github.io/Draw.html");

        Thread.sleep(3000);
        // Draw a triangle
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.id("myCanvas")))
                .moveByOffset(100, 0)
                .moveByOffset(-50, -86)
                .moveByOffset(-50, 86)
                .release()
                .perform();

        // Reset
        Thread.sleep(3000);
        driver.findElement(By.id("resetButton")).click();

        Thread.sleep(3000);
    }


}

