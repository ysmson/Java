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
	// 定義資料庫連線的 URL
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義資料庫的使用者名稱
	private static final String USER = "root";

	// 宣告 Connection 物件，用於資料庫連線
	private static Connection conn;
	// 定義更新 member 表格中 icon 欄位的 SQL 語句，使用預留位置設定 icon 資料和 id
	private static final String UPDATE_SQL =
		"UPDATE member SET icon = ? WHERE id = ?";


	public static void main(String[] args) {
		// 創建 Properties 物件，用於設定資料庫連線屬性
		Properties prop = new Properties();
		// 設定使用者名稱屬性
		prop.put("user", USER);

		try {
			// 嘗試建立資料庫連線
			conn = DriverManager.getConnection(URL, prop);
			// 創建 PreparedStatement 物件，用於執行帶有參數的 SQL 更新語句
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL);

			// 創建 FileInputStream 物件，用於讀取指定路徑的圖片檔案
			FileInputStream fin = new FileInputStream("dir2/yahoo.jpg");

			// 將 FileInputStream 設定為 PreparedStatement 的第一個參數，以二進制流的形式傳遞圖片資料
			pstmt.setBinaryStream(1, fin);
			// 設定 PreparedStatement 的第二個參數為要更新記錄的 id 值 (這裡設定為 8)
			pstmt.setInt(2, 8);
			// 執行更新操作，並判斷受影響的行數是否大於 0
			if (pstmt.executeUpdate() > 0) {
				// 如果更新成功 (受影響的行數大於 0)，則印出 "Success"
				System.out.println("Success");
			} else {
				// 如果更新失敗 (受影響的行數等於 0)，則印出 "Failure"
				System.out.println("Failure");
			}

			// 關閉 FileInputStream，釋放資源
			fin.close();

		} catch (Exception e) {
			// 在建立連線、準備語句或執行更新等過程中發生任何異常，都將印出錯誤訊息
			System.out.println(e);
		}
	}


}