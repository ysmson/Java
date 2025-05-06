package tw.shawn.tutor;

import tw.shawn.apis.Bike;      // 引入 Bike 類
import tw.shawn.apis.Scooter;  // 引入 Scooter 類

public class Shawn21 {

    public static void main(String[] args) {
        
        // 創建一個 Bike 類的實例 b1，並傳遞參數 1 來初始化
        Bike b1 = new Bike(1);
        System.out.println("-----");
        
        // 創建一個 Scooter 類的實例 s1，使用無參數構造方法
        Scooter s1 = new Scooter();
    }
}
