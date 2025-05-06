package tw.shawn.tutor;

import tw.shawn.apis.Scooter;

public class Shawn18 {
    public static void main(String[] args) {
        // 創建一個 Scooter 物件 s1
        Scooter s1 = new Scooter();
        
        // 顯示創建後的 Scooter 物件的初始速度
        System.out.println(s1.getSpeed());
        
        // 使用 upSpeed 方法三次來增加速度
        s1.upSpeed();
        s1.upSpeed();
        s1.upSpeed();
        
        // 顯示增加速度後的最終速度
        System.out.println(s1.getSpeed());
    }
}