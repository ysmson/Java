package tw.shawn.tutor;

import tw.shawn.apis.Bike;

public class Shawn25 {
    public static void main(String[] args) {
        // 創建兩個不同的 Bike 物件
        Bike b1 = new Bike();
        Bike b2 = new Bike();
        
        // 比較 b1 和 b2 是否為相同的物件
        System.out.println(b1 == b2); // false，因為它們是不同的物件實例
        
        // 比較兩個整數是否相等
        int a = 10, b = 3;
        System.out.println(a == b); // false，因為 10 != 3
        
        // 創建兩個相同的字串字面值
        String s1 = "Shawn";
        String s2 = "Shawn";
        
        // 比較兩個字串字面值是否相等（== 比較的是參照位置）
        System.out.println(s1 == s2); // true，因為字串字面量會被 JVM 共享，指向相同的記憶體位置
        
        // 創建一個新的字串物件
        String s3 = new String("Shawn");
        
        // 比較字串字面值和新的字串物件是否相等（== 比較的是參照位置）
        System.out.println(s1 == s3); // false，因為 s3 是一個新的字串物件，它和字串字面量 s1 指向不同的記憶體位置
        
        // 創建一個新的字串物件，內容與 s3 相同
        String s4 = new String("Shawn");
        
        // 分隔線
        System.out.println("-----");
        
        // 使用 equals() 方法比較字串內容是否相等
        System.out.println(s1.equals(s3)); // true，因為 equals() 比較的是字串的內容，而不是參照位置
        System.out.println(s4.equals(s3)); // true，因為 equals() 比較的是字串的內容，它們相同
    }
}
