package tw.shawn.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Shawn55 {

    public static void main(String[] args) {
        byte[] buf = new byte[1024];  // 用來接收資料的緩衝區

        try {
            // 創建一個 DatagramSocket 並綁定到本地的 8888 端口
            DatagramSocket socket = new DatagramSocket(8888); // 開啟 port 8888
            System.out.println("UDP Server 已啟動，正在等待封包...");

            // 持續接收資料包
            while (true) {
                // 用來接收資料的資料包
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                
                // 等待並接收來自客戶端的資料包
                socket.receive(packet);

                // 取得來自客戶端的 IP 地址和端口號
                String urIp = packet.getAddress().getHostAddress();
                int urPort = packet.getPort();
                
                // 將接收到的資料轉換成字串
                String mesg = new String(packet.getData(), 0, packet.getLength());

                // 輸出來自客戶端的資料
                System.out.printf("來自 %s:%d 的訊息：%s\n", urIp, urPort, mesg);
            }
        } catch (Exception e) {
            // 若發生錯誤，顯示錯誤訊息
            System.out.println("錯誤：" + e);
        }
    }
}
