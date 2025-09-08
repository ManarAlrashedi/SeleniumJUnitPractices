package tasks;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T05 {

    public static void main(String[] args) {

        //Invoke Chrome Driver
        WebDriver driver = new ChromeDriver();

        //Navigate to Facebook homepage URL: https://www.facebook.com/
        driver.get("https://www.facebook.com/");

        //Verify expected equals actual URL.
        String expected = "https://www.facebook.com/";
        String actual = driver.getCurrentUrl();

        if (actual.equals(expected)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        // Verify expected contains Facebook Word.
        String title = driver.getTitle();
        if (title.equals("facebook")) {
            System.out.println("Title is correct");
        } else {
            System.err.println("Title is incorrect");
        }

        driver.quit();
    }
}



