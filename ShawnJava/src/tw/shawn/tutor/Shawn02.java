package tw.shawn.tutor;

public class Shawn02 {

	// 主程式：變數範例
	public static void main(String[] args) {
		// 宣告一個 byte 型態的變數 var1
		byte var1;

		// 將值 126 指派給 var1（byte 範圍是 -128 ~ 127）
		var1 = 126;
		System.out.println(var1);  // 輸出 126

		var1++;  // 自增，var1 = 127
		System.out.println(var1);  // 輸出 127

		var1++;  // 超出 byte 範圍，發生溢位，變為 -128
		System.out.println(var1);  // 輸出 -128

		var1++;  // var1 = -127
		System.out.println(var1);  // 輸出 -127
	}
}
