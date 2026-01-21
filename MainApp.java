package StudentManagement;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();

		while (true) {
			System.out.println("\n===========STUDENT MANAGEMENT SYSTEM===============");
			System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Course: ");
				String course = sc.nextLine();
				System.out.print("City: ");
				String city = sc.nextLine();
				System.out.print("Total Marks: ");
				int marks = sc.nextInt();
				sc.nextLine();
				System.out.print("Phone: ");
				String phone = sc.nextLine();

				Student s = new Student(name, course, city, marks, phone);
				dao.addStudent(s);
				break;

			case 2:
				dao.viewStudents();
				break;

			case 3:
				System.out.print("Enter Student ID: ");
				int uid = sc.nextInt();
				sc.nextLine();
				System.out.print("New City: ");
				String newCity = sc.nextLine();
				System.out.print("New Marks: ");
				int newMarks = sc.nextInt();

				dao.updateStudent(uid, newCity, newMarks);
				break;

			case 4:
				System.out.println("Enter student's ID that you want to delete..");
				int did = sc.nextInt();
				dao.deleteStudent(did);
				break;

			case 5:
				System.out.println("👋 Exiting...");
				System.exit(0);

			default:
				System.out.println("Invalid Choice");
			}
		}
	}

}
