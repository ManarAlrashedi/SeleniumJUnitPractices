package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class T304 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void toDoListTest() {
        Faker faker = new Faker();
        WebElement addTask = driver.findElement(By.xpath("//input[@type='text']"));

        for (int i = 0; i < 5; i++) {
            String randomTask = faker.lorem().word();
            addTask.sendKeys(randomTask, Keys.ENTER);
        }

        List<WebElement> tasks = driver.findElements(By.tagName("li"));
        for (int i = 0; i < tasks.size(); i++) {
            if (i % 2 == 1) {
                WebElement task = tasks.get(i);
                task.click();
                wait.until(ExpectedConditions.attributeContains(task, "class", "completed"));
            }
        }

        List<WebElement> completedTasks = driver.findElements(By.cssSelector("li.completed"));
        for (WebElement completedTask : completedTasks) {
            WebElement deleteButton = completedTask.findElement(By.cssSelector("i.fa-trash"));
            deleteButton.click();
            wait.until(ExpectedConditions.stalenessOf(completedTask));
        }

        List<WebElement> remainingTasks = driver.findElements(By.tagName("li"));
        for (WebElement remainingTask : remainingTasks) {
            String classAttribute = remainingTask.getAttribute("class");
            Assertions.assertFalse(classAttribute.contains("completed"), "There are still completed tasks remaining.");
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
