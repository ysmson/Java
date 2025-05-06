package tw.shawn.tutor;

public class PokerV2 {

	public static void main(String[] args) {
		// 記錄程式開始執行時間（用於計算執行效率）
		long start = System.currentTimeMillis();

		int[] poker = new int[52];   // 用來儲存撲克牌洗牌結果的陣列（52 張牌）
		boolean isRepeat;            // 判斷亂數是否重複的旗標
		int temp;                    // 暫存產生的亂數

		// 對陣列中每一張牌進行亂數產生
		for (int i = 0; i < poker.length; i++) {
			do {
				temp = (int)(Math.random() * 52);  // 產生一個 0~51 的亂數，對應一張撲克牌

				// 檢查是否與前面已存在的牌重複
				isRepeat = false;
				for (int j = 0; j < i; j++) {
					if (poker[j] == temp) {
						// 如果有重複，就設為 true，並跳出內層迴圈
						isRepeat = true;
						break;
					}
				}

			} while (isRepeat);  // 若重複，則重跑 do-while，再產生新亂數
			
			poker[i] = temp;  // 若沒重複，就將亂數存入陣列中
		}

		// 輸出程式執行耗時（毫秒）
		System.out.println("----");
		System.out.println(System.currentTimeMillis() - start);
		System.out.println("----");

		// 印出洗牌後的 52 張不重複牌號（0~51）
		for (int card : poker) {
			System.out.println(card);
		}
	}
}
