package tw.shawn.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Shawn58 {

	public static void main(String[] args) {
		try {
			// 創建一個 URL 物件，指定要連接的 HTTPS 網址
			URL url = new URL("https://www.google.com");
			// 開啟與 URL 的連線，並將其強制轉換為 HttpsURLConnection，以便進行 HTTPS 通訊
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();

			// 加上安全措施避免程式卡住
			conn.setConnectTimeout(5000);  // 設定連線超時時間為 5 秒
			conn.setReadTimeout(5000);    // 設定讀取資料超時時間為 5 秒
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");  // 設定 User-Agent 請求標頭，模擬瀏覽器發送請求

			// 創建 BufferedReader 物件，用於讀取來自伺服器的輸入流
			BufferedReader br = new BufferedReader(
				new InputStreamReader(conn.getInputStream())
			);

			// 宣告一個字串變數 line 和一個 StringBuffer 物件 mesg，用於儲存接收到的網頁內容
			String line;
			StringBuffer mesg = new StringBuffer();
			// 迴圈讀取來自伺服器的每一行資料，直到讀取到 null (表示資料已讀取完畢)
			while ((line = br.readLine()) != null) {
				// 將讀取到的每一行資料附加到 StringBuffer 中，並加上換行符號
				mesg.append(line).append("\n");
			}

			// 關閉 BufferedReader，釋放相關資源
			br.close();
			// 斷開與伺服器的連線
			conn.disconnect();

			// 印出接收到的完整網頁內容
			System.out.println(mesg);
			// 印出 "Finish"，表示程式已成功完成
			System.out.println("Finish");

		} catch (Exception e) {
			// 如果在程式執行過程中發生任何異常，則印出異常的堆疊追蹤資訊，方便除錯
			e.printStackTrace();
		}
	}
}