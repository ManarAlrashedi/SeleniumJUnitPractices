package tasks;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T03 {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        // Go to the Amazon URL : https://www.amazon.com/
        driver.get("https://www.amazon.com/");


        // Print the position and size of the page.
        int height =  driver.manage().window().getSize().height;
        int width =  driver.manage().window().getSize().width;
        System.out.println("height = " + height);
        System.out.println("width = " + width);

        int x = driver.manage().window().getPosition().x;
        int y = driver.manage().window().getPosition().y;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        Thread.sleep(3000);

        //Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(600, 10));
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(500, 945) );

        //Test that the page is in the position and size you want.
        int newHeight =  driver.manage().window().getSize().height;
        int newWidth =  driver.manage().window().getSize().width;

        System.out.println("new height = " + newHeight);
        System.out.println("new width = " + newWidth);

        int newX = driver.manage().window().getPosition().x;
        int newY = driver.manage().window().getPosition().y;

        System.out.println("new x = " + newX);
        System.out.println("new y = " + newY);

        if (newHeight == 945 && newWidth == 500 && newX == 600 && newY == 10) {
            System.out.println("Page Size and Position Test PASSED");
        } else {
            System.err.println("Page Size and Position Test FAILED");
        }


        //Close the page.
        driver.quit();


    }

}
