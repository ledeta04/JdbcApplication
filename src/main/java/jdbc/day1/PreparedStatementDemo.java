package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//Instantiate Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create connection attributes	
		String userName="root";
		String passWord="Lemlem11!";
		String url="jdbc:mysql://localhost:3306/sakila";
		
		//Create connection with Database
		Connection con = DriverManager.getConnection(url, userName, passWord); //getConnection return Connection instance
		
		//DML or CRUD Operation Insert Prepared statement we use executeUpdate
		String sql = "INSERT INTO sakila.country (country_id, country, last_update) VALUES (?, ?, ?)";
		
		//DML or CRUD Operation Select statement we use executeQuery
		String sql2 = "SELECT * FROM sakila.country where country_id = ?";
		
		//create Prepared statement from connection
//		PreparedStatement ps = con.prepareStatement(sql); //preparedStatement return PreparedStatement instance
		
		PreparedStatement ps2 = con.prepareStatement(sql2);
		
//		ps.setInt(1, 118);
//		ps.setString(2, "Wollo");
//		ps.setString(3, "2024-03-11 04:44:00");

		
		//DML or CRUD Operation Insert statement we use executeUpdate
//		ps.executeUpdate();
		
		ps2.setInt(1, 119);
		
		ResultSet rs = ps2.executeQuery(); //executeQuery return ResultSet instance
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getTime(3));
			
			System.out.println("_______________");
			
		}
	}

}
