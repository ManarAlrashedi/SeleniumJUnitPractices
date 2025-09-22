package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class T801 extends TestBase {

/*
Task 4: Find Youngest Record

Go to https://claruswaysda.github.io/addRecordWebTable.html
Add 10 records using Faker.
Find the name of the youngest record.

*/

    @Test
    void FindYoungestRecord(){

        //Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
//        Add 10 records using Faker.
        for (int i=0; i<=10; i++) {

            WebElement nameA =driver.findElement(By.id("nameInput"));
            nameA.sendKeys(Faker.instance().name().fullName());

            driver.findElement(By.id("ageInput")).sendKeys(Faker.instance().number().numberBetween(18, 75) + "");

            new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(Faker.instance().number().numberBetween(1, 5));
            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
        }
        //Find the name of the youngest record.

        List<WebElement> rows = driver.findElements(By.xpath("//table"));
        int minAge = Integer.MAX_VALUE;
        String youngestName = "";

        for (WebElement row : rows) {
            String name = row.findElement(By.xpath("//td[1]")).getText();
            int age = Integer.parseInt(row.findElement(By.xpath("//td[2]")).getText());

            if (age < minAge) {
                minAge = age;
                youngestName = name;
            }
        }

        System.out.println("Youngest record: " + youngestName + " (Age: " + minAge + ")");

    }



}