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

public class JDBC14 {
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
				// 從結果集中取得帳號資訊
				String account = rs.getString("account");
				// 從結果集中取得 icon 欄位的二進制流 (InputStream)
				InputStream in = rs.getBinaryStream("icon");
				// 創建一個新的 Thread 來處理將 icon 寫入檔案的操作，避免阻塞主執行緒
				new Thread(){
					// 覆寫 Thread 的 run 方法，定義執行內容
					public void run() {
						try {
							// 根據帳號產生檔案名稱，儲存為 PNG 格式
							String filename = String.format("dir2/%s.png", account);
							// 創建 FileOutputStream 物件，用於將資料寫入指定檔案
							FileOutputStream fout = new FileOutputStream(filename);

							// 創建緩衝區，用於讀取輸入流的資料
							byte[] buf = new byte[128 * 1024];
							// 從輸入流中讀取資料到緩衝區，並取得實際讀取的長度
							int len = in.read(buf);

							// 將緩衝區中的資料寫入輸出流 (檔案)
							fout.write(buf, 0, len);
							// 強制將緩衝區中的資料寫入檔案
							fout.flush();
							// 關閉輸出流，釋放資源
							fout.close();
							// 列印 "OK"，表示檔案寫入成功
							System.out.println("OK");
						} catch (Exception e) {
							// 在檔案操作過程中發生任何異常，都將印出錯誤訊息
							System.out.println(e);
						}
					}
				}.start();
				// 在主執行緒中印出 "Writing..."，表示開始寫入檔案的操作 (在新的 Thread 中進行)
				System.out.println("Writing...");
			}

		} catch (Exception e) {
			// 在建立連線、準備語句或執行查詢等過程中發生任何異常，都將印出錯誤訊息
			System.out.println(e);
		}
	}


}