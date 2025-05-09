package tw.shawn.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Shawn60 {

	public static void main(String[] args) {
		// 定義要轉換為 PDF 的目標網址
		String target = "https://www.pchome.com.tw";
		try {
			// 創建一個 URL 物件，使用 pdfmyurl.com 的服務將目標網址轉換為 PDF
			URL url = new URL(String.format("https://pdfmyurl.com/?url=%s", target));
			// 開啟與 URL 的連線，並將其強制轉換為 HttpsURLConnection，以便進行 HTTPS 通訊
			HttpsURLConnection conn =
				(HttpsURLConnection)url.openConnection();

			// 創建 BufferedInputStream 物件，用於高效地從伺服器讀取輸入流 (PDF 資料)
			BufferedInputStream br =
				new BufferedInputStream(conn.getInputStream());
			// 創建 BufferedOutputStream 物件，用於高效地將資料寫入到本地檔案 (PDF 檔案)
			BufferedOutputStream bout =
				new BufferedOutputStream(new FileOutputStream("dir2/yahoo.pdf"));
			// 創建一個 byte 陣列作為緩衝區，用於讀取和寫入資料
			byte[] buf = new byte[4 * 1024];
			// 宣告一個整數變數 len，用於儲存每次讀取的位元組數
			int len;
			// 迴圈讀取輸入流中的資料，直到讀取到 -1 (表示資料已讀取完畢)
			while ((len = br.read(buf)) != -1) {
				// 將緩衝區中的資料寫入到輸出流 (本地 PDF 檔案)
				bout.write(buf, 0, len);
			}
			// 強制將 BufferedOutputStream 緩衝區中的所有資料寫入到檔案
			bout.flush();
			// 關閉 BufferedOutputStream，釋放相關資源
			bout.close();
			// 關閉 BufferedInputStream，釋放相關資源
			br.close();

			// 印出 "Finish"，表示將網頁轉換為 PDF 並儲存成功
			System.out.println("Finish");
		} catch (Exception e) {
			// 如果在程式執行過程中發生任何異常，則印出異常的堆疊追蹤資訊，方便除錯
			e.printStackTrace();
		}
	}

}