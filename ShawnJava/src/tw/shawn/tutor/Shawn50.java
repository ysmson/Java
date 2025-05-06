package tw.shawn.tutor;

import java.io.BufferedReader;
import java.io.FileReader;

public class Shawn50 {

	public static void main(String[] args) {
		// 使用 try-with-resources 自動關閉資源
		try (FileReader reader = new FileReader("dir1/ns1hosp.csv"); // 打開文件的字符輸入流
				BufferedReader br = new BufferedReader(reader);){ // 封裝成 BufferedReader 來逐行讀取
				
			// 跳過 CSV 檔案的標題行
			br.readLine();
			
			String line;
			// 逐行讀取檔案內容
			while ((line = br.readLine()) != null) {
				// 使用逗號分隔每一行的資料，並存入字串陣列
				String[] data = line.split(",");
				
				// 假設我們需要印出第 3 欄（索引 2）和第 5 欄（索引 4）的資料
				System.out.printf("%s : %s\n", data[2], data[4]);
			}
			
		} catch (Exception e) { // 捕捉任何異常並印出錯誤訊息
			System.out.println(e);
		}
	}
}
