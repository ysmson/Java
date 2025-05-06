package tw.shawn.tutor;

public class Shawn99 {

    // 99乘法表的程式
    public static void main(String[] args) {
        // 定義顯示乘法表的行數和列數
        final int ROWS = 3;  // 行數設定為3
        final int COLS = 3;  // 列數設定為3
        final int START = 1; // 乘法表的起始數字設定為1（這裡的數字是1~9）
        
        // ------------------------------ 開始循環生成99乘法表
        for (int k = 0; k < ROWS; k++) {  // 外層循環，用來控制顯示的行數
            for (int j = 1; j <= 9; j++) {  // 第二層循環，對每一個數字從1到9進行乘法運算
                for (int i = START; i < START + COLS; i++) {  // 第三層循環，對應列數的變動，顯示每一行的數字
                    int newi = i + k * COLS;  // 計算當前數字，會依據行數變動
                    int r = newi * j;  // 計算乘法結果
                    System.out.printf("%d x %d = %d\t", newi, j, r);  // 輸出格式化結果
                }
                System.out.println();  // 換行，顯示下一個乘法表結果
            }
            System.out.println("===");  // 每行後面加上"==="，便於區分每一部分
        }
    }

}
