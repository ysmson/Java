package tw.shawn.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // 雖然有 import，但在目前的程式碼中沒有被使用到
import java.sql.Statement;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * 這個類別 (JDBC08) 的主要功能是從指定的政府開放資料平台 URL
 * (https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx)
 * 讀取農產品相關的 JSON 資料，然後將這些資料解析後寫入到名為 shawn 資料庫中的 gift 資料表。
 */
public class JDBC08 {
	// 定義資料來源的 URL，指向農產品開放資料 API
	private static final String dataUrl = "https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx";
	// 定義 MySQL 資料庫的 JDBC 連線 URL，指定連接到 localhost 的 shawn 資料庫
	private static final String URL = "jdbc:mysql://localhost/shawn";
	// 定義連接 MySQL 資料庫的使用者名稱
	private static final String USER = "root";

	// 定義用於向 gift 資料表插入資料的 SQL 預備語句
	// 資料表的欄位依序為：name, feature, tel, picurl, city, town, lat, lng
	private static final String SQL =
		"INSERT INTO gift (name,feature,tel,picurl,city,town,lat,lng)" +
				" VALUES (?,?,?,?,?,?,?,?)";

	// main 方法是程式的入口點
	public static void main(String[] args) {
		try {
			// 創建一個 URL 物件，指向要讀取的資料來源
			URL url = new URL(dataUrl);
			// 開啟一個 HTTPS 連線到指定的 URL
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();

			// 創建一個 BufferedReader 物件，用於讀取來自連線的輸入流
			BufferedReader br =
					new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
			String line;
			// 創建一個 StringBuffer 物件，用於儲存從輸入流讀取的資料
			StringBuffer mesg = new StringBuffer();
			// 逐行讀取輸入流的內容，直到沒有更多行為止
			while ( (line = br.readLine()) != null) {
				// 將讀取到的每一行資料附加到 StringBuffer 中
				mesg.append(line);
			}

			// 關閉 BufferedReader，釋放相關資源
			br.close();
			// 調用 insertData 方法，將讀取到的 JSON 字串傳遞給它進行資料庫寫入操作
			insertData(mesg.toString());
		} catch (Exception e) {
			// 如果在上述過程中發生任何異常，將異常的堆疊追蹤資訊印出到控制台
			e.printStackTrace();
		}
	}

	// insertData 方法接收一個 JSON 字串，並將其解析後插入到 MySQL 資料庫的 gift 資料表中
	private static void insertData(String json) {
		// 創建一個 Properties 物件，用於儲存資料庫連線的屬性
		Properties prop = new Properties();
		// 設定資料庫連線的使用者名稱
		prop.put("user", USER);

		// 使用 try-with-resources 語句建立資料庫連線，確保連線在使用完畢後會自動關閉
		try (Connection conn = DriverManager.getConnection(URL, prop)){
			// 定義刪除 gift 資料表中所有資料的 SQL 語句
			String delAll = "DELETE FROM gift";
			// 創建一個 Statement 物件，用於執行靜態 SQL 語句
			Statement stmt = conn.createStatement();
			// 執行刪除所有資料的 SQL 語句
			stmt.execute(delAll);

			// 定義重設 gift 資料表 AUTO_INCREMENT 值為 1 的 SQL 語句
			String zero = "ALTER TABLE gift AUTO_INCREMENT = 1";
			// 執行重設 AUTO_INCREMENT 值的 SQL 語句
			stmt.execute(zero);

			// 創建一個 PreparedStatement 物件，用於執行帶有參數的 SQL 插入語句
			PreparedStatement pstmt = conn.prepareStatement(SQL);

			// 創建一個 JSONArray 物件，將傳入的 JSON 字串解析為 JSON 陣列
			JSONArray root = new JSONArray(json);
			// 遍歷 JSON 陣列中的每一個 JSON 物件（代表一筆農產品資料）
			for (int i=0; i<root.length(); i++) {
				// 取得當前索引位置的 JSON 物件
				JSONObject row = root.getJSONObject(i);
				// 從 JSON 物件中取得各個欄位的值
				String name = row.getString("Name");
				String feature = row.getString("Feature");
				String tel = row.getString("ContactTel");
				String picurl = row.getString("Column1");
				String city = row.getString("County");
				String town = row.getString("Township");
				String lat = row.getString("Latitude");
				String lng = row.getString("Longitude");

				// 將取得的值設定到 PreparedStatement 的對應參數位置
				pstmt.setString(1, name);
				pstmt.setString(2, feature);
				pstmt.setString(3, tel);
				pstmt.setString(4, picurl);
				pstmt.setString(5, city);
				pstmt.setString(6, town);

				// 嘗試將經緯度字串轉換為 Double 型別，並設定到 PreparedStatement 的對應參數位置
				try {
					pstmt.setDouble(7, Double.parseDouble(lat));
					pstmt.setDouble(8, Double.parseDouble(lng));
				}catch(Exception e) {
					// 如果轉換失敗（例如，經緯度不是有效的數字格式），則將經緯度設定為 0.0
					pstmt.setDouble(7, 0.0);
					pstmt.setDouble(8, 0.0);
				}

				// 執行 PreparedStatement，將當前這筆農產品資料插入到資料庫中
				pstmt.executeUpdate();
			}
			// 在所有資料插入完成後，印出 "Finish" 到控制台
			System.out.println("Finish");
		}catch(Exception e) {
			// 如果在資料庫操作過程中發生任何異常，將異常資訊印出到控制台
			System.out.println(e);
		}
	}
}