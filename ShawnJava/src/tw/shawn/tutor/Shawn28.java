package tw.shawn.tutor;

public class Shawn28 {
	public static void main(String[] args) {
		// 打印靜態變數 j 的值，這裡靜態變數是類別共享的
		System.out.println(Shawn281.j);

		// 創建三個 Shawn281 類型的物件
		Shawn281 obj1 = new Shawn281();
		Shawn281 obj2 = new Shawn281();
		Shawn281 obj3 = new Shawn281();

		// 打印每個物件的實例變數 i，這些變數是每個物件所擁有的
		System.out.println(obj1.i);
		System.out.println(obj2.i);
		System.out.println(obj3.i);

		System.out.println("----");

		// 打印每個物件的靜態變數 j（靜態變數是共享的）
		System.out.println(obj1.j);  // 由於 j 是靜態變數，所以 obj1、obj2、obj3 都共享同一個 j
		System.out.println(Shawn281.j);  // 也可以使用類別名來訪問靜態變數
	}
}

class Shawn281 {
	int i;  // 實例變數，每創建一個物件，它會有一個獨立的 i
	static int j;  // 靜態變數，所有的物件共享同一個 j

	// 建構子，每次創建一個物件時，會使 i 和 j 都自增 1
	Shawn281(){
		i++;  // 每個物件的 i 都會自增
		j++;  // 所有物件共享同一個 j，會自增
	}
}
