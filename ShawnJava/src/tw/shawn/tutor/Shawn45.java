package tw.shawn.tutor;

import java.io.FileOutputStream;  // <== 用於寫入檔案的類別


public class Shawn45 {
	public static void main(String[] args) {
		// 要寫入檔案的訊息
		String mesg = "Hello Shawn";
		
		try {
			// 創建 FileOutputStream 物件，並指定目標檔案
			FileOutputStream fout = new FileOutputStream("./dir1/file1.txt");
			
			// 將字串轉換為位元組並寫入檔案
			fout.write(mesg.getBytes());
			
			// 關閉 FileOutputStream
			fout.close();
			
			// 輸出成功訊息
			System.out.println("OK");
		}catch (Exception e1) {
			// 捕捉並輸出異常
			System.out.println(e1);
		}
	}
}
