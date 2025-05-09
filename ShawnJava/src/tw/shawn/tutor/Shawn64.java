package tw.shawn.tutor;

public class Shawn64 {
	public static void main(String[] args) {
		System.out.println("main start");
		// 創建 Shawn641 和 Shawn642 物件
		Shawn641 obj1 = new Shawn641();
		Shawn642 obj2 = new Shawn642();
		// 啟動執行緒 obj1 和 obj2
		obj1.start();
		obj2.start();
		
		try {
			// 等待 obj1 執行緒結束
			obj1.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println("main finish");
		
	}
}
// 定義一個繼承自 Thread 的類別 Shawn641
class Shawn641 extends Thread{
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100); // 讓執行緒休眠 100 毫秒
			} catch (InterruptedException e) {
			}
		}
	}
}
// 定義一個繼承自 Thread 的類別 Shawn642
class Shawn642 extends Thread{
	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println(100+i);
			try {
				Thread.sleep(100); // 讓執行緒休眠 100 毫秒
			} catch (InterruptedException e) {
			}
		}
	}
}