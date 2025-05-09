package tw.shawn.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/*
 * https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx
 */
public class JDBC07 {
	private static final String URL = "jdbc:mysql://localhost/shawn";  // 定義資料庫 URL
	private static final String USER = "root"; // 定義資料庫使用者名稱

	private static final String SQL = 
		"UPDATE cust SET cname = ?, tel = ? WHERE id = ?"; // 定義更新資料的 SQL 語句

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 創建 Scanner 物件以讀取使用者輸入
		System.out.print("ID: "); // 提示使用者輸入 ID
		int id = scanner.nextInt(); // 讀取使用者輸入的 ID
		System.out.print("Name: "); // 提示使用者輸入姓名
		String name = scanner.next(); // 讀取使用者輸入的姓名
		System.out.print("Tel: "); // 提示使用者輸入電話
		String tel = scanner.next(); // 讀取使用者輸入的電話


		Properties prop = new Properties(); // 創建 Properties 物件
		prop.put("user", USER); // 設定使用者名稱

		try {
			Connection conn = DriverManager.getConnection(URL, prop); // 建立資料庫連線
			PreparedStatement pstmt = conn.prepareStatement(SQL); // 創建 PreparedStatement 物件，用於執行參數化查詢
			pstmt.setString(1, name); // 設定第一個參數為姓名
			pstmt.setString(2, tel); // 設定第二個參數為電話
			pstmt.setInt(3, id); // 設定第三個參數為 ID

			if (pstmt.executeUpdate() > 0) { // 執行更新操作，如果影響的行數大於 0，表示成功
				System.out.println("Success"); // 印出成功訊息
			}else {
				System.out.println("Failure:" + SQL); // 否則印出失敗訊息和 SQL 語句
			}

			System.out.println("Finish"); // 印出完成訊息

		}catch(Exception e) {
			System.out.println(e); // 捕獲並印出任何異常
		}
	}
}