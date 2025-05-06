package tw.shawn.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import tw.shawn.apis.Student;

public class Shawn51 {
	public static void main(String[] args) {
		// 建立一個 Student 物件 s1
		Student s1 = new Student("Brad", 76, 45, 32);
		
		// 印出學生的姓名、總分和平均分
		System.out.printf("%s: %d : %f\n", s1.getName(), s1.score(), s1.avg());
		
		// 讓學生的自行車加速 4 次
		s1.getBike().upSpeed().upSpeed().upSpeed().upSpeed();
		
		// 印出學生的自行車狀況
		System.out.println(s1.getBike());
		
		// 使用 try-with-resources 自動關閉資源，開啟文件輸出流並準備寫入序列化物件
		try (FileOutputStream fout = new FileOutputStream("dir1/brad.score"); // 創建文件輸出流，指定檔案路徑
				ObjectOutputStream oout = new ObjectOutputStream(fout)) { // 創建 ObjectOutputStream 實例來寫入物件
			
			// 將 s1 物件寫入文件
			oout.writeObject(s1);
			// 強制將資料寫入檔案
			oout.flush();
			// 顯示操作成功訊息
			System.out.println("OK");
			
		} catch (Exception e) { // 捕獲並處理任何異常
			System.out.println(e); // 印出異常訊息
		}
	}
}
