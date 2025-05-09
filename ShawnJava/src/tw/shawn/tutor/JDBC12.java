package tw.shawn.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.shawn.apis.BCrypt;

public class JDBC12 {
	// 定義資料庫連線的 URL
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義資料庫的使用者名稱
	private static final String USER = "root";

	// 宣告 Connection 物件，用於資料庫連線
	private static Connection conn;
	// 定義登入查詢的 SQL 語句
	private static final String LOGIN =
		"SELECT * FROM member WHERE account = ?";


	public static void main(String[] args) {
		// 創建 Scanner 物件，用於接收使用者輸入
		Scanner scaner = new Scanner(System.in);
		// 提示使用者輸入帳號
		System.out.print("Account:");
		// 讀取使用者輸入的帳號
		String account = scaner.next();
		// 提示使用者輸入密碼
		System.out.print("Password:");
		// 讀取使用者輸入的密碼
		String passwd = scaner.next();
		// 輸出分隔線
		System.out.println("-----");

		// 創建 Properties 物件，用於設定資料庫連線屬性
		Properties prop = new Properties();
		// 設定使用者名稱屬性
		prop.put("user", USER);

		try {
			// 嘗試建立資料庫連線
			conn = DriverManager.getConnection(URL, prop);
			// 創建 PreparedStatement 物件，用於執行帶有參數的 SQL 查詢語句
			PreparedStatement pstmt = conn.prepareStatement(LOGIN);
			// 設定 SQL 語句中第一個參數的值為使用者輸入的帳號
			pstmt.setString(1, account);
			// 執行查詢，並將結果儲存在 ResultSet 物件中
			ResultSet rs = pstmt.executeQuery();
			// 檢查結果集中是否有下一筆資料，表示查詢到符合條件的帳號
			if (rs.next()) {
				// 從結果集中取得儲存的加密密碼
				String hashPasswd = rs.getString("passwd");
				// 使用 BCrypt 的 checkpw 方法驗證使用者輸入的密碼是否與資料庫中加密的密碼匹配
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					// 如果密碼驗證成功，則印出歡迎訊息，並顯示使用者的姓名
					System.out.printf("Welcome, %s", rs.getString("cname"));
				} else {
					// 如果密碼驗證失敗，則印出登入失敗的訊息 (錯誤代碼 2)
					System.out.println("Login Failure(2)");
				}
			} else {
				// 如果結果集中沒有資料，表示沒有找到對應的帳號，印出登入失敗的訊息 (錯誤代碼 1)
				System.out.println("Login Failure(1)");
			}


		} catch (Exception e) {
			// 連線或查詢過程中發生異常時，印出錯誤訊息
			System.out.println(e);
		}
	}


}