package tw.shawn.tutor;

public class Shawn11 {

	// 九九乘法表
	public static void main(String[] args) {
		// 第一區塊：顯示 1x1 到 3x9 的部分
		for (int j = 1; j <= 9; j++) {
			for (int i = 1; i <= 3; i++) {
				int r = i * j;  // 計算乘積
				System.out.printf("%d x %d = %d\t", i, j, r);  // 格式化輸出
			}
			System.out.println();  // 換行
		}
		System.out.println("=====");  // 分隔線

		// 第二區塊：顯示 4x1 到 6x9 的部分
		for (int j = 1; j <= 9; j++) {
			for (int i = 4; i <= 6; i++) {
				int r = i * j;
				System.out.printf("%d x %d = %d\t", i, j, r);
			}
			System.out.println();
		}
		System.out.println("=====");

		// 第三區塊：顯示 7x1 到 9x9 的部分
		for (int j = 1; j <= 9; j++) {
			for (int i = 7; i <= 9; i++) {
				int r = i * j;
				System.out.printf("%d x %d = %d\t", i, j, r);
			}
			System.out.println();
		}
	}
}
