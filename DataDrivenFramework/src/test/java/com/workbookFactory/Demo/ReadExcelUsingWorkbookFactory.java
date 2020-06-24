package com.workbookFactory.Demo;
 
import java.io.File;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 
public class ReadExcelUsingWorkbookFactory {
 
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
 
		/*
		 * It Creates the appropriate HSSFWorkbook / XSSFWorkbook from the given File,
		 * which must exist and be readable. In this case it will create a XSSFWorkbook
		 */
		Workbook wb = WorkbookFactory.create(new File("src\\test\\resources\\excelFiles\\MyTestData.xlsx"));
		// Get sheet with the given name "Sheet1"
		Sheet s = wb.getSheet("Sheet1");
		// Returns the number of physically defined rows (NOT the number of rows in the
		// sheet)
		int rowCount = s.getPhysicalNumberOfRows();
		System.out.println("total rows in sheet is : " + rowCount);
		// Iterating rows
		for (int i = 0; i < rowCount; i++) {
			// Returns the logical row (not physical) 0-based. If you ask for a row that is
			// not defined you get a null.
			Row r = s.getRow(i);
			// Gets the number of defined cells (NOT number of cells in the actual
			// row!).That is to say if only columns 0,4,5 have values then there would be 3
			int columnCount = r.getPhysicalNumberOfCells();
			// Iterating columns
			for (int j = 0; j < columnCount; j++) {
				Cell c = r.getCell(j);
				/*
				 * Get the value of the cell as a string For numeric cells we throw an
				 * exception. For blank cells we return an empty string.For formulaCells that
				 * are not string Formulas, we throw an exception.
				 */
				String data = c.getStringCellValue();
				System.out.print(data + "\t");
			}
			System.out.println();
		}
 
	}
}