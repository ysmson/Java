package tw.shawn.apis;

import java.io.Serializable;

public class Bike implements Serializable {
    
    // 定義速度變數，存儲自行車的速度
    protected double speed;

    // 無參數建構子
    public Bike() {
        // 呼叫父類別的建構子（目前沒有顯示使用）
        // super();
        System.out.println("Bike()");  // 顯示Bike()表示建構子被調用
    }

    // 帶一個整數參數的建構子
    public Bike(int a) {
        System.out.println(String.format("Bike(%d)", a));  // 顯示帶有參數的建構子
    }

    // 增加速度的方法
    public Bike upSpeed() {
        // 如果當前速度小於1，設置為1；否則將速度乘以1.4來增加
        speed = speed < 1 ? 1 : speed * 1.4;
        return this;  // 返回當前的物件，允許鏈式調用
    }

    // 降低速度的方法
    public void downSpeed() {
        // 如果當前速度小於1，設置為0；否則將速度乘以0.7來減少
        speed = speed < 1 ? 0 : speed * 0.7;
    }

    // 取得當前速度的方法
    public double getSpeed() {
        return speed;  // 返回當前速度
    }

    // 覆寫 toString 方法，返回自訂的字串表示
    @Override
    public String toString() {
        return "Bike Speed = " + speed;  // 回傳速度資訊
    }

}
