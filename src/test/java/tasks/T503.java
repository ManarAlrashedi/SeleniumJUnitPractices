package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T503 extends TestBase  {

    /*
Go to https://claruswaysda.github.io/Dropdowns.html
In 1. Traditional Dropdown select 'Ford'
In 2. Multi-Select Dropdown select 'Mercedes'
In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
*/

        @Test
        void dropdownHandlingTest() throws InterruptedException {


            Thread.sleep(2000);

            driver.get("https://claruswaysda.github.io/Dropdowns.html");

//        In 1. Traditional Dropdown select 'Ford'
            WebElement TraditionalDropdown = driver.findElement(By.id("carSelect"));
            Select select = new Select(TraditionalDropdown);
            select.selectByVisibleText("Ford");
            Thread.sleep(2000);

//        In 2. Multi-Select Dropdown select 'Mercedes'
            WebElement MultiSelect = driver.findElement(By.id("multiCarSelect"));
            Select select2 = new Select(MultiSelect);
            select2.selectByVisibleText("Mercedes");
            Thread.sleep(2000);

//        In 3. Custom Dropdown (Bootstrap-like) select 'BMW'

            WebElement CustomDropdown = driver.findElement(By.id("customDropdown"));
            CustomDropdown.click();
            WebElement bmwOption = driver.findElement(By.xpath("//div[@class='custom-dropdown'][2]"));
            bmwOption.click();
            Thread.sleep(2000);

//        In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
            WebElement staticAutoSuggest = driver.findElement(By.id("staticInput"));
            staticAutoSuggest.sendKeys("Tesla");
            WebElement teslaModel3Option = driver.findElement(By.xpath("//div[@class='suggestion-item'][2]"));
            teslaModel3Option.click();
            Thread.sleep(2000);

//        In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
            WebElement dynamicAutoSuggest = driver.findElement(By.id("dynamicInput"));
            dynamicAutoSuggest.sendKeys("Toyota");
            WebElement toyotaOption = driver.findElement(By.id("dynamicSuggestions"));
            toyotaOption.click();
            Thread.sleep(2000);


        }


}