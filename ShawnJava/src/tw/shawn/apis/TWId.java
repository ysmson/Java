package tw.shawn.apis;

import java.util.Random;

public class TWId {
    private String id;  // 用來儲存生成或檢查的台灣身份證字號
    private static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";  // 身份證字號首字母對應的字母表

    // 無參數建構子：根據隨機生成一個性別（男性或女性）來生成台灣身分證字號
    public TWId() {
        this((int)(Math.random() * 2) == 0);  // 隨機生成性別，0 表示男性，1 表示女性
    }

    // 根據性別（男性或女性）來生成台灣身分證字號，性別由布林值決定
    public TWId(boolean isMale) {
        this(isMale, letters.charAt(new Random().nextInt(26)));  // 隨機選擇一個字母作為地區代碼
    }

    // 根據地區字母來生成台灣身分證字號，性別由隨機決定
    public TWId(char area) {
        this((int)(Math.random() * 2) == 0, area);  // 隨機生成性別，0 表示男性，1 表示女性
    }

    // 根據性別和地區代碼來生成台灣身分證字號
    public TWId(boolean isMale, char area) {
        StringBuffer sb = new StringBuffer();
        sb.append(area);  // 加入地區字母
        sb.append(isMale ? '1' : '2');  // 加入性別，'1' 表示男性，'2' 表示女性
        for (int i = 0; i < 7; i++) sb.append(new Random().nextInt(10));  // 隨機生成7位數字

        // 嘗試生成有效的台灣身分證字號
        for (int i = 0; i < 10; i++) {
            if (checkTWId(sb.toString() + i)) {  // 檢查是否是有效的身份證字號
                id = sb.toString() + i;  // 如果有效，儲存該字號
                break;
            }
        }
    }

    // 返回生成或檢查的台灣身分證字號
    public String getId() {
        return id;
    }

    //------------------------------------
    // 建構子：接收一個身份證字號並檢查其有效性
    public TWId(String id) throws Exception {
        if (checkTWId(id)) {  // 檢查身份證字號是否有效
            this.id = id;
        } else {
            throw new Exception();  // 如果無效，拋出異常
        }
    }
    //------------------------------------

    // 檢查是否是有效的台灣身份證字號
    public static boolean checkTWId(String id) {
        boolean isRight = false;

        // 使用正則表達式匹配身份證字號格式：[A-Z][12][0-9]{8}
        if (id.matches("[A-Z][12][0-9]{8}")) {
            char c1 = id.charAt(0);  // 提取地區字母
            int a12 = letters.indexOf(c1) + 10;  // 根據字母查找對應的數字（10-35）
            int a1 = a12 / 10;  // 高位數字
            int a2 = a12 % 10;  // 低位數字

            // 提取身份證字號的數字部分並計算驗證和
            int n1 = Integer.parseInt(id.substring(1, 2));
            int n2 = Integer.parseInt(id.substring(2, 3));
            int n3 = Integer.parseInt(id.substring(3, 4));
            int n4 = Integer.parseInt(id.substring(4, 5));
            int n5 = Integer.parseInt(id.substring(5, 6));
            int n6 = Integer.parseInt(id.substring(6, 7));
            int n7 = Integer.parseInt(id.substring(7, 8));
            int n8 = Integer.parseInt(id.substring(8, 9));
            int n9 = Integer.parseInt(id.substring(9, 10));

            // 驗證和公式計算
            int sum = a1 * 1 + a2 * 9 + n1 * 8 + n2 * 7 + n3 * 6 + n4 * 5
                    + n5 * 4 + n6 * 3 + n7 * 2 + n8 * 1 + n9 * 1;

            isRight = sum % 10 == 0;  // 如果總和能被 10 整除，則是有效的身份證字號
        }

        return isRight;
    }
}
