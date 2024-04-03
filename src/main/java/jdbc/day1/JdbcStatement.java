package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Instantiate Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create connection attributes
		
		String userName="root";
		String passWord="Lemlem11!";
		String url="jdbc:mysql://localhost:3306/sakila";
		
		//Create connection with Database
		
		Connection conn = DriverManager.getConnection(url, userName, passWord); //getConnection return Connection instance
		
		//create statement from connection
		
		Statement st = conn.createStatement(); //createStatement return Statement instance
		
		//DML or CRUD Operation Select statement we use executeQuery
		
		String sql = "SELECT * FROM sakila.country";
		
		//DML or CRUD Operation Insert statement we use executeUpdate
		String sql2 = "INSERT INTO `sakila`.`country` (`country_id`, `country`, `last_update`) VALUES ('115', 'Ledeta', '2024-03-27 04:44:00')";
		
		//DML or CRUD Operation Update statement we use executeUpdate
		String sql3 = "UPDATE `sakila`.`country` SET `country` = 'Gondar', `last_update` = '2024-03-29 04:44:00' WHERE (`country_id` = '112')";
		
		//DML or CRUD Operation Delete statement we use executeUpdate
		String sql4 = "DELETE from sakila. country WHERE (country_id = 113)";
		
		//executeUpdate to Insert Data
		st.executeUpdate(sql2);
		
		//executeUpdate to Update Data
		st.executeUpdate(sql3);
		
		//executeUpdate to Delete Data
		st.executeUpdate(sql4);
		
		ResultSet rst = st.executeQuery(sql); //executeQuery return ResultSet instance
		
		while(rst.next()) {
		
		System.out.println(rst.getInt(1));
		System.out.println(rst.getString(2));
		System.out.println(rst.getTime(3));
		
		System.out.println("_______");
		
		}
		

	}

}
