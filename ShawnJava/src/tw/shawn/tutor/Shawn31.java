package tw.shawn.tutor;

public class Shawn31 {

	public static void main(String[] args) {
		// 使用匿名內部類別來擴展 Shawn311 並實作 m3 方法
		Shawn311 obj1 = new Shawn311() {
			void m3() {
				System.out.println("Shawn311:m3()");
			}
		};
		obj1.m3();  // 呼叫匿名內部類別中的 m3 方法
		System.out.println("-----");
		
		// 使用已經實作的類別 Shawn312 創建物件
		Shawn311 obj2 = new Shawn312();
		obj2.m3();  // 呼叫 Shawn312 中實作的 m3 方法
	}
}

abstract class Shawn311 {
	// 抽象類別的建構子，當創建物件時會執行
	Shawn311() {
		System.out.println("Shawn311()");
	}
	
	// 普通方法
	void m1() {}
	void m2() {}
	
	// 抽象方法，必須由子類別來實作
	abstract void m3();
}

class Shawn312 extends Shawn311 {
	// 子類別的建構子，會呼叫父類別的建構子
	Shawn312() {
		System.out.println("Shawn312()");
	}
	
	// 實作抽象方法 m3
	void m3() {
		System.out.println("Shawn312:m3()");
	}
}

class Shawn313 extends Shawn311 {
	// 子類別的建構子，會呼叫父類別的建構子
	Shawn313() {
		System.out.println("Shawn313()");
	}
	
	// 實作抽象方法 m3
	void m3() {
		System.out.println("Shawn313:m3()");
	}
}
