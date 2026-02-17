package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class GetExcelData {

    public static String getCellData(String filePath, String sheetName, int rowIndex, int colIndex) {

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowIndex);

            if (row == null) {
                throw new RuntimeException("Row not found: " + rowIndex);
            }

            Cell cell = row.getCell(colIndex);

            if (cell == null) {
                return "";
            }

            return cell.toString();

        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file", e);
        }
    }
}
