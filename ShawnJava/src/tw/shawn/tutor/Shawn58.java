package tw.shawn.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Shawn58 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.google.com");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();

			// 加上安全措施避免卡住
			conn.setConnectTimeout(5000);  // 連線最多等 5 秒
			conn.setReadTimeout(5000);     // 讀資料最多等 5 秒
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");  // 模擬瀏覽器

			BufferedReader br = new BufferedReader(
				new InputStreamReader(conn.getInputStream())
			);

			String line;
			StringBuffer mesg = new StringBuffer();
			while ((line = br.readLine()) != null) {
				mesg.append(line).append("\n");
			}

			br.close();
			conn.disconnect();

			System.out.println(mesg);
			System.out.println("Finish");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
