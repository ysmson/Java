package tw.shawn.tutor;

import java.util.HashMap;
import java.util.Set;

/**
 * 使用 HashMap 儲存一個人的資料（如姓名、性別、年齡、體重）
 * - 示範 put 資料、覆蓋資料、keySet 取出所有 key
 */
public class Shawn36 {

	public static void main(String[] args) {
		// 建立一個 HashMap 來存放資料，key 為字串，value 為 Object（可放任意型別）
		HashMap<String, Object> person = new HashMap<String, Object>();

		// 新增資料
		person.put("name", "Shawn");   // 字串
		person.put("gender", true);    // 布林值
		person.put("age", 18);         // 整數，自動 boxing 為 Integer
		person.put("w", 79.7);         // 浮點數，自動 boxing 為 Double

		System.out.println(person.size());  // 輸出 4，因為有四個不同 key

		// 更新 age 的值為 28（重複 key 會覆蓋舊值）
		person.put("age", 28);
		System.out.println(person.size());  // 還是 4，因為是更新而非新增

		// 新增一個別名 alias，也是字串
		person.put("alias", "Shawn");
		System.out.println(person.size());  // 現在變成 5 筆資料

		System.out.println("---");

		// 取得所有 key 並列印對應的 value
		Set<String> keys = person.keySet();
		for (String key : keys) {
			System.out.println(key + ":" + person.get(key));
		}
	}
}
