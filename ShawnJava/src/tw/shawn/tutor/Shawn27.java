package tw.shawn.tutor;

import tw.shawn.apis.TWId;

public class Shawn27 {

    public static void main(String[] args) {
        // 驗證台灣身分證字號是否有效
        if (TWId.checkTWId("A123456789")) {
            // 如果身分證字號有效，輸出 "OK"
            System.out.println("OK");
        } else {
            // 如果身分證字號無效，輸出 "XX"
            System.out.println("XX");
        }

        System.out.println("----");

        // 建立不同的 TWId 物件
        TWId id1 = new TWId();  // 預設建構子，應該會產生一個有效的身分證字號
        TWId id2 = new TWId(false);  // 可能是使用特定參數的建構子，false 可能代表無效或特定的模式
        TWId id3 = new TWId('X');  // 可能是根據指定的字母來創建身分證字號
        TWId id4 = new TWId(true, 'R');  // 這裡傳入了 true 和 'R'，這可能代表某種特殊情況的身分證字號

        // 輸出每個 TWId 物件所生成的身分證字號
        System.out.println(id1.getId());
        System.out.println(id2.getId());
        System.out.println(id3.getId());
        System.out.println(id4.getId());

        System.out.println("-----");

        // 測試創建一個身分證字號的靜態方法
        // 注意：此段程式碼被註解掉了
//        TWId id5 = TWId.createTWId("A123456789");
//        if (id5 != null) {
//            System.out.println(id5.getId());
//        } else {
//            System.out.println("XX");
//        }
    }
}
