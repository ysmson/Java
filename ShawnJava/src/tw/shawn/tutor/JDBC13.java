package tw.shawn.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.shawn.apis.BCrypt;

public class JDBC13 {
	private static final String URL = "jdbc:mysql://localhost/shawn"; 
	private static final String USER = "root";
	
	private static Connection conn;
	private static final String UPDATE_SQL = 
		"UPDATE member SET icon = ? WHERE id = ?";
	

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL);
			
			FileInputStream fin = new FileInputStream("dir2/yahoo.jpg");
			
			pstmt.setBinaryStream(1, fin);
			pstmt.setInt(2, 4);
			if (pstmt.executeUpdate()>0) {
				System.out.println("Success");
			}else {
				System.out.println("Failure");
			}
			
			fin.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}