package tw.shawn.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC04 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/shawn"; // 定義資料庫連接URL
		Properties prop = new Properties(); // 創建Properties物件以儲存連接屬性
		prop.put("user", "root"); // 設定使用者名稱
		prop.put("password", ""); // 設定密碼 (這裡為空字串)
		try {
			Connection conn = DriverManager.getConnection(url, prop); // 建立資料庫連接

			Statement stmt = conn.createStatement(); // 創建Statement物件以執行SQL查詢
			String sql = "SELECT * FROM cust"; // 定義SQL查詢語句，選擇cust表中的所有欄位

			ResultSet rs = stmt.executeQuery(sql); // 執行查詢並獲取結果集
			// 迭代結果集中的每一行
			while (rs.next()) {
				String id = rs.getString("id"); // 獲取id欄位的值
				String cname = rs.getString("cname"); // 獲取cname欄位的值
				String tel = rs.getString("tel"); // 獲取tel欄位的值
				String birthday = rs.getString("birthday"); // 獲取birthday欄位的值
				System.out.printf("%s:%s:%s:%s\n", id, cname, tel, birthday); // 格式化輸出結果
			}
			System.out.println("Finish"); // 標記查詢完成

		}catch(Exception e) {
			System.out.println(e); // 捕獲並印出任何異常
		}
	}
}