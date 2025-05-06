package tw.shawn.tutor;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Shawn20 extends JFrame {
    
    // 定義三個按鈕
    private JButton b1, b2, b3;
    
    // 設置視窗內容與基本屬性
    public Shawn20() {
        // 設置視窗標題
        super("偶的視窗");
        
        // 創建三個按鈕，並設置按鈕顯示的文字
        b1 = new JButton("B1");
        b2 = new JButton("B2");
        b3 = new JButton("B3");
        
        // 設置佈局為 FlowLayout，使按鈕由左至右排列
        setLayout(new FlowLayout());
        
        // 將按鈕添加到視窗中
        add(b1); 
        add(b2); 
        add(b3);
        
        // 設置視窗的大小
        setSize(640, 480);
        
        // 設置視窗為可見
        setVisible(true);
        
        // 設置視窗關閉時，結束程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // 主方法，啟動程式並顯示視窗
    public static void main(String[] args) {
        // 創建並顯示 Shawn20 視窗
        new Shawn20();
    }
}
