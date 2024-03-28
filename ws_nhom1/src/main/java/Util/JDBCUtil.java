package Util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class JDBCUtil {
	public static Connection connectJDBC() {
		Connection c = null;
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			String url = "JDBC:mysql://localhost:3306/ws_nhom1";
			String user = "root";
			String password = "";
			
			c = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void disConnecJDBC(Connection c) {
		if(c != null) {
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
