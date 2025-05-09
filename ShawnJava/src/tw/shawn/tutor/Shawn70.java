package tw.shawn.tutor;

public class Shawn70 {
	public static void main(String[] args) {
		// 創建 Store2 物件
		Store2 store = new Store2();
		// 創建 Producer2 和 Consumer2 物件，並傳入 Store2 物件
		Producer2 p = new Producer2(store);
		Consumer2 c1 = new Consumer2(store, "A");
		Consumer2 c2 = new Consumer2(store, "B");
		Consumer2 c3 = new Consumer2(store, "C");
		// 啟動 Producer2 和 Consumer2 執行緒
		p.start();
		c1.start();
		c2.start();
		c3.start();

	}
}
// 定義 Store2 類別，用於模擬倉庫
class Store2 {
	private int qty; // 倉庫庫存量
	private final int max = 10; // 倉庫最大容量
	
	// 定義 synchronized 的 add 方法，用於進貨
	synchronized void add(int add) throws InterruptedException {
		System.out.printf("進貨中...%d\n", add);
		// 當進貨後庫存量超過最大容量時，等待
		while (add + qty > max) {
			// wait....
			wait(); // 釋放鎖並等待其他執行緒通知
		}
		// 更新庫存量
		qty += add;
		notifyAll(); // 通知所有等待的執行緒
		System.out.printf("完成進貨中...%d, 目前庫存量: %d\n", add, qty);
	}
	// 定義 synchronized 的 buy 方法，用於買貨
	synchronized void buy(int buy,String who) throws InterruptedException {
		System.out.printf("買貨中...%d\n", buy);
		// 當購買量大於庫存量時，等待
		while (buy > qty) {
			// wait....
			wait(); // 釋放鎖並等待其他執行緒通知
		}
		// 更新庫存量
		qty -= buy;
		notifyAll(); // 通知所有等待的執行緒
		System.out.printf("<%s>完成買貨中...%d, 目前庫存量: %d\n", who, buy, qty);
	}
}

// 定義 Producer2 類別，模擬生產者
class Producer2 extends Thread {
	private Store2 store;
	public Producer2(Store2 store) {
		this.store = store;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				// 生產 5 個產品並進貨
				store.add(5);
				Thread.sleep(200); // 模擬生產時間
			} catch (InterruptedException e) {
			}
		}
	}
}
// 定義 Consumer2 類別，模擬消費者
class Consumer2 extends Thread {
	private Store2 store;
	private String name;
	
	public Consumer2(Store2 store, String name) {
		this.store = store;
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				// 隨機購買 1~5 個產品
				store.buy((int)(Math.random()*5)+1, name);
				Thread.sleep(100); // 模擬消費時間
			} catch (InterruptedException e) {
			}
		}
	}
}