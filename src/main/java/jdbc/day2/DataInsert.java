package jdbc.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInsert {

	
	public static String Driver = "com.mysql.cj.jdbc.Driver";
	public static String userName = "root";
	public static String passWord = "Lemlem11!";
	public static String url = "jdbc:mysql://localhost:3306";
	public static Connection con = null;
	
	
	public static void connection() throws ClassNotFoundException, SQLException { //We create connection here
		
		Class.forName(Driver); //inject to the class
		
		con = DriverManager.getConnection(url, userName, passWord); //return con
		
	}
	public static void insert(BankUsers bu) throws ClassNotFoundException, SQLException { //We pass the Object here from main method
		
		connection(); //Call connection method
		
		//Create Statement(Prepared Statement)
		String sql = "INSERT INTO `craftdatabase`.`bank_users` (`id`, `account_type`, `account_balance`, `ssn`, `address`, `email`, `phone_num`, `bank_name`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql); //prepareStatement return prepareStatement
		ps.setInt(1, bu.getId());
		ps.setString(2, bu.getAccountType());
		ps.setDouble(3, bu.getAccountBalance());
		ps.setString(4, bu.getSsn());
		ps.setString(5, bu.getAddress());
		ps.setString(6, bu.getEmail());
		ps.setString(7, bu.getPhoneNum());
		ps.setString(8, bu.getBankName());
		
		//to insert data
		int row = ps.executeUpdate(); //executeUpdate return int
		
		System.out.println(row + " affected"); //to see console confirmation
		
		//close it
		con.close();
		
	}


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		BankUsers bu = new BankUsers(3, "Saving", 75000.0, "56565689", "France", "test@health.com", "+295256489", "France Bank"); //Create an Object 
		
		insert(bu);//We call insert method

	}

}