package seleniumDemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExceldataProvider {
		
		public static Workbook book;
		public static Sheet sheet;
		public static String TESTDATA_SHEETPATH = System.getProperty("user.dir")+"/TestData/MyntraTestdata.xlsx";
		
			public static Object[][] getTestdata(String SheetName) {
				FileInputStream file = null;
				try {
					file = new FileInputStream(TESTDATA_SHEETPATH);
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					book = WorkbookFactory.create(file);
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				sheet = book.getSheet(SheetName);
				Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

				for (int i = 0; i < sheet.getLastRowNum(); i++) {
					for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
						data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
					}

				}
				return data;
				}
	}

