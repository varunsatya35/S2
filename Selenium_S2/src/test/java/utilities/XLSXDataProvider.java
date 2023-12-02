package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XLSXDataProvider {
	@DataProvider(name = "excelData")
    public static Object[][] readExcelData() throws IOException {
        String filePath = "C:\\Users\\bhara\\Desktop\\Training\\Selenium-S2\\S2Data.xlsx";
        String sheetName = "Sheet1"; // Change to your sheet name

        FileInputStream fileInputStream = new FileInputStream(new File (filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);



        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; // Assuming the first row is header

        for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}

        workbook.close();
        fileInputStream.close();

        return data;
    }

}
