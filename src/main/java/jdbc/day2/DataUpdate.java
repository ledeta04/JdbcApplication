package jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataUpdate {
	
	public static String Driver = "com.mysql.cj.jdbc.Driver";
	public static String userName = "root";
	public static String passWord = "Lemlem11!";
	public static String url = "jdbc:mysql://localhost:3306";
	public static Connection con = null;
	
	
	public static void connection() throws ClassNotFoundException, SQLException { //We create connection here
		
		Class.forName(Driver); //inject to the class
		
		con = DriverManager.getConnection(url, userName, passWord); //return con
	}
	public static void update() throws ClassNotFoundException, SQLException { //We pass the Object here from main method
		
		connection(); //Call connection method
		
		String sql = "UPDATE `craftdatabase`.`bank_users` SET `account_type` = ?, `account_balance` = ?, `phone_num` = ? WHERE (`id` = ?)";
		
		//Prepared Statement
		PreparedStatement ps = con.prepareStatement(sql); //prepareStatement return prepareStatement
		
		ps.setString(1,"Saving");
		ps.setDouble(2, 30000);
		ps.setString(3, "+254888844");
		ps.setInt(4, 4);
		
		ps.executeUpdate();
		
		con.close();
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		BankUsers bu = new BankUsers(); //Create an Object 
		
		update();

 }
	
}

