package tasks;


import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class T04 {

    public static void main(String[] args) throws InterruptedException {


        //Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        // Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");
        Thread.sleep(300);

        //Verify the page title contains the word video.
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);

        if (title.equals("video")) {
            System.out.println("Title is correct");
        } else {
            System.err.println("Title is incorrect");
        }

        //Close the driver.
        driver.quit();

    }
}
