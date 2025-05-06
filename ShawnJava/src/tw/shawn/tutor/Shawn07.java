package tw.shawn.tutor;

public class Shawn07 {

	// 邏輯運算子
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;

		// AND 運算子
		System.out.println(b1 && b2);  // false，因為 b2 是 false

		// OR 運算子
		System.out.println(b1 || b2);  // true，因為 b1 是 true

		// NOT 運算子
		System.out.println(!b1);  // false，因為 b1 是 true，NOT 會反轉它
	}
}
