package tw.shawn.tutor;

public class Shawn17 {

    public static void main(String[] args) {
        int a = 44, b = -7;

        // 使用位運算進行交換
        a = a ^ b;  // a 現在是 a 和 b 的異或結果
        b = a ^ b;  // b = (a ^ b) ^ b => 這時 b 恢復為原來的 a
        a = a ^ b;  // a = (a ^ b) ^ a => 這時 a 恢復為原來的 b

        System.out.printf("a=%d,b=%d\n", a, b);  // 輸出交換後的 a 和 b
        System.out.println(3 & 2);  // 輸出 3 和 2 的位與運算結果
        System.out.println(3 | 2);  // 輸出 3 和 2 的位或運算結果

        //test
        //TEST3
    }
}
