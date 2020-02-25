package fileReadWrite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_ToExcel {

	public static void main(String[] args) throws Exception {
		writeFileUsingPOI();

	}

	public static void writeFileUsingPOI() throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Country");

		ArrayList<Object[]> data = new ArrayList<Object[]>();
		data.add(new Object[] { "Country", "Capital", "Population" });
		data.add(new Object[] { "India", "Delhi", 500 });
		data.add(new Object[] { "France", "Paris", 40000 });
		data.add(new Object[] { "Germany", "Berlin", 20000 });
		data.add(new Object[] { "England", "London", 300 });

		// Iterate over data and write to sheet
		int rownum = 0;
		for (Object[] countries : data) {
			Row row = sheet.createRow(rownum++);

			int cellnum = 0;
			for (Object obj : countries) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}

		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Siddu\\Desktop\\exceldata.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("CountriesDetails.xlsx has been created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
	}
}
