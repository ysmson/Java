package tw.shawn.tutor;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Shawn57 {

	public static void main(String[] args) {
		// 定義要傳送的訊息
		String mesg = "Hello, Brad";
		try {
			// 創建一個 Socket 物件，指定要連接的伺服器的 IP 位址 (localhost 或 127.0.0.1) 和端口號 (9999)
			Socket client = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
			// 創建 BufferedWriter 物件，用於將文字資料寫入到伺服器的輸出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			// 將定義的訊息寫入到 BufferedWriter 的緩衝區
			bw.write(mesg);
			// 強制將緩衝區中的資料寫入到輸出流，確保訊息立即發送
			bw.flush();
			// 關閉 BufferedWriter，釋放相關資源
			bw.close();
			// 關閉 Socket 連線
			client.close();
			// 印出 "Send,OK"，表示訊息已成功發送
			System.out.println("Send,OK");
		} catch (Exception e) {
			// 如果在客戶端連線或傳送訊息的過程中發生任何異常，則印出異常訊息
			System.out.println(e);
		}

	}

}