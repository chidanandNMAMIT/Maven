package fileReadWrite;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadCsvAtaTime {
	
	public static void readAllDataAtOnce(String file) 
	{ 
	    try { 
	        // Create an object of file reader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader(file); 
	  
	        // create csvReader object and skip first Line 
	        CSVReader csvReader = new CSVReaderBuilder(filereader) 
	                                  .withSkipLines(1) 
	                                  .build(); 
	        List<String[]> allData = csvReader.readAll(); 
	  
	        // print Data 
	        for (String[] row : allData) { 
	            for (String cell : row) { 
	                System.out.print(cell + "\t"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	} 
	
	public static void main(String[] args) {
		
		readAllDataAtOnce("F:\\chidanand\\javaIO\\employees1.csv");
		
	}

}
