package fileReadWrite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	public String getExcelData(String sheetname, int rowNum, int cellNum) {
		String retval = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Siddu\\Desktop\\exceldata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheetname);
			Row r = s.getRow(rowNum);
			Cell c = r.getCell(cellNum);
			retval = c.getStringCellValue();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (EncryptedDocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return retval;
	}

	public int getLastRowNumber(String sheetname) {
		int retval = 0;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Siddu\\Desktop\\exceldata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheetname);
			retval = s.getLastRowNum();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (EncryptedDocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return retval;
	}

}
