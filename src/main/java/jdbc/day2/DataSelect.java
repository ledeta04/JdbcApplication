package jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSelect {
	
	public static String Driver = "com.mysql.cj.jdbc.Driver";
	public static String userName = "root";
	public static String passWord = "Lemlem11!";
	public static String url = "jdbc:mysql://localhost:3306";
	public static Connection con = null;
	
	
	public static void connection() throws ClassNotFoundException, SQLException { //We create connection here
		
		Class.forName(Driver); //inject to the class
		
		con = DriverManager.getConnection(url, userName, passWord); //return con
	}
		public static void read(int id) throws ClassNotFoundException, SQLException { //Pass Parameter on read Method
		
		//Call connection method
		connection(); 
		
		//Select Statement(Prepared Statement)
		String sql = "SELECT * FROM craftdatabase.bank_users where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery(); //executeQuery return ResultSet
		
		while(rs.next()) {
			
			System.out.println("id -> " + rs.getInt(1));
			System.out.println("accountType - > " + rs.getString(2));
			System.out.println("accountBalance -> " + rs.getDouble(3));
			System.out.println("SSN -> " + rs.getString(4));
			System.out.println("address -> " + rs.getString(5));
			System.out.println("email -> " + rs.getString(6));
			System.out.println("phoneNumber -> " + rs.getString(7));
			System.out.println("bankName -> " + rs.getString(8));
			
		}
		
		}	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			BankUsers bu = new BankUsers(); //Create an Object 
			
			read(5); 

		
	}

}
