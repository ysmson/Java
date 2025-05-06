package tw.shawn.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Shawn54 {

	public static void main(String[] args) {
		// 要發送的訊息
		String mesg = "嗨你好";
		
		// 將訊息轉換成位元組陣列
		byte[] data = mesg.getBytes();

		try {
			// 創建一個 DatagramSocket（無需指定端口號，系統會自動分配）
			DatagramSocket socket = new DatagramSocket();
			
			// 創建一個 DatagramPacket，這是要發送的數據包
			// 參數：
			// - data：要發送的資料（字節陣列）
			// - data.length：資料的長度
			// - InetAddress.getByName("10.0.104.255")：目標 IP 地址
			// - 2514：目標端口號
			DatagramPacket packet = new DatagramPacket(
					data, data.length, 
					InetAddress.getByName("10.0.104.255"), 2514);
			
			// 發送資料包
			socket.send(packet);
			
			// 關閉 socket 連接
			socket.close();
			
			// 印出成功訊息
			System.out.println("Send OK");
		} catch (Exception e) {
			// 若出現異常，印出錯誤訊息
			System.out.println(e);
		}
	}

}
