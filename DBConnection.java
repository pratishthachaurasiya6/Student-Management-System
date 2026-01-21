package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {

		Connection con = null;
		try {
			// 1.Register the driver class

			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2.Create connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Coco@123");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
