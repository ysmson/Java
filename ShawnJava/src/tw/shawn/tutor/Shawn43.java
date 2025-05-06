package tw.shawn.tutor;

import java.io.File;

public class Shawn43 {

	public static void main(String[] args) {
		// 創建一個指向 d:/Shawn/dir1 路徑的 File 物件
		File f1 = new File("d:/Shawn/dir1");

		// 檢查該路徑是否已經存在
		if (f1.exists()) {
			// 如果目錄存在，輸出 "OK"
			System.out.println("OK");
		} else {
			// 如果目錄不存在，輸出 "xx" 並創建該目錄
			System.out.println("xx");
			// 使用 mkdirs() 方法創建目錄（包括所有必要的父目錄）
			f1.mkdirs();
		}
	}
}
