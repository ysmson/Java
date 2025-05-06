package tw.shawn.tutor;

public class Shawn26 {
    public static void main(String[] args) {
        // 宣告字串變數並賦值
        String name = "Shawn";
        
        // 使用 concat() 方法將 "OK" 串接到 "Shawn" 後面
        String name2 = name.concat("OK");
        // 輸出 name2，這時會輸出 "ShawnOK"
        System.out.println(name2);
        
        // 使用 replace() 方法將 name2 中的字符 'B' 替換成 'b'
        // 注意，'B' 並不在 "ShawnOK" 中，所以不會有變化
        String name3 = name2.replace('B', 'b');
        // 輸出 name3，結果仍然是 "ShawnOK"
        System.out.println(name3);
    }
}
