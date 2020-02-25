package fileReadWrite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc_conn {
	public static void main(String args[]){  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","TIGER");  
		  
		PreparedStatement stmt=con.prepareStatement("insert into EMP values(?,?)");
	
		  
		   
		int i=stmt.executeUpdate();  
		System.out.println(i+" records inserted");  
		  
		con.close();  
		  
		}catch(Exception e){ System.out.println(e);}  
		  
		}  
}
