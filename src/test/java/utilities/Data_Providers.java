package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class Data_Providers {

    // Data provider for login data
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        // Path to the Excel file (Ensure the path is correct)
        String path = "D:\\WORKSPACES\\intellij-idea-workspace\\Selenium_All_Stuff\\4.TestData\\LoginTestData.xlsx";

        // Creating an object of ExcelUtility class
        ExcelUtils util = new ExcelUtils(path);

        // Getting row and column count
        int totalRows = util.getRowCount("Sheet1");  // Number of rows
        int totalCols = util.getCellCount("Sheet1", 1);  // Number of columns

        // Creating a 2D array to store data
        String[][] loginData = new String[totalRows - 1][totalCols];  // -1 to exclude headers

        // Reading data from Excel and storing it in the 2D array
        for (int i = 1; i < totalRows; i++) {  // Start from 1 to skip headers
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = util.getCellData("Sheet1", i, j);
            }
        }

        return loginData;  // Returning the 2D array for TestNG tests
    }
//    Data Provider 2
//    Data Provider 3
}
