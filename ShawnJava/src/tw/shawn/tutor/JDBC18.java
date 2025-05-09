package tw.shawn.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC18 {
	// 定義資料庫連線的 URL，這裡連接的是名為 "shawn" 的資料庫
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義資料庫的使用者名稱
	private static final String USER = "root";

	// 定義查詢 gift 表格所有資料的 SQL 語句
	private static final String QUERY = "SELECT * FROM gift";

	public static void main(String[] args) {
		// 創建 Properties 物件，用於設定資料庫連線屬性
		Properties prop = new Properties();
		// 設定使用者名稱屬性
		prop.put("user", USER);

		try {
			// 嘗試建立資料庫連線
			Connection conn = DriverManager.getConnection(URL, prop);
			// 創建 PreparedStatement 物件，並指定 ResultSet 的類型為可滾動且可更新
			PreparedStatement pstmt =
				conn.prepareStatement(QUERY,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
			// 執行查詢，並將結果儲存在 ResultSet 物件中
			ResultSet rs = pstmt.executeQuery();
			// 游標移動到第一筆資料之前 (beforeFirst)，接著使用 next() 移動到第一筆
			rs.next();
			// 取得目前游標所在列的 "name" 欄位值
			String name = rs.getString("name");
			// 印出取得的名稱
			System.out.println(name);

			// 嘗試將游標移動到絕對位置的第四筆資料
			if (rs.absolute(4)) {
				// 如果成功移動到第四筆，則取得該列的 "name" 欄位值
				name = rs.getString("name");
				// 印出取得的名稱
				System.out.println(name);
			} else {
				// 如果移動失敗 (例如資料總數不足四筆)，則印出 "XX"
				System.out.println("XX");
			}

			// 將游標移動到結果集的第一筆資料
			rs.first();
			// 取得目前游標所在列的 "name" 欄位值
			name = rs.getString("name");
			// 印出取得的名稱
			System.out.println(name);

			// 將游標移動到結果集的最後一筆資料
			rs.last();
			// 取得目前游標所在列的 "name" 欄位值
			name = rs.getString("name");
			// 印出取得的名稱
			System.out.println(name);

			// 嘗試將游標移動到目前位置的下一筆資料
			if (rs.next()) {
				// 如果成功移動到下一筆，則印出 "OK"
				System.out.println("OK");
			} else {
				// 如果沒有下一筆資料，則印出 "XX"
				System.out.println("XX");
			}

			// 嘗試將游標移動到絕對位置的第 147 筆資料
			rs.absolute(147);
			// 取得目前游標所在列的 "name" 欄位值
			name = rs.getString("name");
			// 印出取得的名稱
			System.out.println(name);

			// 更新目前游標所在列的 "tel" 欄位值
			rs.updateString("tel", "0912-123456");
			// 更新目前游標所在列的 "name" 欄位值
			rs.updateString("name", "麻辣小魚分享包V2");
			// 將緩衝區中的更新寫回資料庫
			rs.updateRow();

			// 將游標移動到絕對位置的第七筆資料
			rs.absolute(7);
			// 取得目前游標所在列的 "name" 欄位值
			name = rs.getString("name");
			// 印出取得的名稱
			System.out.println(name);

			// 刪除目前游標所在的列
			rs.deleteRow();

			//--------------------
			// 將游標移動到用於插入新列的特殊位置
			rs.moveToInsertRow();
			// 設定要插入新列的 "tel" 欄位值
			rs.updateString("tel", "0912-123456");
			// 設定要插入新列的 "name" 欄位值
			rs.updateString("name", "麻辣小魚分享包V3");
			// 設定要插入新列的 "feature" 欄位值
			rs.updateString("feature", "麻辣小魚粉好吃");
			// 將緩衝區中的新列插入到資料庫
			rs.insertRow();

		} catch (Exception e) {
			// 在建立連線、準備語句、執行查詢或操作 ResultSet 等過程中發生任何異常，都將印出錯誤訊息
			System.out.println(e);
		}
	}

}