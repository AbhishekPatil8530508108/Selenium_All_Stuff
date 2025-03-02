package org.Data_Driven_Testing;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Write_Data_In_Excel_Dynamically {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Writing Data In Excel");
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TextDataFromExcel\\WriteExcelDynamic.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Dynamic Data");

        Scanner sc = new Scanner(System.in);
        System.out.println("How Many Rows U Want?");
        int rows = sc.nextInt();
        System.out.println("How Many Cells U Want?");
        int cells = sc.nextInt();
        for (int i = 0; i <= rows; i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < cells; j++) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(sc.next());
            }
        }
        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("File Is Created");
    }
}
