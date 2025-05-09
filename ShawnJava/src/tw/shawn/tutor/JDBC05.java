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
	private static final String URL = "jdbc:mysql://localhost/shawn";  // 定義資料庫 URL
	private static final String USER = "root"; // 定義資料庫使用者名稱


	public static void main(String[] args) {
		Properties prop = new Properties(); // 創建 Properties 物件
		prop.put("user", USER); // 設定使用者名稱

		try {
			Connection conn = DriverManager.getConnection(URL, prop); // 建立資料庫連線

			System.out.println("Finish"); // 印出完成訊息

		}catch(Exception e) {
			System.out.println(e); // 捕獲並印出任何異常
		}
	}
}