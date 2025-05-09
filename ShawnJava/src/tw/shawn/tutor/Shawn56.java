package tw.shawn.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Shawn56 {

	public static void main(String[] args) {
		try {
			// 創建一個 ServerSocket 物件，監聽指定的 9999 端口
			ServerSocket server = new ServerSocket(9999);
			// 印出 "Listen...."，表示伺服器已啟動並開始監聽連線
			System.out.println("Listen....");
			// 接受來自客戶端的連線請求，並創建一個 Socket 物件來表示這個連線
			Socket socket = server.accept();
			// 創建 BufferedReader 物件，用於從客戶端傳來的輸入流中讀取文字資料
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 宣告一個字串變數 line 和一個 StringBuffer 物件 mesg，用於儲存接收到的訊息
			String line ; StringBuffer mesg = new StringBuffer();
			// 迴圈讀取來自客戶端的每一行資料，直到讀取到 null (表示連線中斷或結束)
			while((line = br.readLine())!=null) {
				// 將讀取到的每一行資料附加到 StringBuffer 中，並加上換行符號
				mesg.append(line + "\n");
			}
			// 取得客戶端的 IP 位址
			String urIp = socket.getInetAddress().getHostAddress();
			// 關閉 ServerSocket，停止監聽新的連線
			server.close();
			// 使用格式化輸出印出客戶端的 IP 位址和接收到的完整訊息
			System.out.printf("%s : %s \n",urIp,mesg);
		}catch(Exception e) {
			// 如果在伺服器運作過程中發生任何異常，則印出異常訊息
			System.out.println(e);
		}
	}

}