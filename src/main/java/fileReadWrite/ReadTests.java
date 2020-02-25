package fileReadWrite;

public class ReadTests {

	public static void main(String[] args) {
		
		ReadExcel excel=new ReadExcel();
		int lastrownum=excel.getLastRowNumber("Country");
		String username=excel.getExcelData("Country", 0, 0);
		String password=excel.getExcelData("Country", 1, 1);
		System.out.println(username +"  "+ password);
		
		for(int i=0; i<lastrownum; i++) {
			String urname=excel.getExcelData("Country", i, 0);
			String pasword=excel.getExcelData("Country", i, 1);
			System.out.println(urname +"  "+ pasword);
		}

	}

}
