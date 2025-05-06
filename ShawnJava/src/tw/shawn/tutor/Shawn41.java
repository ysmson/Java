package tw.shawn.tutor;

public class Shawn41 {

	public static void main(String[] args) {
		// 呼叫 m1 方法
		m1();
		// 輸出 "finish"
		System.out.println("finish");
	}

	// 靜態方法 m1，用來執行除法運算
	static void m1() {
		// 定義兩個整數變數 a 和 b
		int a = 10, b = 3;
		try {
			// 嘗試進行除法運算，這裡會輸出 10 / 3 的結果
			System.out.println(a / b);	
		} catch (Exception e) {
			// 如果發生例外，將會進入此區塊，並輸出 "xx"
			System.out.println("xx");
		} finally {
			// 無論是否發生例外，都會執行此區塊，並輸出 "finally"
			System.out.println("finally");
		}
		// 輸出 "end"
		System.out.println("end");
	}
}
