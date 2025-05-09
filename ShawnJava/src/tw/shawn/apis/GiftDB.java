package tw.shawn.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

public class GiftDB {
	// 定義資料庫連線的 URL，這裡連接的是名為 "shawn" 的資料庫
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義資料庫的使用者名稱
	private static final String USER = "root";

	// 宣告 Connection 物件，用於資料庫連線
	private static Connection conn;	// 資料庫連線物件
	// 定義查詢 gift 表格所有欄位的 SQL 語句，並使用 AS 關鍵字為欄位設定中文別名
	private static final String SQL = "SELECT id 編號, name 名稱, feature 特色, tel 電話 FROM gift";
	// 宣告 ResultSet 物件，用於儲存查詢結果集
	private ResultSet rs;
	// 宣告字串陣列，用於儲存查詢結果的欄位名稱 (或別名)
	private String[] fieldNames;

	// GiftDB 類的建構子，在創建 GiftDB 物件時會自動執行
	public GiftDB() throws Exception {
		// 創建 Properties 物件，用於設定資料庫連線屬性
		Properties prop = new Properties();
		// 設定使用者名稱屬性
		prop.put("user", USER);

		// 建立資料庫連線
		conn = DriverManager.getConnection(URL, prop);
		// 調用 queryDB 方法執行查詢並初始化相關資料
		queryDB();
	}

	// 私有方法，用於執行預設的 SQL 查詢
	private void queryDB()  throws Exception {
		queryDB(SQL);
	}

	// 私有方法，用於執行指定的 SQL 查詢
	private void queryDB(String sql) throws Exception{
		// 創建 Statement 物件，並設定 ResultSet 的類型為可滾動且不敏感，並可更新
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		// 執行 SQL 查詢，並將結果儲存在 ResultSet 物件中
		rs = stmt.executeQuery(sql);

		// 取得 ResultSet 的元資料，包含欄位資訊
		ResultSetMetaData rsmd = rs.getMetaData();
		// 根據欄位數量創建字串陣列，用於儲存欄位名稱
		fieldNames = new String[rsmd.getColumnCount()];
		// 迭代取得每個欄位的標籤 (getColumnLabel)，這裡會是 SQL 語句中設定的別名
		for (int i=1; i<=fieldNames.length; i++) {
			fieldNames[i-1] = rsmd.getColumnLabel(i);
			//System.out.println(fieldNames[i-1]);
		}

	}

	// 公有方法，用於取得結果集的總行數
	public int getRows() {
		try {
			// 將游標移動到最後一行
			rs.last();
			// 返回目前游標所在的行號，即總行數
			return rs.getRow();
		}catch(Exception e) {
			// 發生異常時返回 0
			return 0;
		}
	}

	// 公有方法，用於取得結果集的總欄數
	public int getCols() {
		// 返回儲存的欄位名稱陣列的長度，即總欄數
		return fieldNames.length;
	}

	// 公有方法，用於取得指定行列的資料 (行列索引皆為 0-based)
	public String getData(int row, int col) {
		try {
			// 將游標移動到指定的行 (absolute 方法的參數是 1-based，所以要加 1)
			rs.absolute(row+1);
			// 取得指定列的資料 (getString 方法的參數也是 1-based，所以要加 1)
			return rs.getString(col+1);
		}catch(Exception e) {
			// 發生異常時返回 "ERROR"
			return "ERROR";
		}
	}

	// 公有方法，用於刪除指定行的資料 (行索引為 0-based)
	public void delData(int row) {
		try {
			// 將游標移動到指定的行
			rs.absolute(row+1);
			// 刪除目前游標所在的行
			rs.deleteRow();
		}catch(Exception e) {
			// 發生異常時印出錯誤訊息
			System.out.println(e);
		}
	}

	// 公有方法，用於更新指定行列的資料 (行列索引皆為 0-based)
	public void updateData(String newdata, int row, int col) {
		// 檢查要更新的欄位索引是否在有效範圍內 (假設表格有 6 個欄位)
		if (col >= 0 && col < fieldNames.length) {
			try {
				// 將游標移動到指定的行
				rs.absolute(row+1);
				// 更新指定列的資料
				rs.updateString(col+1, newdata);;
				// 將緩衝區中的更新寫回資料庫
				rs.updateRow();
			}catch(Exception e) {
				// 發生異常時印出錯誤訊息
				System.out.println(e);
			}
		}
	}

	// 公有方法，用於取得所有欄位的名稱 (或別名)
	public String[] getColNames() {
		return fieldNames;
	}

}