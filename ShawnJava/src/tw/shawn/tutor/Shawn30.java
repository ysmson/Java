package tw.shawn.tutor;

public class Shawn30 {
	public static void main(String[] args) {
		// 創建不同類型的物件，Shawn301、Shawn302、Shawn303
		Shawn301 obj1 = new Shawn301();
		Shawn301 obj2 = new Shawn302(); // 注意：obj2 實際上是 Shawn302 類型的物件
		Shawn301 obj3 = new Shawn303(); // obj3 實際上是 Shawn303 類型的物件
		
		// 類型轉換，將 obj2 轉換為 Shawn302 類型
		Shawn302 obj4 = (Shawn302)obj2;  
		
		// 比較 obj2 和 obj4 是否是同一物件
		System.out.println(obj2 == obj4);  // 會印出 true，因為 obj2 和 obj4 指向同一個物件
		
		// 呼叫 Shawn302 類型的 m2 方法
		obj4.m2();  // 會印出 "Shawn302:m2()"
		
		// 使用 instanceof 檢查 obj2 是否為 Shawn303 類型的實例
		System.out.println(obj2 instanceof Shawn303);  // 會印出 false，因為 obj2 是 Shawn302 類型
	}
}

// Shawn301 類別
class Shawn301 {
	// 定義 m1 方法
	void m1() {
		System.out.println("Shawn301:m1()");
	}
}

// Shawn302 類別，繼承自 Shawn301，並覆寫 m1 方法，新增 m2 方法
class Shawn302 extends Shawn301 {
	// 覆寫 m1 方法
	void m1() {
		System.out.println("Shawn302:m1()");
	}
	
	// 新增 m2 方法
	void m2() {
		System.out.println("Shawn302:m2()");
	}
}

// Shawn303 類別，繼承自 Shawn301，並覆寫 m1 方法，新增 m3 方法
class Shawn303 extends Shawn301 {
	// 覆寫 m1 方法
	void m1() {
		System.out.println("Shawn303:m1()");
	}
	
	// 新增 m3 方法
	void m3() {
		System.out.println("Shawn303:m3()");
	}
}
