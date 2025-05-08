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
import tw.shawn.apis.Bike;

public class JDBC15 {
	private static final String URL = "jdbc:mysql://localhost/shawn"; 
	private static final String USER = "root";
	
	private static Connection conn;
	private static final String UPDATE_SQL = 
		"UPDATE member SET bike = ? WHERE id = ?";
	

	public static void main(String[] args) {
		Bike bike = new Bike();
		bike.upSpeed();bike.upSpeed();bike.upSpeed();bike.upSpeed();
		bike.upSpeed();bike.upSpeed();bike.upSpeed();bike.upSpeed();
		System.out.println(bike);

		Properties prop = new Properties();
		prop.put("user", USER);
		
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL);
			
			pstmt.setObject(1, bike);
			pstmt.setInt(2, 8);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}