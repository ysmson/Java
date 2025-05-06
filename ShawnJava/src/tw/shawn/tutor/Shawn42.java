package tw.shawn.tutor;

import java.io.File;

public class Shawn42 {

	public static void main(String[] args) {
		// 輸出系統的路徑分隔符（例如，Windows 上是 ';'，Linux 和 macOS 上是 ':'）
		System.out.println(File.pathSeparator);
		// 輸出系統的檔案路徑分隔符（例如，Windows 上是 '\'，Linux 和 macOS 上是 '/'）
		System.out.println(File.separator);
	}

}
