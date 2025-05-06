package tw.shawn.tutor;

import java.io.FileReader;  // 用於讀取檔案的字符輸入流

public class Shawn47 {
	public static void main(String[] args) {
		try {
			// 創建 FileReader 物件，用於讀取指定路徑的文字檔案
			FileReader reader = new FileReader("dir1/file2.txt");
			
			int c;
			// 使用 while 迴圈從檔案中逐字符讀取，直到檔案結束（即 read() 返回 -1）
			while ((c = reader.read()) != -1) {
				// 讀取的字符會以整數表示，轉換為字符並顯示
				System.out.print((char)c);
			}
			
			// 讀取完畢後關閉 FileReader
			reader.close();
			System.out.println("OK"); // 印出 OK，表示成功讀取檔案
		} catch (Exception e) {
			// 如果發生任何異常，顯示錯誤訊息
			System.out.println(e);
		}
	}
}
