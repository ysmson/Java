package tw.shawn.tutor;

import java.sql.Connection; // 導入用於表示資料庫連線的類別
import java.sql.DriverManager; // 導入用於建立資料庫連線的類別
import java.sql.Statement; // 導入用於執行 SQL 語句的類別
import java.util.Properties; // 導入用於設定連線屬性的類別

public class JDBC03 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/shawn"; // 定義資料庫的連接 URL，指定連接到本機的 shawn 資料庫
		Properties prop = new Properties(); // 創建一個 Properties 物件，用於儲存資料庫連線的屬性
		prop.put("user", "root"); // 設定連接屬性中的使用者名稱為 "root"
		prop.put("password", ""); // 設定連接屬性中的密碼為空字串
		try {
			Connection conn = DriverManager.getConnection(url, prop); // 使用 DriverManager 的 getConnection 方法，根據 URL 和屬性建立資料庫連線

			Statement stmt = conn.createStatement(); // 創建一個 Statement 物件，用於執行 SQL 語句
			String sql = "INSERT INTO cust (cname,tel,birthday)" + // 定義插入資料的 SQL 語句
						" VALUES ('shawn','123','1999-01-02')"; // 指定要插入的欄位 (cname, tel, birthday) 和對應的值
			int n = stmt.executeUpdate(sql); // 執行插入 SQL 語句，executeUpdate() 方法返回受影響的行數
			System.out.println(n); // 印出插入操作影響的行數

			String delSQL = "DELETE FROM cust WHERE id = 3"; // 定義刪除資料的 SQL 語句，刪除 id 等於 3 的記錄
			n = stmt.executeUpdate(delSQL); // 執行刪除 SQL 語句，executeUpdate() 方法返回受影響的行數
			System.out.println(n); // 印出刪除操作影響的行數

			String updateSQL = "UPDATE cust SET tel = '321', cname='Tony' WHERE id = 4"; // 定義更新資料的 SQL 語句，將 id 等於 4 的記錄的 tel 更新為 '321'，cname 更新為 'Tony'
			n = stmt.executeUpdate(updateSQL); // 執行更新 SQL 語句，executeUpdate() 方法返回受影響的行數
			System.out.println(n); // 印出更新操作影響的行數

		}catch(Exception e) {
			System.out.println(e); // 如果在執行資料庫操作的過程中發生任何異常，則捕獲 Exception 並印出異常訊息
		}
	}

}