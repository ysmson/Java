package tw.shawn.tutor;

public class PokerV1 {

	public static void main(String[] args) {
		// 記錄程式開始時間（用來計算耗時）
		long start = System.currentTimeMillis();

		int[] poker = new int[52];  // 建立一個長度為 52 的整數陣列，用來儲存洗牌結果

		// 開始填入不重複的亂數到陣列中
		for (int i = 0; i < poker.length; i++) {
			int temp = (int)(Math.random() * 52);  // 產生 0~51 的亂數（對應 52 張牌）

			// 檢查 temp 是否已經出現過
			boolean isRepeat = false;
			for (int j = 0; j < i; j++) {
				if (poker[j] == temp) {
					// 發現重複
					isRepeat = true;
					break;
				}
			}

			if (!isRepeat) {
				poker[i] = temp;  // 沒有重複才放進陣列
			} else {
				i--;  // 若重複，i 不加一，重試當前位置
			}
		}

		// 印出耗時
		System.out.println("----");
		System.out.println(System.currentTimeMillis() - start);  // 計算與列出運算時間（毫秒）
		System.out.println("----");

		// 將結果依序輸出（0~51 的隨機不重複數字）
		for (int card : poker) {
			System.out.println(card);
		}
	}
}
