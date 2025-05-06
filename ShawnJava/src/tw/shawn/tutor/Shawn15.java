package tw.shawn.tutor;

public class Shawn15 {

    public static void main(String[] args) {
        // 宣告並初始化固定大小的二維陣列 a，大小為 3x2 (3列2行)
        int[][] a;
        a = new int[3][2];

        // 宣告並初始化不定大小的二維陣列 b，列數固定為 3，但每一列的行數不同
        int[][] b;
        b = new int[3][]; // 先宣告列數，行數為空
        b[0] = new int[2]; // 第一列有 2 個元素
        b[1] = new int[3]; // 第二列有 3 個元素
        b[2] = new int[4]; // 第三列有 4 個元素

        // 使用 for-each 迴圈輸出二維陣列 b 中的元素
        for (int[] v : b) {
            for (int vv : v) {
                // 逐個輸出每列中的每個元素
                System.out.print(vv + " ");
            }
            System.out.println();  // 換行
        }
        System.out.println("=====");

        // 顯示二維陣列 b 的地址（內存位置）
        System.out.println(b);
        
        // 顯示 b 的第一列的地址
        System.out.println(b[0]);

        // 顯示 b 的第一列的第一個元素
        System.out.println(b[0][0]);
    }
}
