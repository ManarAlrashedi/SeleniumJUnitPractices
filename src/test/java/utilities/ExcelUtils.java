package utilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

public class ExcelUtils {

        private Workbook workbook;

        public ExcelUtils(String contentRoot) {
            try {
                workbook = WorkbookFactory.create(new FileInputStream(contentRoot));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public Cell getCell(String sheet, int row, int cell) {
            return workbook.getSheet(sheet).getRow(row).getCell(cell);
        }

        public Workbook getWorkbook() {
            return workbook;
        }

        public void takeElementsScreenshot(WebElement element) {
            File screenshot = element.getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(screenshot.toPath(), new File("element_screenshot.png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

