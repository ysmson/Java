package tw.shawn.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;  // 用於檔案輸入和輸出流

public class Shawn48 {

	public static void main(String[] args) {
		try {
			// 創建檔案輸出流 (FileOutputStream)，將資料寫入 "dir2/coffee.jpg" 檔案
			FileOutputStream fout = new FileOutputStream("dir2/coffee.jpg");
			// 創建檔案輸入流 (FileInputStream)，從 "dir1/coffee.jpg" 檔案讀取資料
			FileInputStream fin = new FileInputStream("dir1/coffee.jpg");

			int len; 
			// 創建一個 4KB 大小的緩衝區，用來讀取檔案資料
			byte[] buf = new byte[4 * 1024];

			// 使用 while 迴圈讀取檔案內容直到檔案結尾 (read() 返回 -1)
			while ((len = fin.read(buf)) != -1) {
				// 將讀取的資料寫入到輸出流 (即 "dir2/coffee.jpg" 檔案)
				fout.write(buf, 0, len);
			}

			// 關閉檔案輸入流和輸出流，並刷新輸出流
			fin.close();
			fout.flush();  // 確保資料完全寫入檔案
			fout.close();  // 關閉輸出流

			System.out.println("OK"); // 複製成功訊息
		} catch (Exception e) {
			// 如果發生任何異常，顯示錯誤訊息
			System.out.println(e);
		}
	}

}
