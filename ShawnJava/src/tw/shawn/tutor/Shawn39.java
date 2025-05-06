package tw.shawn.tutor;

public class Shawn39 {
	public static void main(String[] args) {
		// 創建一個 Bird 物件 b1
		Bird b1 = new Bird();
		try {
			// 嘗試設定鳥的腿數量為 -2
			b1.setLeg(-2); // 這會觸發例外，因為腿數應該是正數，並且最多為 2
			System.out.println("OK"); // 這行不會執行
		} catch (Exception e) {
			// 捕捉到例外後印出錯誤訊息
			System.out.println("Oop!"); // 這行會被執行
		}
	}
}

class Bird {
	int leg; // 鳥的腿數量

	// 設定鳥的腿數量的方法，會丟出例外
	void setLeg(int n) throws Exception {
		// 如果腿數在合法範圍內（1 到 2），則設定 leg
		if (n > 0 && n <= 2) {
			leg = n;
		} else {
			// 如果不在範圍內，丟出例外
			throw new Exception(); // 類型是通用的 Exception
		}
	}
}
