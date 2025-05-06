package tw.shawn.tutor;

import java.util.HashSet;
import java.util.Iterator;

import tw.shawn.apis.Bike;

/**
 * 示範 Java 的 HashSet 使用方式
 * HashSet 是一種不重複的集合（元素不重複、無順序）
 */
public class Shawn34 {

	public static void main(String[] args) {
		// 建立一個 HashSet（沒有指定泛型，因此可以放任何型別的物件）
		HashSet set = new HashSet();

		// 加入字串 "Shawn"
		set.add("Shawn");

		// 加入自定義物件 Bike（假設 Bike 有正確的 toString() 方法）
		set.add(new Bike());

		System.out.println(set.size()); // 顯示目前集合中元素個數：應為 2

		// 嘗試加入相同的字串 "Shawn"（因為字串是 immutable 且有覆寫 hashCode/equals，所以不會重複）
		set.add("Shawn");
		System.out.println(set.size()); // 長度仍為 2

		// 加入整數（自動裝箱為 Integer 物件）
		set.add(123);
		System.out.println(set.size()); // 長度為 3

		// 加入浮點數（自動裝箱為 Double 物件）
		set.add(12.3);
		System.out.println(set.size()); // 長度為 4

		// 再次加入相同整數 123（因為 Integer 已有覆寫 equals/hashCode，不會重複）
		set.add(123);
		System.out.println(set.size()); // 長度仍為 4（沒變）

		System.out.println("----");

		// 輸出整個集合（順序不一定）
		System.out.println(set);

		System.out.println("---- 使用 Iterator 迭代 ----");
		// 使用 Iterator 迭代集合
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}

		System.out.println("---- 使用 for-each 迴圈 ----");
		// 使用 for-each 迴圈也可以遍歷集合
		for (Object obj : set) {
			System.out.println(obj);
		}
	}
}
