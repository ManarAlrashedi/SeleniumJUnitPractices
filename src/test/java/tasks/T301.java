package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T301 {

    //Task 2: Checkbox Interaction
    // Question: Go to "https://the-internet.herokuapp.com/checkboxes". Write a method that:
    //Checks the current state of both checkboxes
    //Ensures both checkboxes are selected (click only if not already selected)
    //Verify both checkboxes are checked after the operations
    //Print the status of each checkbox to console


        WebDriver driver;

        @BeforeEach
        void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/checkboxes");
        }


        @Test
        void Checkboxes() {

            // Locate checkboxes
            WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
            WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

            // Check current state and select if not already selected
            if (!checkbox1.isSelected()) {
                checkbox1.click();
            }
            if (!checkbox2.isSelected()) {
                checkbox2.click();
            }

            // Assert both checkboxes are selected
            Assertions.assertTrue(checkbox1.isSelected());
            Assertions.assertTrue(checkbox2.isSelected());

            // Print status of each checkbox
            System.out.println("Checkbox1 is select : " + checkbox1.isSelected());
            System.out.println("Checkbox2 is selected: " + checkbox2.isSelected());
        }


        @AfterEach
        public void tearDown() {
                driver.quit();
            }
        }

