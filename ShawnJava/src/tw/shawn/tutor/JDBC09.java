package tw.shawn.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; // 雖然有 import，但在目前的程式碼中沒有被直接使用
import java.util.Properties;
import java.util.Scanner;

// 這個類別 (JDBC09) 的主要功能是讓使用者輸入關鍵字，然後在 MySQL 資料庫的 gift 資料表中
// 搜尋符合該關鍵字（在名稱、特色、城市或鄉鎮中包含）的禮品資訊，並將結果顯示在控制台上。
public class JDBC09 {
	// 定義 MySQL 資料庫的 JDBC 連線 URL，指定連接到 localhost 的 shawn 資料庫 (注意這裡與之前的程式碼不同)
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義連接 MySQL 資料庫的使用者名稱
	private static final String USER = "root";

	// 定義用於查詢 gift 資料表的 SQL 預備語句
	// 這個 SQL 語句會選取 id, name (別名為 pname), feature, city, town 這幾個欄位
	// WHERE 子句使用 LIKE 運算符，搭配通配符 %，來模糊搜尋符合關鍵字的記錄
	// 關鍵字會在 name, feature, city, town 這四個欄位中進行比對
	private static final String SQL =
		"SELECT id,name pname, feature,city,town FROM gift " +
			"WHERE name LIKE ? OR feature LIKE ? OR city LIKE ? OR town LIKE ?";

	// main 方法是程式的入口點
	public static void main(String[] args) {
		// 創建一個 Scanner 物件，用於從控制台讀取使用者的輸入
		Scanner scaner = new Scanner(System.in);
		// 在控制台上印出提示訊息，要求使用者輸入關鍵字
		System.out.print("Keyword:");
		// 讀取使用者在控制台上輸入的下一行字串，並將其儲存到名為 search 的變數中
		String search = scaner.next();
		// 在控制台上印出一行分隔線
		System.out.println("-----");

		// 將使用者輸入的關鍵字前後加上 %，以便在 SQL LIKE 查詢中進行模糊比對
		String kw = "%" + search + "%";
		// 創建一個 Properties 物件，用於儲存資料庫連線的屬性
		Properties prop = new Properties();
		// 設定資料庫連線的使用者名稱
		prop.put("user", USER);

		// 使用 try-catch 區塊來處理可能發生的資料庫連線或操作異常
		try {
			// 建立與 MySQL 資料庫的連線 (連接到 'shawn' 資料庫)
			Connection conn = DriverManager.getConnection(URL, prop);
			// 創建一個 PreparedStatement 物件，用於執行帶有參數的 SQL 查詢語句
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			// 將處理後的關鍵字 kw 設定到 SQL 語句的第一個參數（對應 name LIKE ? 中的 ?）
			pstmt.setString(1, kw);
			// 將處理後的關鍵字 kw 設定到 SQL 語句的第二個參數（對應 feature LIKE ? 中的 ?）
			pstmt.setString(2, kw);
			// 將處理後的關鍵字 kw 設定到 SQL 語句的第三個參數（對應 city LIKE ? 中的 ?）
			pstmt.setString(3, kw);
			// 將處理後的關鍵字 kw 設定到 SQL 語句的第四個參數（對應 town LIKE ? 中的 ?）
			pstmt.setString(4, kw);

			// 執行 SQL 查詢，並將查詢結果儲存到 ResultSet 物件 rs 中
			ResultSet rs = pstmt.executeQuery();
			// 使用 while 迴圈遍歷 ResultSet 中的每一行記錄
			while (rs.next()) {
				// 從當前記錄中取得 id 欄位的值
				String id = rs.getString("id");
				// 從當前記錄中取得 name 欄位的值，由於在 SQL 語句中使用了別名 pname，所以這裡使用 "pname"
				String name = rs.getString("pname");
				// 從當前記錄中取得 feature 欄位的值
				String feature = rs.getString("feature");
				// 從當前記錄中取得 city 欄位的值
				String city = rs.getString("city");
				// 從當前記錄中取得 town 欄位的值
				String town = rs.getString("town");
				// 使用 printf 格式化輸出查詢到的禮品資訊，包括 id, name, feature, city, town
				System.out.printf("%s:%s:%s:%s:%s\n", id, name, feature, city, town);
			}

		}catch(Exception e) {
			// 如果在資料庫連線或操作過程中發生任何異常，將異常資訊印出到控制台
			System.out.println(e);
		}
	}
}