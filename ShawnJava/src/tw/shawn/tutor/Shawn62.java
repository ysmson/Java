package tw.shawn.tutor;

public class Shawn62 {
	public static void main(String[] args) {
		System.out.println("main start");
		// 創建 Shawn621 物件 obj1 和 obj2，並傳入名稱 "A" 和 "B"
		Shawn621 obj1 = new Shawn621("A");
		Shawn621 obj2 = new Shawn621("B");
		// 創建 Shawn622 物件 obj3，並傳入名稱 "C"
		Shawn622 obj3 = new Shawn622("C");
		// 創建 Thread 物件 mt1，並將 obj3 作為 Runnable 傳入
		Thread mt1 = new Thread(obj3);
		// 啟動執行緒 obj1, obj2, 和 mt1
		obj1.start();
		obj2.start();
		mt1.start();
		System.out.println("main finish");
	}
}

// 定義一個繼承自 Thread 的類別 Shawn621
class Shawn621 extends Thread {
	private String name;
	// 建構子，接收並設定執行緒的名稱
	Shawn621(String name){this.name = name;}
	// 覆寫 run 方法，定義執行緒要執行的任務
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(200); // 讓執行緒休眠 200 毫秒
			} catch (InterruptedException e) {
			}
		}
	}
	public void m1() {
		System.out.println("Shawn621:m1()");
	}
}

// 定義一個實作 Runnable 介面的類別 Shawn622
class Shawn622 implements Runnable {
	private String name;
	// 建構子，接收並設定執行緒的名稱
	Shawn622(String name){this.name = name;}
	// 實作 run 方法，定義執行緒要執行的任務
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(200); // 讓執行緒休眠 200 毫秒
			} catch (InterruptedException e) {
			}
		}
	}
	public void m1() {
		System.out.println("Shawn621:m1()");
	}
	
}