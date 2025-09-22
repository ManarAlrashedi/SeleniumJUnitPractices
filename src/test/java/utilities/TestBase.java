package utilities;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestBase {


    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    public void tearDown() {
            driver.quit();
        }

    protected void takeScreenShot(WebDriver driver) {
        TakesScreenshot ss = (TakesScreenshot) driver;
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
        String fileName = "ScreenShot" + timeStamp + ".png";
        Path path = Path.of(System.getProperty("user.dir"), "target", "test-output", fileName);
        File screenShot = ss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, path.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void takeScreenShotOfElement(WebDriver driver, WebElement element){
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
        String fileName = "ElementScreenShot"+timeStamp+".png";
        Path path = Path.of(System.getProperty("user.dir"),"target","test-output",fileName);
        File screenShot = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot,path.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void takeFullPageScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmssSSSSS").format(new Date());
        try {
            FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "/test_outputs/screenshots/pages_screenshot" + now + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeElementsScreenshot(WebElement element) {
        File screenshot = element.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmssSSSSS").format(new Date());
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/test_outputs/screenshots/elements_screenshot" + now + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
