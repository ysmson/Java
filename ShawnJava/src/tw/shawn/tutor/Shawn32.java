package tw.shawn.tutor;

public class Shawn32 {

	public static void main(String[] args) {
		// 創建 Shawn322 類別的物件
		Shawn322 obj1 = new Shawn322();
		// 呼叫物件的 m1 方法
		obj1.m1();
		// 判斷 obj1 是否是 Shawn321 類型的實例
		System.out.println(obj1 instanceof Shawn321);
	}
}

interface Shawn321 {
	// 定義接口 Shawn321 中的方法
	void m1();
	void m2();
}

class Shawn322 extends Object implements Shawn321, Shawn323 {
	// 實作 Shawn321 接口中的 m1 和 m2 方法
	public void m1() {}
	public void m2() {}
	// 實作 Shawn323 接口中的 m3 和 m4 方法
	public void m3() {}
	public void m4() {}
}

interface Shawn323 {
	// 定義接口 Shawn323 中的方法
	void m3();
	void m4();
}

interface Shawn324 extends Shawn321, Shawn323 {
	// 擴展 Shawn321 和 Shawn323 接口，並添加新方法 m5
	void m5();
}

class Shawn325 implements Shawn324 {
	// 實作 Shawn324 中的所有方法
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
	public void m5() {}
}
