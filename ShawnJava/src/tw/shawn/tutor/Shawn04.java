package tw.shawn.tutor;

import java.util.Scanner;

// 運算子範例：加、減、乘、除、取餘數
public class Shawn04 {

	public static void main(String[] args) {
		// 使用 Scanner 來接收使用者輸入
		Scanner scanner = new Scanner(System.in);
		
		// 提示使用者輸入 X 和 Y 的數值
		System.out.print("X="); 
		int x = scanner.nextInt();  // 讀取 X 的值
		
		System.out.print("Y=");
		int y = scanner.nextInt();  // 讀取 Y 的值
		
		// 進行加法、減法、乘法、除法和取餘數運算
		int var1 = x + y;  // 加法
		int var2 = x - y;  // 減法
		int var3 = x * y;  // 乘法
		int var4 = x / y;  // 除法
		int var5 = x % y;  // 取餘數
		
		// 輸出運算結果，格式化顯示
		System.out.printf("%d+%d=%d\n", x, y, var1);  // 顯示加法結果
		System.out.printf("%d-%d=%d\n", x, y, var2);  // 顯示減法結果
		System.out.printf("%d*%d=%d\n", x, y, var3);  // 顯示乘法結果
		System.out.printf("%d/%d=%d...%d\n", x, y, var4, var5);  // 顯示除法及餘數結果
	}
}
