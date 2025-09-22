package tasks;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import utilities.ExcelUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T701 {

    @Test
    void testEarningsRankingSystem() throws IOException {

        Workbook workbook = new ExcelUtils("src/test/resources/EarningList.xlsx").getWorkbook();
        Sheet sheet = workbook.getSheet("Sheet1");

//        Task 3: Earnings Ranking System
//        Given: Save EarningList.xlsx file into your project
//        When: In the row column, write the row numbers according to the earnings amount (Natural Order - lowest to highest).
//        Then: Assert that row number of Wednesday is 1


        List<Integer> earnings = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            earnings.add((int) sheet.getRow(i).getCell(1).getNumericCellValue());
        }

        Collections.sort(earnings);
       // System.out.println("earnings = " + earnings);

        Map<Integer, Integer> earningsRankMap = new HashMap<>();
        for (int i = 0; i < earnings.size(); i++) {
            earningsRankMap.put(earnings.get(i), i + 1);
    }

     //   System.out.println("earningsRankMap = " + earningsRankMap);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            int earning = (int) row.getCell(1).getNumericCellValue();
            int rank = earningsRankMap.get(earning);
            row.createCell(2).setCellValue(rank);
        }


        //        Then: Assert that row number of Wednesday is 1
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String day = row.getCell(0).getStringCellValue();
            if (day.equals("Wednesday")) {
                int rank = (int) row.getCell(2).getNumericCellValue();
                assertEquals(1, rank);
            }
        }


        FileOutputStream fos = new FileOutputStream("src/test/resources/EarningList.xlsx");
        workbook.write(fos);


        workbook.close();
        fos.close();


    }


}


