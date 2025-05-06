package tw.shawn.tutor;

public class Shawn38 {
	public static void main(String[] args) {
		int a = 10, b = 0;
		int c;
		int[] d = {1, 2, 3, 4};
		
		try {
			// 嘗試做除法，這裡會拋出 ArithmeticException（除以 0）
			c = a / b;
			System.out.println(c);

			// 這行不會執行，因為上面那行已經發生例外
			System.out.println(d[10]); // 陣列越界
			System.out.println("OK");
			
		// 捕捉陣列索引錯誤（如果上面是陣列越界錯誤就會執行這邊）
		} catch(ArrayIndexOutOfBoundsException e2) {
			System.out.println("B");

		// 捕捉數學運算錯誤（例如除以零）
		} catch(ArithmeticException e1) {
			System.out.println("A");

		// 捕捉其他所有例外（上面沒處理到的都會來這邊）
		} catch(Exception e3) {
			System.out.println("C");
		}
		
		// 無論有沒有錯誤，這行都會執行
		System.out.println("Game Over");
	}
}
