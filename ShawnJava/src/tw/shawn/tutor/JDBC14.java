package tw.shawn.tutor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC14 {
    private static final String URL = "jdbc:mysql://localhost/shawn";
    private static final String USER = "root";

    private static Connection conn;
    private static final String QUERY = "SELECT * FROM member WHERE id = ?";

    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put("user", USER);

        try {
            conn = DriverManager.getConnection(URL, prop);
            PreparedStatement pstmt = conn.prepareStatement(QUERY);
            pstmt.setInt(1, 3); // 可以依需求改成從 Scanner 取得使用者輸入
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String account = rs.getString("account");
                InputStream in = rs.getBinaryStream("icon");

                if (in == null) {
                    System.out.println("使用者尚未上傳圖片。");
                    return;
                }

                // 確保輸出資料夾存在
                File dir = new File("dir2");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // 讓 InputStream 成為 final，才能安全傳入 Thread
                final InputStream finalIn = in;
                final String filename = String.format("dir2/%s.png", account);

                new Thread(() -> {
                    try (InputStream threadIn = finalIn;
                         FileOutputStream fout = new FileOutputStream(filename)) {

                        byte[] buf = new byte[128 * 1024];
                        int len;
                        while ((len = threadIn.read(buf)) != -1) {
                            fout.write(buf, 0, len);
                        }

                        fout.flush();
                        System.out.println("圖片寫入完成！");
                    } catch (Exception e) {
                        System.out.println("執行緒錯誤：" + e.getMessage());
                        e.printStackTrace();
                    }
                }).start();

                System.out.println("Writing...");
            } else {
                System.out.println("查無此會員。");
            }

        } catch (Exception e) {
            System.out.println("資料庫錯誤：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
