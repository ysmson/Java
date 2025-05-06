package tw.shawn.tutor;  // 所屬套件

import java.util.TreeSet;

public class lottery {  // 主類別名稱為 lottery（慣例應大寫開頭，如 Lottery）

	public static void main(String[] args) {
		// 使用 TreeSet 儲存樂透號碼（自動排序且不重複）
		TreeSet<Integer> lottery = new TreeSet();
		
		// 隨機產生不重複的 6 個號碼，範圍 1~49
		while (lottery.size() < 6) {
			lottery.add((int)(Math.random() * 49 + 1));  // 產生 1~49 的整數並加入集合
		}
		
		// 輸出樂透號碼（已排序）
		System.out.println(lottery);
	}
}
