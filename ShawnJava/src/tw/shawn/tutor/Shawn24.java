package tw.shawn.tutor;

import tw.shawn.apis.Bike;
import tw.shawn.apis.Scooter;

public class Shawn24 {

    public static void main(String[] args) {
        // 字串字面值 "Shawn"
        String s1 = "Shawn";
        
        // 創建空的字串
        String s2 = new String();
        
        // 使用字節數組創建字串，字節數組包含 ASCII 值
        byte[] bs = { 97, 98, 99, 100 }; // 對應的字符是 'a', 'b', 'c', 'd'
        String s3 = new String(bs); // 字節數組轉換為字串 "abcd"
        
        // 使用字節數組的特定範圍來創建字串
        String s4 = new String(bs, 1, 2); // 取字節數組中的第 1 和第 2 位 ('b' 和 'c')
        
        // 使用字符串常量創建字串
        String s5 = new String("Shawn");
        
        // 打印字串 s1
        System.out.println(s1);
        
        // 分隔線
        System.out.println("-----");
        
        // 創建 Bike 物件
        Bike b1 = new Bike();
        // 打印 Bike 物件的字符串表示
        System.out.println(b1);
        
        // 調用 upSpeed 方法來增加速度
        b1.upSpeed(); b1.upSpeed(); b1.upSpeed(); b1.upSpeed();
        
        // 再次打印 Bike 物件，這時它的速度已經增加
        System.out.println(b1);
        
        // 分隔線
        System.out.println("---");
        
        // 創建 Scooter 物件
        Scooter s6 = new Scooter();
        // 打印 Scooter 物件的字符串表示
        System.out.println(s6);
    }

}
