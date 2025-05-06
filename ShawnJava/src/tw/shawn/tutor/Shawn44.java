package tw.shawn.tutor;

import java.io.File;

public class Shawn44 {

	public static void main(String[] args) {
		// 創建一個指向目前目錄的 File 物件 (即 "." 代表當前目錄)
		File f1 = new File(".");
		
		// 輸出當前目錄的絕對路徑
		System.out.println(f1.getAbsolutePath());
		
		// 創建一個指向相對路徑 ./dir2 的 File 物件
		File dir1 = new File("./dir2");
		
		// 檢查 ./dir2 目錄是否存在，並輸出結果
		System.out.println(dir1.exists());
	}
}
