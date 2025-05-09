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

public class JDBC11 {
	// 定義資料庫連線的 URL
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義資料庫的使用者名稱
	private static final String USER = "root";

	// 宣告 Connection 物件，用於資料庫連線
	private static Connection conn;

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
		// 提示使用者輸入姓名
		System.out.print("Name:");
		// 讀取使用者輸入的姓名
		String cname = scaner.next();
		// 輸出分隔線
		System.out.println("-----");

		// 創建 Properties 物件，用於設定連線屬性
		Properties prop = new Properties();
		// 設定使用者名稱屬性
		prop.put("user", USER);

		try {
			// 嘗試建立資料庫連線
			conn = DriverManager.getConnection(URL, prop);
			// 檢查帳號是否已存在
			if (!isAccountExist(account)) {
				// 如果帳號不存在，則嘗試註冊帳號
				try {
					registerAccount(account, passwd, cname);
				} catch (Exception e) {
					// 註冊失敗時，印出錯誤訊息
					System.out.println(e);
				}
			} else {
				// 如果帳號已存在，則印出提示訊息
				System.out.println("Account EXIST!");
			}
		} catch (Exception e) {
			// 連線失敗時，印出錯誤訊息
			System.out.println(e);
		}
	}

	// 檢查帳號是否已存在的靜態方法
	private static boolean isAccountExist(String account) {
		// 定義 SQL 查詢語句，查詢指定帳號的數量
		String sql = "SELECT count(account) count FROM member WHERE account = ?";
		try {
			// 創建 PreparedStatement 物件，用於執行帶有參數的 SQL 語句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 設定 SQL 語句中第一個參數的值為傳入的帳號
			pstmt.setString(1, account);
			// 執行查詢，並將結果儲存在 ResultSet 物件中
			ResultSet rs = pstmt.executeQuery();
			// 將游標移動到結果集的第一列
			rs.next();
			// 返回查詢到的帳號數量是否大於 0，表示帳號是否存在
			return rs.getInt("count") > 0;
		} catch (SQLException e) {
			// 查詢過程中發生 SQL 異常時，印出錯誤訊息
			System.out.println(e);
		}

		// 如果發生異常或查詢結果為空，則返回 false，表示帳號不存在
		return false;
	}

	// 註冊帳號的靜態方法
	private static void registerAccount(
				String account,
				String passwd,
				String cname)
			throws Exception{
		// 定義 SQL 插入語句，將帳號、加密後的密碼和姓名插入到 member 表格中
		String sql = "INSERT INTO member (account,passwd,cname) VALUES (?,?,?)";
		// 使用 BCrypt 加密使用者輸入的密碼
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		// 創建 PreparedStatement 物件
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 設定 SQL 語句中第一個參數的值為傳入的帳號
		pstmt.setString(1, account);
		// 設定 SQL 語句中第二個參數的值為加密後的密碼
		pstmt.setString(2, hashPasswd);
		// 設定 SQL 語句中第三個參數的值為傳入的姓名
		pstmt.setString(3, cname);
		// 執行插入操作，如果受影響的行數為 0，表示插入失敗
		if (pstmt.executeUpdate() == 0) {
			// 拋出自定義的 Exception，提示更新失敗
			throw new Exception("Update Failure");
		}

	}

}