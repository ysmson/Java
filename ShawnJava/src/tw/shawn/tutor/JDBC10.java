package tw.shawn.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; // 雖然有 import，但在目前的程式碼中沒有被直接使用
import java.util.Properties;
import java.util.Scanner;

// 這個類別 (JDBC10) 的主要功能是讓使用者輸入想要查看的頁碼，然後從 MySQL 資料庫的 gift 資料表中
// 查詢並顯示該頁的禮品 id 和 name。程式會設定每頁顯示 10 筆資料。
public class JDBC10 {
	// 定義 MySQL 資料庫的 JDBC 連線 URL，指定連接到 localhost 的 shawn 資料庫
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義連接 MySQL 資料庫的使用者名稱
	private static final String USER = "root";
	// 定義用於查詢 gift 資料表並進行分頁的 SQL 預備語句
	// 這個 SQL 語句會選取 id 和 name 欄位，並依照 id 欄位進行排序
	// LIMIT 子句用於指定從哪一筆記錄開始選取以及選取多少筆記錄，這裡使用兩個佔位符 ? 來動態設定起始位置和每頁筆數
	private static final String SQL =
		"SELECT id,name FROM gift ORDER BY id LIMIT ?,?";

	// main 方法是程式的入口點
	public static void main(String[] args) {
		// 創建一個 Scanner 物件，用於從控制台讀取使用者的輸入
		Scanner scanner = new Scanner(System.in);
		// 在控制台上印出提示訊息，要求使用者輸入想要查看的頁碼
		System.out.print("頁: ");
		// 讀取使用者在控制台上輸入的整數，並將其儲存到名為 page 的變數中
		int page = scanner.nextInt();
		// 設定每頁顯示的記錄數為 10
		int rpp = 10;
		// 計算在 SQL 查詢中 LIMIT 子句的起始位置
		// 如果使用者輸入的頁碼是 1，則 start 為 (1 - 1) * 10 = 0，表示從第一筆記錄開始
		// 如果使用者輸入的頁碼是 2，則 start 為 (2 - 1) * 10 = 10，表示從第 11 筆記錄開始
		int start = (page - 1) * rpp;
		// 在控制台上印出一行分隔線
		System.out.println("---");

		// 創建一個 Properties 物件，用於儲存資料庫連線的屬性
		Properties prop = new Properties();
		// 設定資料庫連線的使用者名稱
		prop.put("user", USER);
		// 使用 try-catch 區塊來處理可能發生的資料庫連線或操作異常
		try {
			// 建立與 MySQL 資料庫的連線
			Connection conn = DriverManager.getConnection(URL, prop);
			// 創建一個 PreparedStatement 物件，用於執行帶有參數的 SQL 查詢語句
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			// 將計算得到的起始位置 start 設定到 SQL 語句的第一個參數（對應 LIMIT ?,? 中的第一個 ?）
			pstmt.setInt(1, start);
			// 將每頁顯示的記錄數 rpp 設定到 SQL 語句的第二個參數（對應 LIMIT ?,? 中的第二個 ?）
			pstmt.setInt(2, rpp);
			// 執行 SQL 查詢，並將查詢結果儲存到 ResultSet 物件 rs 中
			ResultSet rs = pstmt.executeQuery();
			// 使用 while 迴圈遍歷 ResultSet 中的每一行記錄
			while (rs.next()) {
				// 從當前記錄中取得 id 欄位的值
				String id = rs.getString("id");
				// 從當前記錄中取得 name 欄位的值
				String name = rs.getString("name");
				// 使用 printf 格式化輸出查詢到的禮品 id 和 name
				System.out.printf("%s:%s\n", id, name);
			}

			// 在成功查詢並顯示完指定頁碼的資料後，印出 "Finish" 到控制台
			System.out.println("Finish");

		}catch(Exception e) {
			// 如果在資料庫連線或操作過程中發生任何異常，將異常資訊印出到控制台
			System.out.println(e);
		}
	}
}