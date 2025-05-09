package tw.shawn.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Shawn66 {

	public static void main(String[] args) {
		while(true) {
			try {
				// 創建 ServerSocket 在 9999 端口監聽客戶端連線
				ServerSocket server = new ServerSocket(9999);
				System.out.println("Listen....");
				
				// 接受客戶端連線
				Socket socket = server.accept();
				// 取得客戶端 IP 位址
				String urIp = socket.getInetAddress().getHostAddress();
				// 創建 FileOutputStream 將接收到的資料寫入檔案，檔名為客戶端 IP.png
				FileOutputStream fout = new FileOutputStream("dir2/" + urIp+".png");
				// 創建 BufferedInputStream 從 socket 讀取資料
				BufferedInputStream bin = 
					new BufferedInputStream(socket.getInputStream());
				// 創建 byte 陣列作為緩衝區
				byte[] buf = new byte[4*1024*1024]; int len;
				// 迴圈讀取 socket 的資料並寫入檔案
				while ((len = bin.read(buf))!= -1) {
					fout.write(buf, 0, len);
				}
				
				// 刷新並關閉輸出串流
				fout.flush();
				fout.close();
				// 關閉輸入串流
				bin.close();
				
				// 關閉 ServerSocket
				server.close();
				// 印出客戶端 IP 位址
				System.out.printf("%s\n", urIp);
			} catch (Exception e) {
				// 捕捉並印出例外
				System.out.println(e);
			}
		}
	}

}