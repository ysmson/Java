package tw.shawn.tutor;

public class Shawn40 {
	public static void main(String[] args) {
		// 創建一個 Shawn401 物件 obj
		Shawn401 obj = new Shawn401();
		// 呼叫 m1 方法
		obj.m1();
	}
}

class Shawn401 {
	// m1 方法，會呼叫 m2 方法
	void m1() {
		System.out.println("m1");
		try {
			// 呼叫 m2 方法
			m2();
		} catch (Exception e) {
			// 如果有例外發生，這裡捕捉並處理
		}
	}

	// m2 方法，會呼叫 m3 方法並丟出例外
	void m2() throws Exception {
		System.out.println("m2");
		// 呼叫 m3 方法
		m3();
	}

	// m3 方法，會丟出一個例外
	void m3() throws Exception {
		System.out.println("m3");
		// 丟出一個新的例外
		throw new Exception();
	}
}
