package fileReadWrite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcConnection {

	public static void main(String args[]) {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from dual where(sal");
			while (rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		

	}
}
