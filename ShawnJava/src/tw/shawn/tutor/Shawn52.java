package tw.shawn.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import tw.shawn.apis.Student;

public class Shawn52 {

	public static void main(String[] args) {
		// 使用 try-with-resources 自動關閉資源
		try (FileInputStream fin = new FileInputStream("dir1/brad.score"); // 開啟從檔案 "dir1/brad.score" 讀取的 FileInputStream
				ObjectInputStream oin = new ObjectInputStream(fin)) { // 使用 ObjectInputStream 來反序列化物件
			
			// 讀取反序列化的物件
			Object obj = oin.readObject();
			
			// 將物件轉型為 Student 類別
			Student s1 = (Student) obj;
			
			// 印出學生的姓名、總分和平均分
			System.out.printf("%s: %d : %f\n", s1.getName(), s1.score(), s1.avg());
			
			// 印出學生的自行車狀況
			System.out.println(s1.getBike());
		} catch (Exception e) { // 捕獲並處理可能的異常
			System.out.println(e); // 印出異常訊息
		}
	}
}
