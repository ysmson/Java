package tw.shawn.apis;

public class Scooter extends Bike {
    
    // Scooter 類別的建構子，呼叫父類別 Bike 的建構子，並傳遞數字 2
    public Scooter() {
        super(2);  // 呼叫父類別 Bike 的建構子並傳遞 2
        System.out.println("Scooter()");  // 顯示 "Scooter()"，表示建構子被呼叫
    }

    // 重新定義父類別 Bike 的 upspeed 方法，這是用來加速的功能
    public void upspeed() {
        // 如果 speed 小於 1，則將 speed 設為 2，否則 speed 會乘以 2
        speed = speed < 1 ? 2 : speed * 2;
    }
}
