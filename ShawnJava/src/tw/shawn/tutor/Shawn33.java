package tw.shawn.tutor;

// 匯入 Swing 與事件相關的類別
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Shawn33 類別：
 * 使用 Java Swing 製作 GUI 視窗，包含三個按鈕。
 * 本類別同時實作 ActionListener 介面，處理按鈕事件。
 */
public class Shawn33 extends JFrame implements ActionListener {
	private JButton b1, b2, b3; // 宣告三個按鈕成員變數

	// 建構子：設定視窗內容與元件
	public Shawn33() {
		// 初始化按鈕元件
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");

		// 設定版面配置為 FlowLayout（由左至右排列）
		setLayout(new FlowLayout());

		// 將按鈕加入到 JFrame 中
		add(b1);
		add(b2);
		add(b3);

		// 設定視窗大小與基本屬性
		setSize(640, 480); // 視窗大小：640x480
		setVisible(true);  // 設定視窗可見
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 關閉視窗時結束程式

		// 呼叫方法初始化事件綁定
		initEvent();
	}

	// 初始化事件監聽器（將按鈕與 this 類別綁定）
	private void initEvent() {
		b1.addActionListener(this); // this 表示目前的 Shawn33 物件
		b2.addActionListener(this);
		b3.addActionListener(this);
	}

	// 主方法：程式入口點
	public static void main(String[] args) {
		new Shawn33(); // 建立物件，啟動 GUI 應用
	}

	// 實作 ActionListener 介面的必備方法：處理按鈕點擊事件
	@Override
	public void actionPerformed(ActionEvent e) {
		// 判斷是哪一顆按鈕被點擊，並顯示對應訊息
		if (e.getSource() == b1) {
			System.out.println("B1");
		} else if (e.getSource() == b2) {
			System.out.println("B2");
		} else if (e.getSource() == b3) {
			System.out.println("B3");
		}
	}
}

// 額外的事件監聽器類別（目前未被使用）
class MyListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// 印出觸發事件的按鈕文字（例如 B1）
		System.out.println(e.getActionCommand());

		// 以下程式碼因為無法直接存取 b1, b2, b3 而被註解
		// if (e.getSource() == b1) { ... }
	}
}
