package tw.shawn.tutor;

public class Shawn63 {

	public static void main(String[] args) {
		System.out.println("main start");
		// 創建 Shawn631 物件
		Shawn631 obj = new Shawn631();
		// 設定 obj 為非 daemon 執行緒 (預設即為 false)
		obj.setDaemon(false);
		// 啟動執行緒 obj
		obj.start();
		System.out.println("main finish");
	}

}
class Shawn631 extends Thread {
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