package org.Data_Driven_Testing;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Write_Data_In_Excel_DynamicSpecifically {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Writing Data In Excel");
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TextDataFromExcel\\WriteExcelStaticPlusSpecigically.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");

        XSSFRow row = sheet.createRow(3);
        XSSFCell cell = row.createCell(4);
        cell.setCellValue("ABHISHEK");

        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("File Is Created");
    }
}
