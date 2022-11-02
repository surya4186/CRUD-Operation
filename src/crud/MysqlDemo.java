package crud;

import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;

public class MysqlDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf8";
		String username = "root";
		String password = "1357";
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
				System.out.println("Enter the name");
				name = str.nextLine();
				System.out.println("Enter the age");
				age = scan.nextInt();
				System.out.println("Enter the city");
				city = str.nextLine();
				quary = "insert into users (NAME,Age,CITY) values(?,?,?)";
				ps = con.prepareStatement(quary);
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, city);
				ps.executeUpdate();
				System.out.println("insert success");

				break;
			case 2:
				System.out.println("Update Data:");
				System.out.println("Enter the Id");
				id = scan.nextInt();
				System.out.println("Enter the name");
				name = str.nextLine();
				System.out.println("Enter the age");
				age = scan.nextInt();
				System.out.println("Enter the city");
				city = str.nextLine();
				quary = "update users set NAME=?,Age=?,CITY=? where ID=?";
				ps = con.prepareStatement(quary);
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, city);
				ps.setInt(4, id);
				ps.executeUpdate();
				System.out.println("Data update success");

				break;
			case 3:
				System.out.println("deleting Data:");
				System.out.println("Enter the Id");
				id = scan.nextInt();
				quary = "delete from users where ID=?";
				ps = con.prepareStatement(quary);
				ps.setInt(1, id);
				ps.executeUpdate();
				System.out.println("Data delete success");
				break;
			case 4:
				System.out.println("select the data");
				quary = "SELECT ID,NAME,Age,CITY from users";
				rs = stmt.executeQuery(quary);
				while (rs.next()) {
					id = rs.getInt("ID");
					age = rs.getInt("Age");
					name = rs.getString("NAME");
					city = rs.getString("City");
					System.out.print(id + " ");
					System.out.print(name + " ");
					System.out.print(age + " ");

					System.out.print(city + " ");
					System.out.println();

				}
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

}
