package tw.shawn.tutor;

public class Shawn23 {

    public static void main(String[] args) {
        // 創建 Shawn233 類的實例
        Shawn233 obj = new Shawn233();
        
        // 呼叫 obj 的 toString() 方法，並打印出結果
        System.out.println(obj);
    }
}

// Shawn231 類，包含一個帶有參數的建構子
class Shawn231 {
    // Shawn231 類的建構子，接受一個 String 類型的參數
    Shawn231(String a) {
        // 可選擇使用 super() 調用父類別的建構子，但此處註解掉
        // super();
    }
}

// Shawn232 類，繼承自 Shawn231 類
class Shawn232 extends Shawn231 {
    // Shawn232 類的建構子，接受一個整數參數
    Shawn232(int a) {
        // 呼叫父類別（Shawn231）的建構子，並傳遞 "ok" 參數
        super("ok");
    }
}

// Shawn233 類，繼承自 Shawn232 類
class Shawn233 extends Shawn232 {
    // 無參數的建構子，調用父類別（Shawn232）的建構子，並傳遞整數 1
    Shawn233() {
        super(1);
    }

    // 帶有整數參數的建構子，調用父類別（Shawn232）的建構子，並傳遞整數 1
    Shawn233(int a) {
        super(1);
    }

    // 帶有字節型參數的建構子，調用父類別（Shawn232）的建構子，並傳遞整數 1
    Shawn233(byte a) {
        super(1);
    }

    // 帶有雙精度型參數的建構子，調用父類別（Shawn232）的建構子，並傳遞整數 1
    Shawn233(double a) {
        super(1);
    }

    // 重寫 toString() 方法，返回字串 "Shawn233"
    public String toString() {
        return "Shawn233";
    }
}
