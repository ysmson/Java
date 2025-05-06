package tw.shawn.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Shawn61 {

    public static void main(String[] args) {
        try {
            // 取得農委會資料的連結
            URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            // 讀取資料
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            StringBuilder mesg = new StringBuilder();
            while ((line = br.readLine()) != null) {
                mesg.append(line);
            }

            br.close();
            conn.disconnect(); // 關閉連線

            // 解析並輸出 JSON 資料
            parseJSON(mesg.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void parseJSON(String json) {
        JSONArray root = new JSONArray(json);
        System.out.println("資料總筆數：" + root.length());

        for (int i = 0; i < root.length(); i++) {
            JSONObject row = root.getJSONObject(i);

            // 安全取得欄位值
            String city = row.optString("County", "未知縣市");
            String name = row.optString("Name", "無名稱");
            String tel = row.optString("ContactTel", "無電話");

            System.out.printf("%s - %s : %s\n", city, name, tel);
        }
    }
}
