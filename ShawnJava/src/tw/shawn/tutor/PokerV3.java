package tw.shawn.tutor;

public class PokerV3 {

	public static void main(String[] args) {
		// 1. 文具行買回來（初始化撲克牌陣列 0~51）
		int nums = 52;
		int[] poker = new int[nums];
		for (int i = 0; i < poker.length; i++) {
			poker[i] = i;  // 將 0~51 存入陣列中
		}

		// 2. 洗牌（Fisher–Yates 洗牌演算法）
		for (int i = nums - 1; i > 0; i--) {
			int rindex = (int) (Math.random() * (i + 1));  // 產生 0~i 的亂數
			// 交換位置：poker[i] <-> poker[rindex]
			int temp = poker[rindex];
			poker[rindex] = poker[i];
			poker[i] = temp;
		}

		// 印出洗好順序的 52 張牌（編號）
		for (int card : poker) {
			System.out.println(card);
		}

		System.out.println("-----");

		// 建立玩家陣列（4 位玩家，每人 13 張牌）
		int[][] players = new int[4][13];

		// 發牌：依序發給 4 位玩家，每人 13 張
		for (int i = 0; i < poker.length; i++) {
			players[i % 4][i / 4] = poker[i];  // i % 4：決定玩家編號，i / 4：決定張數位置
		}

		// 印出第 2 位玩家（players[1]）的 13 張牌（編號）
		for (int card : players[1]) {
			System.out.println(card);
		}

		System.out.println("-----");

		// 撲克牌花色與點數對應表
		String[] suits = { "♠", "♥", "♦", "♣" };   // 黑桃、紅心、方塊、梅花
		String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		// 依序輸出每位玩家的 13 張牌（花色＋點數）
		for (int[] player : players) {
			for (int card : player) {
				System.out.print(suits[card / 13] + values[card % 13] + " ");  // 轉換成撲克牌格式
			}
			System.out.println();  // 換行，換下一位玩家
			// 測試 Git commit
		}
	}
}
