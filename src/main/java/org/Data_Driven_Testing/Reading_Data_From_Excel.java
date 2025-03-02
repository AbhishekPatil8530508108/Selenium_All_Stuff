package org.Data_Driven_Testing;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Reading_Data_From_Excel {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Reading Data From Excel");
        FileInputStream file = new FileInputStream("D:\\WORKSPACES\\intellij-idea-workspace\\Selenium\\TextDataFromExcel\\ReadExcel.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rows = sheet.getLastRowNum();
        System.out.println("Rows=" + rows);
        int columns = sheet.getRow(0).getLastCellNum();
        System.out.println("Rows=" + columns);
        for (int i = 0; i < rows; i++) {
            XSSFRow currentRow = sheet.getRow(i);
            for (int j = 0; j < columns; j++) {
                String value = currentRow.getCell(j).toString();//getBooleanCellValue()//getNumericCellValue()//getStringCellValue();
                System.out.print("  " + value);
            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }
}
