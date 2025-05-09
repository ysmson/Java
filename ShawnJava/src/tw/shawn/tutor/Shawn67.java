package tw.shawn.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Shawn67 {

	public static void main(String[] args) {
		// 創建 File 物件，指定要傳送的檔案
		File source = new File("dir1/ball.png");
		// 創建 byte 陣列，大小為檔案長度
		byte[] buf = new byte[(int)source.length()];
		try {
			// 創建 BufferedInputStream 讀取檔案內容
			BufferedInputStream bin = 
				new BufferedInputStream(new FileInputStream(source));
			// 將檔案內容讀取到 byte 陣列
			bin.read(buf);
			// 關閉輸入串流
			bin.close();
			
			
			// 創建 Socket 連接到指定 IP 和端口
			Socket socket = new Socket(InetAddress.getByName("10.0.104.177"),9999);
			// 創建 BufferedOutputStream 寫入 socket
			BufferedOutputStream bout = 
				new BufferedOutputStream(socket.getOutputStream());
			// 將 byte 陣列寫入 socket
			bout.write(buf);
			// 刷新並關閉輸出串流
			bout.flush();
			bout.close();
			// 印出 "OK" 表示傳送成功
			System.out.println("OK");
			
		} catch (Exception e) {
			// 捕捉並印出例外
			System.out.println(e);
		}
	}

}