package fileReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	
public static void main (String [] args) throws IOException{
		
		int a[][]={{1,2,3,3,2,3},{4,5,6,23,4,3}};
		
		File f1=new File("F:\\chidanand\\javaIO\\test1.xlsx");
		//f1.createNewFile();
		//f1.setWritable(true);
		FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("test1");
		if(sheet.getSheetName().equals("test1"))
		{
			workbook.removeSheetAt(0);
		}
		else
		{
			workbook.createSheet("test1");
		}
		
		for(int i=0;i<=a.length-1;i++)
		{
			Row row = sheet.createRow(i);
			for(int j=0;j<=a[i].length-1;j++)
			{
				Cell cell = row.createCell(j);
				cell.setCellValue(a[i][j]);
			}
		}
		

		FileOutputStream fos = new FileOutputStream(f1);
		workbook.write(fos);
		fos.close();
		System.out.println("END OF WRITING DATA IN EXCEL");
	}

}
