package tw.shawn.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/*
 * https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx
 */
public class JDBC05 {
	private static final String URL = "jdbc:mysql://localhost/shawn"; 
	private static final String USER = "root";


	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			
			System.out.println("Finish");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}