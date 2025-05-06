package tw.shawn.tutor;

public class Shawn29 {
	public static void main(String[] args) {
		// 靜態方法 m2 直接通過類別名稱呼叫
		Shawn291.m2();
		Shawn291.m2();
		Shawn291.m2();
	}
}

class Shawn291 {
	// 實例區塊：每次創建物件時都會執行
	{
		System.out.println("{}");
	}
	
	// 靜態區塊：類別被載入時只執行一次
	static {
		System.out.println("static:{}");
	}

	// 建構子：每次創建物件時會執行
	Shawn291(){
		System.out.println("Brad271()");
	}

	// 實例方法：可以通過物件來呼叫
	void m1() {
		System.out.println("Brad271:m1()");
	}
	
	// 靜態方法：可以直接通過類別來呼叫
	static void m2() {
		System.out.println("static:m2()");
	}
}
