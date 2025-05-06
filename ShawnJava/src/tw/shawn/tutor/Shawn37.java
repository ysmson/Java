package tw.shawn.tutor;

public class Shawn37 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		int c;

		// 嘗試做除法（無例外的情況）
		c = a / b;  // 結果為 3，因為是整數除法（10 / 3 = 3.333... -> 3）

		// 使用 try-catch 處理例外（但這裡其實沒發生錯誤）
		try {
			c = a / b;
		} catch (ArithmeticException e) {
			// 如果除以 0，會拋出 ArithmeticException
			c = 0;
		}
		System.out.println(c); // 印出 3

		// 宣告一個陣列 d，內容為 {1, 2, 3, 4}
		int[] d = { 1, 2, 3, 4 };

		// 嘗試取出陣列中第 21 個元素（索引從 0 開始），會產生例外
		try {
			System.out.println(d[20]);  // 超出陣列範圍，會拋出 ArrayIndexOutOfBoundsException
		} catch (ArrayIndexOutOfBoundsException e) {
			// 捕捉陣列索引錯誤的例外
			System.out.println("Ooop!");  // 印出錯誤訊息
		}
	}
}
