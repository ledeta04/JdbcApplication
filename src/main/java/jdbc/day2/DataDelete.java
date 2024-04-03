package jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataDelete {
	
	public static String Driver = "com.mysql.cj.jdbc.Driver";
	public static String userName = "root";
	public static String passWord = "Lemlem11!";
	public static String url = "jdbc:mysql://localhost:3306";
	public static Connection con = null;
	
	
	public static void connection() throws ClassNotFoundException, SQLException { //We create connection here
		
		Class.forName(Driver); //inject to the class
		
		con = DriverManager.getConnection(url, userName, passWord); //return con
	}
	public static void delete() throws ClassNotFoundException, SQLException {
		
		connection(); //Call connection method
		
		String sql = "DELETE from `craftdatabase`.`bank_users` WHERE (id = ?)";
		
		//Prepared Statement
		PreparedStatement ps = con.prepareStatement(sql); //prepareStatement return prepareStatement
		
		ps.setInt(1,3);
		
		int row = ps.executeUpdate();
		
		System.out.println(row + " affected"); //to see console confirmation
		
		con.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		BankUsers bu = new BankUsers(); //Create an Object 
		
		delete();

}
	
}
