package tw.shawn.tutor;

public class Shawn14 {

    // 骰子
    public static void main(String[] args) {
        // 宣告一個長度為 7 的陣列 p，陣列索引 1~6 用來儲存各點數出現的次數，索引 0 用來儲存錯誤的次數
        int[] p = new int[7];

        // 進行 1000000 次擲骰子
        for (int i = 0; i < 1000000; i++) {
            // 隨機產生 1 到 6 之間的整數，模擬擲骰子的點數
            int point = (int) (Math.random() * 6 + 1);
            
            // 判斷產生的點數是否在合理範圍內，若是則對應點數的次數加 1
            if (point >= 1 && point <= 6) {
                p[point]++;
            } else {
                // 若點數不在範圍內（理論上不會發生），則增加錯誤計數
                p[0]++;
            }
        }

        // 如果沒有錯誤點數，則顯示每個點數出現的次數
        if (p[0] == 0) {
            for (int i = 1; i < p.length; i++) {
                System.out.printf("%d點出現%d次\n", i, p[i]);
            }
        } else {
            // 如果有錯誤點數，顯示錯誤資訊
            System.out.printf("ERROR: %d", p[0]);
        }
    }
}
