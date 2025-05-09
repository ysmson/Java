package tw.shawn.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.shawn.apis.BCrypt;

public class JDBC17 {
	// 定義資料庫連線的 URL，這裡連接的是名為 "north" 的資料庫
	private static final String URL = "jdbc:mysql://localhost/north";
	// 定義資料庫的使用者名稱
	private static final String USER = "root";

	// 宣告 Connection 物件，用於資料庫連線
	private static Connection conn;
	// 定義查詢員工及其訂單總金額的 SQL 語句
	private static final String QUERY =
		"SELECT e.EmployeeID, e.LastName, SUM(od.UnitPrice*od.Quantity) total FROM orders o "
		+ "JOIN orderdetails od ON (o.OrderID = od.OrderID) "
		+ "JOIN employees e ON (o.EmployeeID = e.EmployeeID) "
		+ "GROUP BY o.EmployeeID "
		+ "ORDER BY total DESC";

	public static void main(String[] args) {
		// 創建 Properties 物件，用於設定資料庫連線屬性
		Properties prop = new Properties();
		// 設定使用者名稱屬性
		prop.put("user", USER);

		try {
			// 嘗試建立資料庫連線
			conn = DriverManager.getConnection(URL, prop);
			// 創建 PreparedStatement 物件，用於執行 SQL 查詢語句
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			// 執行查詢，並將結果儲存在 ResultSet 物件中
			ResultSet rs = pstmt.executeQuery();
			// 初始化排名計數器
			int rank = 1;
			// 迭代處理查詢結果集中的每一行
			while (rs.next()) {
				// 從結果集中取得員工 ID
				String id = rs.getString("EmployeeID");
				// 從結果集中取得員工的姓氏
				String name = rs.getString("LastName");
				// 從結果集中取得該員工的訂單總金額
				String total = rs.getString("total");
				// 使用格式化輸出印出員工的排名、ID、姓氏和訂單總金額
				System.out.printf("%d: %s : %s : %s\n", rank++, id, name, total);
			}

		} catch (Exception e) {
			// 在建立連線、準備語句或執行查詢等過程中發生任何異常，都將印出錯誤訊息
			System.out.println(e);
		}
	}


}