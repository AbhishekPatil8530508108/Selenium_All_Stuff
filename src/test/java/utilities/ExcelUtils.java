package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class ExcelUtils {
    private String path;

    public ExcelUtils(String filePath) {
        this.path = filePath;
    }

    // Method to get the row count
    public int getRowCount(String sheetName) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = (sheet != null) ? sheet.getLastRowNum() : 0; // Handle null sheet
        workbook.close();
        fi.close();
        return rowCount;
    }

    // Method to get the column count in a row
    public int getCellCount(String sheetName, int rownum) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = (sheet != null) ? sheet.getRow(rownum) : null;
        int cellCount = (row != null) ? row.getLastCellNum() : 0; // Handle null row
        workbook.close();
        fi.close();
        return cellCount;
    }

    // Method to get cell data
    public String getCellData(String sheetName, int rownum, int column) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = (sheet != null) ? sheet.getRow(rownum) : null;
        Cell cell = (row != null) ? row.getCell(column) : null;

        DataFormatter formatter = new DataFormatter();
        String data = (cell != null) ? formatter.formatCellValue(cell) : ""; // Handle null cell

        workbook.close();
        fi.close();
        return data;
    }

    // Method to set cell data
    public void setCellData(String sheetName, int rownum, int column, String data) throws IOException {
        File xlfile = new File(path);
        if (!xlfile.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            FileOutputStream fo = new FileOutputStream(path);
            workbook.write(fo);
            workbook.close();
            fo.close();
        }

        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);

        if (workbook.getSheetIndex(sheetName) == -1) {
            workbook.createSheet(sheetName);
        }
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet.getRow(rownum) == null) {
            sheet.createRow(rownum);
        }
        Row row = sheet.getRow(rownum);

        Cell cell = row.createCell(column);
        cell.setCellValue(data);

        FileOutputStream fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }

    // Method to fill a cell with red color
    public void fillRedColor(String sheetName, int rownum, int column) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fi);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = (sheet != null) ? sheet.getRow(rownum) : null;
        Cell cell = (row != null) ? row.getCell(column) : null;

        if (cell != null) { // Only proceed if cell is not null
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cell.setCellStyle(style);
        }

        FileOutputStream fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
}
