package fileReadWrite;

import java.io.File;

import org.ini4j.Wini;

public class ReadIni {
	public static void main(String[] args){
        try{
            Wini ini = new Wini(new File("F:\\chidanand\\javaIO\\workspace\\Myini.ini"));
           
            int property_value = ini.get("Company", "emp_id", int.class);
            String property_name = ini.get("Company", "emp_name");
            System.out.println(ini.get("Company").get("emp_id"));
            
            
            System.out.print("emp_id: " + property_value + "\n");
            System.out.print("emp_name: " + property_name + "\n");
           
        // To catch basically any error related to finding the file e.g
        // (The system cannot find the file specified)
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }


}
