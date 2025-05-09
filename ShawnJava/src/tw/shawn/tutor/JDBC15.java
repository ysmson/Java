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
	// 定義資料庫連線的 URL
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義資料庫的使用者名稱
	private static final String USER = "root";

	// 宣告 Connection 物件，用於資料庫連線
	private static Connection conn;
	// 定義更新 member 表格中 bike 欄位的 SQL 語句，使用預留位置設定 Bike 物件和 id
	private static final String UPDATE_SQL =
		"UPDATE member SET bike = ? WHERE id = ?";


	public static void main(String[] args) {
		// 創建 Bike 物件
		Bike bike = new Bike();
		// 調用 upSpeed 方法多次，增加 Bike 的速度
		bike.upSpeed(); bike.upSpeed(); bike.upSpeed(); bike.upSpeed();
		bike.upSpeed(); bike.upSpeed(); bike.upSpeed(); bike.upSpeed();
		// 印出 Bike 物件的資訊 (會調用 Bike 類別的 toString 方法)
		System.out.println(bike);

		// 創建 Properties 物件，用於設定資料庫連線屬性
		Properties prop = new Properties();
		// 設定使用者名稱屬性
		prop.put("user", USER);

		try {
			// 嘗試建立資料庫連線
			conn = DriverManager.getConnection(URL, prop);
			// 創建 PreparedStatement 物件，用於執行帶有參數的 SQL 更新語句
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL);

			// 將創建的 Bike 物件設定為 PreparedStatement 的第一個參數
			// JDBC 驅動程式會嘗試將該物件序列化後儲存到資料庫 (假設 bike 欄位支援儲存物件)
			pstmt.setObject(1, bike);
			// 設定 PreparedStatement 的第二個參數為要更新記錄的 id 值 (這裡設定為 8)
			pstmt.setInt(2, 8);
			// 執行更新操作，並判斷受影響的行數是否大於 0
			if (pstmt.executeUpdate() > 0) {
				// 如果更新成功 (受影響的行數大於 0)，則印出 "OK"
				System.out.println("OK");
			} else {
				// 如果更新失敗 (受影響的行數等於 0)，則印出 "XX"
				System.out.println("XX");
			}

		} catch (Exception e) {
			// 在建立連線、準備語句或執行更新等過程中發生任何異常，都將印出錯誤訊息
			System.out.println(e);
		}
	}


}