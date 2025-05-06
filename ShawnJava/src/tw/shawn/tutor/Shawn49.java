package tw.shawn.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Shawn49 {

	public static void main(String[] args) {
		// 使用 try-with-resources 來自動關閉流，確保資源得到釋放
		try (FileInputStream fin = new FileInputStream("dir1/ns1hosp.csv"); // 打開檔案輸入流
				InputStreamReader in = new InputStreamReader(fin);  // 將 FileInputStream 轉換為字符流
				BufferedReader br = new BufferedReader(in);) { // 包裝成 BufferedReader 來更高效地讀取行
			
			// 跳過第一行 (通常是 CSV 檔案的標題行)
			br.readLine();
			
			String line;
			// 讀取每一行直到檔案結尾
			while ((line = br.readLine()) != null) {
				// 使用逗號作為分隔符分割每一行，並存儲在陣列中
				String[] data = line.split(",");
				
				// 假設我們需要印出第 3 欄（索引 2）和第 8 欄（索引 7）的資料
				System.out.printf("%s : %s\n", data[2], data[7]);
			}
			
		} catch (Exception e) {  // 捕捉異常，並印出錯誤訊息
			System.out.println(e);
		}
	}
}
