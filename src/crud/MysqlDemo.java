package crud;

import java.sql.*;
import java.util.Scanner;

public class MysqlDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf8";
		String username = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs;
		PreparedStatement ps;

		String quary = " ";
		int id, age, choice;
		String name, city;
		Scanner scan = new Scanner(System.in);
		Scanner str = new Scanner(System.in);

		while (true) {
			System.out.println("Mysql java CRUD Operation");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Select");
			System.out.println("5.Exit");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Insert new Data:");

				break;
			case 2:
				System.out.println("Update Data:");

				break;
			case 3:
				System.out.println("deleting Data:");
				break;
			case 4:
				System.out.println("select the data");
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}

	}

//	private static Connection DriverManager(String url, String username, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
