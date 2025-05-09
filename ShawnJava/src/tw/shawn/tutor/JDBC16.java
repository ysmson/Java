package tw.shawn.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
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

public class JDBC16 {
	// 定義資料庫連線的 URL
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義資料庫的使用者名稱
	private static final String USER = "root";

	// 宣告 Connection 物件，用於資料庫連線
	private static Connection conn;
	// 定義查詢 member 表格中指定 id 記錄的 SQL 語句
	private static final String QUERY =
		"SELECT * FROM member WHERE id = ?";

	public static void main(String[] args) {
		// 創建 Properties 物件，用於設定資料庫連線屬性
		Properties prop = new Properties();
		// 設定使用者名稱屬性
		prop.put("user", USER);

		try {
			// 嘗試建立資料庫連線
			conn = DriverManager.getConnection(URL, prop);
			// 創建 PreparedStatement 物件，用於執行帶有參數的 SQL 查詢語句
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			// 設定 SQL 語句中第一個參數的值為要查詢的 id (這裡設定為 3)
			pstmt.setInt(1, 3);
			// 執行查詢，並將結果儲存在 ResultSet 物件中
			ResultSet rs = pstmt.executeQuery();
			// 檢查結果集中是否有下一筆資料，表示查詢到符合條件的記錄
			if (rs.next()) {
				// 從結果集中取得 bike 欄位的二進制流 (InputStream)，該欄位儲存的是序列化後的 Bike 物件
				InputStream in = rs.getBinaryStream("bike");
				//---------
				// 創建 ObjectInputStream 物件，用於從輸入流中讀取 Java 物件
				ObjectInputStream oin = new ObjectInputStream(in);
				// 從 ObjectInputStream 中讀取一個物件
				Object obj = oin.readObject();
				// 將讀取到的物件強制轉換為 Bike 類型
				Bike b1 = (Bike)obj;
				// 印出反序列化得到的 Bike 物件的資訊 (會調用 Bike 類別的 toString 方法)
				System.out.println(b1);

			}

		} catch (Exception e) {
			// 在建立連線、準備語句、執行查詢或物件反序列化等過程中發生任何異常，都將印出錯誤訊息
			System.out.println(e);
		}
	}


}