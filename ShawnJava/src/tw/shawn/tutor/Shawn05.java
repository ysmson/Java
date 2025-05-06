package tw.shawn.tutor;

public class Shawn05 {

	// 浮點數範例
	public static void main(String[] args) {
		// 宣告 float 和 double 類型的變數
		float var1 = 12.0f;  // float 型態，需加上 f
		double var2 = 12.0;   // double 型態，預設為 double
		
		// 宣告整數變數 a 和 b
		int a = 10, b = 3;
		
		// 將 a 和 b 的除法結果儲存到 double 變數 var3
		double var3 = a * 1.0 / b;  // 強制轉換為浮點數進行運算
		System.out.println(var1);    // 輸出 float 變數 var1 的值
		System.out.println(var2);    // 輸出 double 變數 var2 的值
		System.out.println(var3);    // 輸出 double 變數 var3 的值
		System.out.println("---");
		
		// 使用浮點數進行加法運算
		float x = 0.1f;  // float 類型的數值 0.1
		float y = 0.2f;  // float 類型的數值 0.2
		float r1 = x + y;  // 計算 r1 = 0.1 + 0.2
		System.out.println(r1);  // 輸出結果 0.300000012

	}

}
