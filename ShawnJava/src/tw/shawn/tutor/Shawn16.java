package tw.shawn.tutor;

import tw.shawn.apis.Bike;  // 引入 Bike 類別

public class Shawn16 {

    public static void main(String[] args) {
        Bike bike;  // 宣告一個 Bike 類型的變數 bike
        bike = new Bike();  // 創建 Bike 物件

        // 使用 upSpeed 方法將速度提高
        bike.upSpeed(); bike.upSpeed(); bike.upSpeed();
        bike.upSpeed(); bike.upSpeed(); bike.upSpeed();
        
        // 輸出當前速度
        System.out.println(bike.getSpeed());  // 顯示 bike 的當前速度

        // 使用 downSpeed 方法將速度降低
        bike.downSpeed(); bike.downSpeed();
        
        // 輸出當前速度
        System.out.println(bike.getSpeed());  // 顯示減速後的速度

        System.out.println("----");

        // 這行程式碼被註解掉了，假如不註解掉會引發錯誤，因為 bike.speed 是 private
        //bike.speed = 10.1;

        // 使用 getSpeed 方法再次顯示速度
        System.out.println(bike.getSpeed());  // 顯示修改後的速度
    }

}
