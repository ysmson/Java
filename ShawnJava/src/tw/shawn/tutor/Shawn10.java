package tw.shawn.tutor;

public class Shawn10 {

	// for迴圈範例
	public static void main(String[] args) {
		int i = 0;
		// 使用for迴圈，並且在每次執行前後執行其他方法
		for(printShawn(); i < 10; printLine()) {
			System.out.println(i++);  // 輸出 i 並且遞增 i
		}
		System.out.println("=====");  // 迴圈結束後印出分隔線
		System.out.println(i);  // 輸出最終的 i 值
	}
	
	// 定義方法 printShawn，印出 "Shawn"
	static void printShawn() {
		System.out.println("Shawn");
	}
	
	// 定義方法 printLine，印出 "-----"
	static void printLine() {
		System.out.println("-----");
	}
}
