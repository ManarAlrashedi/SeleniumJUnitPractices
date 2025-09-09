package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T302 {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://test.rubywatir.com/radios.php");
    }

    @Test
    void radioButtonTest() throws InterruptedException {

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

        for (int i = 0; i < radioButtons.size(); i++) {
            WebElement rb = radioButtons.get(i);
            String value = rb.getAttribute("value");

            System.out.println("Radio Button " + (i + 1) + " [" + value + "] enabled: " + rb.isEnabled());

            if (rb.isEnabled()) {
                rb.click();
                Thread.sleep(500);

                if (rb.isSelected()) {
                    System.out.println(" Radio Button " + (i + 1) + " [" + value + "] selected and verified.");
                } else {
                    System.out.println(" Radio Button " + (i + 1) + " [" + value + "] selection failed.");
                }

                Thread.sleep(500);
            } else {
                System.out.println("Radio Button " + (i + 1) + " [" + value + "] is disabled.");
            }
        }
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
