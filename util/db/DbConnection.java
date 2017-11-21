package util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection() {

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false", "KJ_Java_hospital", "strongPasswordWouldBeNice");

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} // end finally try
	}
}
