package tw.shawn.tutor;

public class Shawn08 {
	
	// if-else 條件運算範例
	public static void main(String[] args) {
		// 產生一個隨機的分數，範圍從 0 到 99
		int score = (int)(Math.random() * 100);  // 產生 0 ~ 99 之間的隨機整數
		System.out.println("Score: " + score);  // 輸出隨機生成的分數

		// 判斷等級
		if(score >= 90) {  // 如果分數大於等於 90，則為等級A
			System.out.println("等級A");
		} else if(score >= 80) {  // 如果分數大於等於 80 且小於 90，則為等級B
			System.out.println("等級B");
		} else if(score >= 70) {  // 如果分數大於等於 70 且小於 80，則為等級C
			System.out.println("等級C");
		} else if(score >= 60) {  // 如果分數大於等於 60 且小於 70，則為等級D
			System.out.println("等級D");
		} else {  // 如果分數小於 60，則為等級E
			System.out.println("等級E");
		}

		// 通過與否
		if(score >= 60) {  // 如果分數大於等於 60，則通過
			System.out.println("及格");
		} else {  // 如果分數小於 60，則不及格
			System.out.println("不及格");
		}
	}
}
