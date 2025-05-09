package tw.shawn.tutor;

public class JDBC01 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 載入 MySQL JDBC 驅動程式類別。這是連接 MySQL 資料庫的第一步。
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 註解掉的程式碼，用於載入 SQL Server JDBC 驅動程式類別。如果需要連接 SQL Server，可以取消註解這一行。
			System.out.println("OK"); // 如果成功載入 JDBC 驅動程式，則印出 "OK"。
		} catch (ClassNotFoundException e) {
			System.out.println(e); // 如果找不到指定的驅動程式類別，則捕獲 ClassNotFoundException 異常並印出異常訊息。這通常表示 JDBC 驅動程式的 JAR 檔案沒有被加入到專案的類別路徑中。
		}
	}

}