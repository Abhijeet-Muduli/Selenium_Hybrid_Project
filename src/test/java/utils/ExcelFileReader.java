package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFileReader {

    private static final String FILE_PATH = "testdata/data.xlsx";

    public static String getCellData(String sheetName, int rowNum, int colNum) {
        String value = "";
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                LoggerHandler.error("Sheet '" + sheetName + "' not found.");
                return value;
            }

            Row row = sheet.getRow(rowNum);
            if (row == null) {
                LoggerHandler.error("Row " + rowNum + " not found.");
                return value;
            }

            Cell cell = row.getCell(colNum);
            if (cell == null) {
                LoggerHandler.error("Cell at row " + rowNum + ", col " + colNum + " not found.");
                return value;
            }

            DataFormatter formatter = new DataFormatter();
            value = formatter.formatCellValue(cell);
            LoggerHandler.info("Read from Excel [" + sheetName + "] row=" + rowNum
                    + " col=" + colNum + " => " + value);

        } catch (IOException e) {
            LoggerHandler.error("Error reading Excel file: " + e.getMessage());
        }
        return value;
    }

    // Sheet "TestData", Row index 1 (data row), columns: 0=ReferralCode, 1=MinPrice, 2=FullName
    public static String getReferralCode() {
        return getCellData("TestData", 1, 0);
    }

    public static String getMinPrice() {
        return getCellData("TestData", 1, 1);
    }

    public static String getFullName() {
        return getCellData("TestData", 1, 2);
    }
}