package tw.shawn.tutor;

import java.io.FileInputStream;

public class Shawn46 {
	public static void main(String[] args) {
		try {
			// 創建 FileInputStream 物件，指向要讀取的檔案
			FileInputStream fin = new FileInputStream("dir1/file2.txt");
			
			int c;
			// 使用 while 迴圈從檔案中讀取字元，直到檔案結束 (即 read() 返回 -1)
			while ( (c = fin.read()) != -1) {
				// 將讀取的字元 (整數) 轉換為字元並顯示
				System.out.print((char)c);
			}
			
			// 關閉 FileInputStream，釋放檔案資源
			fin.close();
			//System.out.println("OK"); // 這行可以移除，因為程式已經在顯示檔案內容
		} catch (Exception e) {
			// 捕捉並顯示異常
			System.out.println(e);
		}
	}
}
