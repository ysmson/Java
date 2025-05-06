package tw.shawn.tutor;

import java.util.LinkedList;

/**
 * 示範 LinkedList 的基本使用方式：
 * - 新增元素
 * - 取得元素數量
 * - 顯示整個列表
 */
public class Shawn35 {

	public static void main(String[] args) {
		// 建立一個儲存字串的 LinkedList
		LinkedList<String> names = new LinkedList<String>();

		// 新增元素到 LinkedList 中（依序加入）
		names.add("Shawn");
		names.add("John");
		names.add("Mary");
		names.add("Tom");
		names.add("Jerry");
		names.add("Eric");

		// 顯示 LinkedList 中的元素數量
		System.out.println(names.size());  // 輸出：6

		// 顯示 LinkedList 中的所有元素
		System.out.println(names);  // 輸出：[Shawn, John, Mary, Tom, Jerry, Eric]
	}
}
