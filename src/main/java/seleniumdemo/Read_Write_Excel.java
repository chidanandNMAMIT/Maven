package seleniumdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Write_Excel {
	static String filepath = "C:\\Users\\Siddu\\Desktop\\exceldata.xlsx";
	static String Sheetname = "Age";
	static String value = "pass";
	static int rowNo = 1;
	static int columnNo = 2;

	public static void main(String[] args) {
		//writeDataFromExcel(rowNo, columnNo, filepath, Sheetname, value);
		readDataFrmExcel(filepath, Sheetname);
	}

	public static void readDataFrmExcel( String filepath, String Sheetname) {
		try {
			FileInputStream fis = new FileInputStream(new File(filepath));

			try {
				XSSFWorkbook wbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = wbook.getSheet(Sheetname);
				int rowCount = sheet.getLastRowNum();
				System.out.println("Total no of rows = " + rowCount);
				int ColumnCount = sheet.getRow(1).getLastCellNum();
				System.out.println("Total no of Column = " + ColumnCount);

				for (int i = 1; i < rowCount; i++) {
					XSSFCell cell = sheet.getRow(i).getCell(0);
					String cellTxt = "";

					if (cell.getCellType() == CellType.STRING) {
						cellTxt = cell.getStringCellValue();
					} else if (cell.getCellType() == CellType.NUMERIC) {
						cellTxt = String.valueOf(cell.getNumericCellValue());
					} else if (cell.getCellType() == CellType.BLANK) {
						cellTxt = "";
					}

					System.out.println(cellTxt);

					fis.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void writeDataFromExcel(int rowNo, int columnNo, String filepath, String Sheetname, String value) {

		try {
			FileInputStream input = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sh = wb.getSheet(Sheetname);
			XSSFRow row = sh.getRow(rowNo);
			FileOutputStream webdata = new FileOutputStream(filepath);
			row.createCell(columnNo).setCellValue(value);
			wb.write(webdata);

			wb.close();
		} catch (Exception e) {

		}
	}

}