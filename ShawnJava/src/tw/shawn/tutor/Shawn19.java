package tw.shawn.tutor;

import tw.shawn.apis.Bike;

public class Shawn19 {

    public static void main(String[] args) {
        // 創建一個 Bike 物件 bike
        Bike bike;
        bike = new Bike();

        // 增加速度 6 次
        bike.upSpeed(); // 增加一次
        bike.upSpeed(); // 增加一次
        bike.upSpeed(); // 增加一次
        bike.upSpeed(); // 增加一次
        bike.upSpeed(); // 增加一次
        bike.upSpeed(); // 增加一次

        // 顯示速度
        System.out.println(bike.getSpeed());

        // 減少速度 2 次
        bike.downSpeed(); // 減少一次
        bike.downSpeed(); // 減少一次

        // 顯示減速後的速度
        System.out.println(bike.getSpeed());

        System.out.println("----");

        // 再次顯示速度
        System.out.println(bike.getSpeed());
    }
}
