package tasks;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T06 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //Go to the Amazon URL: https://www.amazon.com//
        driver.get("https://www.amazon.com/");

        //Verify that it writes "Performance Metrics" or " Gateway" from the Source code
        String pageSource = driver.getPageSource();

        if (pageSource.contains("Performance Metrics")) {
            System.out.println(" Performance Metrics found");
        } else if (pageSource.contains("Gateway")) {
            System.out.println("'Gateway found ");
        } else {
            System.out.println("Performance Metrics and Gateway not found ");
        }

        // Close the driver
        driver.quit();
    }


}
