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
        // 將字串轉換為 JSONArray
        JSONArray root = new JSONArray(json);
        // 印出資料總筆數
        System.out.println("資料總筆數：" + root.length());

        // 迴圈處理每一筆資料
        for (int i = 0; i < root.length(); i++) {
            // 取得當前索引的 JSONObject
            JSONObject row = root.getJSONObject(i);

            // 安全取得欄位值，若欄位不存在則提供預設值
            String city = row.optString("County", "未知縣市");
            String name = row.optString("Name", "無名稱");
            String tel = row.optString("ContactTel", "無電話");

            // 印出格式化後的資料
            System.out.printf("%s - %s : %s\n", city, name, tel);
        }
    }
}