package fileReadWrite;

import java.io.File;

import org.ini4j.Wini;

public class Writeini {

	public static void main(String[] args) {
		
		 try{
	        	
	            Wini ini = new Wini(new File("F:\\chidanand\\javaIO\\Myini.ini"));
	          
	            ini.put("Company", "emp_name", "Abc");
	            ini.put("Company", "emp_id",100);
	            
	            ini.put("College", "St_name", "xyz");
	            ini.put("College", "St_id",1000);
	            ini.store();
	        // To catch basically any error related to writing to the file
	        // (The system cannot find the file specified)
	        }catch(Exception e){
	        	e.printStackTrace();
	           
	        }

	}

}
