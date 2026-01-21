package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
	// ADD STUDENT
	public void addStudent(Student s) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "INSERT INTO student(name,course,city,total_marks,phone) VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, s.getName());
			ps.setString(2, s.getCourse());
			ps.setString(3, s.getCity());
			ps.setInt(4, s.getTotalMarks());
			ps.setString(5, s.getPhone());

			int status = ps.executeUpdate();
			System.out.println(status > 0 ? "✅ Student Added Successfully" : "Something went wrong");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2.View Student

	public void viewStudents() {
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM student");

			System.out.println("\nID | Name | Course | City | Marks | Phone");
			System.out.println("--------------------------------------------");

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " |" + rs.getString("name") + " | " + rs.getString("course")
						+ " | " + rs.getString("city") + " | " + rs.getInt("total_marks") + " | "
						+ rs.getString("phone"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 3.Update Student

	public void updateStudent(int id, String city, int marks) {
		try {
			Connection con = DBConnection.getConnection();

			String sql = "UPDATE student SET city=?, total_marks=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, city);
			ps.setInt(2, marks);
			ps.setInt(3, id);

			int rows = ps.executeUpdate();
			if (rows > 0)
				System.out.println("✅ Student Updated");
			else
				System.out.println("❌ Student Not Found");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Delete Records
	public void deleteStudent(int id) {
		try {
			Connection con = DBConnection.getConnection();
			String sql = "DELETE FROM student where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			int rows= ps.executeUpdate();
			if (rows > 0)
				System.out.println("✅ Student Deleted");
			else
				System.out.println("❌ Student Not Found");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
