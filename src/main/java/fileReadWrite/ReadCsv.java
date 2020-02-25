package fileReadWrite;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class ReadCsv {
	
	public static void readDataLineByLine(String file) 
	{ 
	  
	    try { 
	  
	        // Create an object of filereader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader(file); 
	  
	        // create csvReader object passing 
	        // file reader as a parameter 
	        @SuppressWarnings("resource")
			CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	  
	        // we are going to read data line by line 
	        while ((nextRecord = csvReader.readNext()) != null) { 
	            for (String cell : nextRecord) { 
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
		readDataLineByLine("F:\\chidanand\\javaIO\\employees.csv");
	}

}
