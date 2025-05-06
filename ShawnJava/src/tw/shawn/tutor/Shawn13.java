package tw.shawn.tutor;

public class Shawn13 {

    // 陣列
    public static void main(String[] args) {
        // 宣告一個整數型陣列變數 a
        int[] a;
        
        // 為陣列分配大小為 3 的記憶體
        a = new int[3];
        
        // 輸出陣列的長度
        System.out.println(a.length);  // 輸出 3
        
        // 用 for 迴圈遍歷陣列並顯示其初始值（預設為 0）
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);  // 輸出 0, 0, 0
        }

        System.out.println("---");
        
        // 對陣列中的元素賦值
        a[1] = 123;
        a[0] = 12;
        
        // 用 for 迴圈遍歷並顯示賦值後的結果
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);  // 輸出 12, 123, 0
        }
        
        System.out.println("---");
        
        // 使用 for-each 迴圈遍歷陣列並顯示每個元素
        for (int v : a) {
            System.out.println(v);  // 輸出 12, 123, 0
        }
        
        System.out.println("-----");
        
        // 輸出陣列的地址或記憶體位置
        System.out.println(a);  // 輸出陣列的記憶體位址（不會顯示陣列的內容）
        
        System.out.println("-----");
        
        // 宣告一個變數 b 並賦值 3
        int b = 3;
        
        // 輸出變數 b 的值
        System.out.println(b);  // 輸出 3
    }
}
