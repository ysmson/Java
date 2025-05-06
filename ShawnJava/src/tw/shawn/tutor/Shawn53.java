package tw.shawn.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Shawn53 {

	public static void main(String[] args) {
		try {
			// 使用 InetAddress.getAllByName() 解析主機名稱，獲取對應的所有 IP 地址
			InetAddress[] ip = InetAddress.getAllByName("www.hinet.net");

			// 印出獲得的 IP 地址數量
			System.out.println(ip.length);
		} catch (UnknownHostException e) {
			// 如果解析主機名稱失敗，則捕獲 UnknownHostException 並印出錯誤訊息
			System.out.println(e);
		}
	}

}
