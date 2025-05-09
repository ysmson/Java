package tw.shawn.tutor;

import java.sql.Connection; // 導入用於表示資料庫連線的類別
import java.sql.DriverManager; // 導入用於建立資料庫連線的類別
import java.sql.SQLException; // 導入處理 SQL 相關異常的類別
import java.util.Properties; // 導入用於設定連線屬性的類別

public class JDBC02 {

	public static void main(String[] args) {
		// http://localhost:8080/
		/*
		 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl =
			"jdbc:sqlserver://localhost;encrypt=true;database=AdventureWorks;integratedSecurity=true;"
			Connection con = DriverManager.getConnection(connectionUrl);
		 */
		// 上方是被註解掉的程式碼片段，用於連接 Microsoft SQL Server 資料庫。
		// 它首先載入 SQL Server 的 JDBC 驅動程式，然後使用提供的連接 URL 建立連線。
		// 該 URL 包含了伺服器位址、是否加密、資料庫名稱以及是否使用整合安全性。

		/*
		String url = "jdbc:mysql://localhost/db1?user=root&password=";
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("OK");
		} catch (SQLException e) {
			System.out.println(e);
		}
		*/
		// 上方是被註解掉的程式碼片段，嘗試使用 URL 直接指定使用者名稱和密碼來連接 MySQL 資料庫 db1。
		// 但密碼部分為空字串。如果連接失敗，會捕獲 SQLException 並印出錯誤訊息。

		/*
		String url = "jdbc:mysql://localhost/db1";
		try {
			Connection conn = DriverManager.getConnection(url, "root", "");
			System.out.println("OK1");
		}catch(Exception e) {
			System.out.println(e);
		}
		*/
		// 上方是被註解掉的程式碼片段，嘗試使用 DriverManager 的另一個重載方法來連接 MySQL 資料庫 db1。
		// 它將 URL、使用者名稱 "root" 和空字串密碼作為參數傳遞。如果連接失敗，會捕獲 Exception 並印出錯誤訊息。

		String url = "jdbc:mysql://localhost/db1"; // 定義資料庫的連接 URL，指定連接到本機的 db1 資料庫
		Properties prop = new Properties(); // 創建一個 Properties 物件，用於儲存資料庫連線的屬性
		prop.put("user", "root"); // 設定連接屬性中的使用者名稱為 "root"
		prop.put("password", ""); // 設定連接屬性中的密碼為空字串
		try {
			Connection conn = DriverManager.getConnection(url, prop); // 使用 DriverManager 的 getConnection 方法，根據 URL 和屬性建立資料庫連線
			System.out.println("OK2"); // 如果成功建立連線，則印出 "OK2"
		}catch(Exception e) {
			System.out.println(e); // 如果在建立連線的過程中發生任何異常，則捕獲 Exception 並印出異常訊息
		}
	}

}