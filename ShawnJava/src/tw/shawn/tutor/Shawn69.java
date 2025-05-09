package tw.shawn.tutor;

public class Shawn69 {
	public static void main(String[] args) {
		// 創建 Store 物件
		Store store = new Store();
		// 創建 Producer 和 Consumer 物件，並傳入 Store 物件
		Producer p = new Producer(store);
		Consumer c1 = new Consumer(store);
		Consumer c2 = new Consumer(store);
		Consumer c3 = new Consumer(store);
		// 啟動 Producer 和 Consumer 執行緒
		p.start();
		c1.start();
		c2.start();
		c3.start();

	}
}
// 定義 Store 類別，用於模擬倉庫
class Store {
	private int qty; // 倉庫庫存量
	private final int max = 10; // 倉庫最大容量
	
	// 定義 add 方法，用於進貨
	void add(int add) {
		System.out.printf("進貨中...%d\n", add);
		// 當進貨後庫存量超過最大容量時，等待
		while (add + qty > max) {
			// wait....
		}
		// 更新庫存量
		qty += add;
		System.out.printf("完成進貨中...%d, 目前庫存量: %d\n", add, qty);
	}
	// 定義 buy 方法，用於買貨
	void buy(int buy) {
		System.out.printf("買貨中...%d\n", buy);
		// 當購買量大於庫存量時，等待
		while (buy > qty) {
			// wait....
		}
		// 更新庫存量
		qty -= buy;
		System.out.printf("完成買貨中...%d, 目前庫存量: %d\n", buy, qty);
	}
}

// 定義 Producer 類別，模擬生產者
class Producer extends Thread {
	private Store store;
	public Producer(Store store) {
		this.store = store;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			// 生產 5 個產品並進貨
			store.add(5);
			try {
				Thread.sleep(200); // 模擬生產時間
			} catch (InterruptedException e) {
			}
		}
	}
}
// 定義 Consumer 類別，模擬消費者
class Consumer extends Thread {
	private Store store;
	public Consumer(Store store) {
		this.store = store;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			// 隨機購買 1~5 個產品
			store.buy((int)(Math.random()*5)+1);
			try {
				Thread.sleep(300); // 模擬消費時間
			} catch (InterruptedException e) {
			}
		}
	}
}