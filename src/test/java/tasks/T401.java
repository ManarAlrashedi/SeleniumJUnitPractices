package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class T401 {

//    Task 2: Calculator Operations Test
//    Go to https://testpages.eviltester.com/styled/calculator
//    Type any number in first and second input
//    Click Calculate for each operation
//    Get and verify results for all operations

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.eviltester.com/styled/calculator");
    }

    @Test
    void CalculatorOperations() {

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));

        number1.sendKeys("10");
        number2.sendKeys("5");


        String[] operations = {"plus", "minus", "times", "divide"};

        for (String op : operations) {
            Select select = new Select(driver.findElement(By.id("function")));
            select.selectByValue(op);
            driver.findElement(By.id("calculate")).click();


            WebElement answer = driver.findElement(By.xpath("//div[@class='centered']//p[1]"));
            String resultText = answer.getText().replace("Answer : ", "").trim();

            System.out.println("Operation: " + op + " → Result: " + resultText);

            switch (op) {
                case "plus":
                    assertEquals("15", resultText);
                    break;
                case "minus":
                    assertEquals("5", resultText);
                    break;
                case "times":
                    assertEquals("50", resultText);
                    break;
                case "divide":
                    assertEquals("2", resultText);
                    break;
            }
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
