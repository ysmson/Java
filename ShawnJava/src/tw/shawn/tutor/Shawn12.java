package tw.shawn.tutor;

public class Shawn12 {

    // 質數
    public static void main(String[] args) {
        // 遍歷 1 到 100 之間的所有數字
        for (int i = 1; i <= 100; i++) {
            // 判斷是否為質數
            if (isPrime(i)) {
                // 若是質數，用 () 圈起來，寬度固定對齊
                System.out.printf("(%2d) ", i);
            } else {
                // 不是質數就正常印出
                System.out.printf(" %3d ", i);
            }

            // 每列印 10 個數字就換行
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    // 判斷是否為質數的方法
    public static boolean isPrime(int n) {
        // 如果 n 小於等於 1，就不是質數
        if (n <= 1) return false;

        // 從 2 開始，一直到 n 的平方根進行檢查
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 如果 n 能被 i 整除，則 n 不是質數
            if (n % i == 0) return false;
        }

        // 若以上條件都不成立，則 n 是質數
        return true;
    }
}
