package tw.shawn.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Shawn56 {

	public static void main(String[] args) {
		try {
		ServerSocket server = new ServerSocket(9999);
		System.out.println("Listen....");
		Socket socket = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line ; StringBuffer mesg = new StringBuffer();
		while((line = br.readLine())!=null) {
			mesg.append(line + "\n");
		}
		String urIp = socket.getInetAddress().getHostAddress();
		server.close();
		System.out.printf("%s : %s \n",urIp,mesg);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
