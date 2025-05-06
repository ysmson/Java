package tw.shawn.tutor;

// 匯入所需的類別與套件
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

// 主類別繼承 JFrame，建立 GUI 視窗
public class GuessNumber extends JFrame{
	private JTextField input;       // 用戶輸入欄位
	private JButton guess;          // 猜按鈕
	//private JTextArea log;        // 原本使用的文字區域（已註解）
	private JTextPane log;          // 使用支援樣式的文字區域
	private String answer;          // 正確答案
	private int i;                  // 猜的次數

	public GuessNumber() {
		super("猜數字遊戲");  // 設定視窗標題
		
		input = new JTextField();   // 建立輸入欄位
		input.setFont(new Font(null, Font.BOLD | Font.ITALIC, 24));  // 設定字型樣式與大小
		
		guess = new JButton("猜");  // 建立按鈕
		//log = new JTextArea();    // 備註：原本使用 JTextArea
		log = new JTextPane();      // 使用 JTextPane 可支援多色樣式輸出
		
		setLayout(new BorderLayout());  // 設定版面配置為 BorderLayout
		JPanel top = new JPanel(new BorderLayout());  // 上方區塊放入按鈕與輸入欄
		top.add(guess, BorderLayout.EAST);            // 按鈕放右側
		top.add(input, BorderLayout.CENTER);          // 輸入欄放中間
		
		add(top, BorderLayout.NORTH);    // 上方區塊放在整體北邊
		add(log, BorderLayout.CENTER);   // 日誌文字區放中間
		
		setSize(640, 480);               // 設定視窗大小
		setVisible(true);                // 顯示視窗
		setDefaultCloseOperation(EXIT_ON_CLOSE);  // 點關閉按鈕就退出程式
		
		initEvent();     // 初始化事件綁定
		initGame();      // 初始化遊戲資料
	}
	
	// 設定按鈕事件
	private void initEvent() {
		guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guessV2();  // 執行猜數字邏輯
			}
		});
	}
	
	// 備註：舊版猜數字邏輯，已註解
//	private void guess() {
//		i++;
//		String inputText = input.getText();
//		String result = checkAB(inputText);
//		log.append(String.format("%s => %s\n", inputText, result ));
//		input.setText("");
//		
//		if (result.equals("3A0B")) {
//			JOptionPane.showMessageDialog(null,"WINNER");
//		}else if (i == 3) {
//			JOptionPane.showMessageDialog(null,"LOSER:" + answer);
//		}
//	}

	// 使用 JTextPane 的新版猜數字邏輯
	private void guessV2() {
		i++;  // 猜的次數 +1
		String inputText = input.getText();           // 取得使用者輸入
		String result = checkAB(inputText);           // 檢查幾A幾B
		
		StyledDocument style = log.getStyledDocument();  // 取得樣式文件對象
		
		// 建立三種顏色樣式
		Style style1 = style.addStyle("style1", null);
		StyleConstants.setForeground(style1, Color.RED);   // 使用者輸入紅色
		
		Style style2 = style.addStyle("style2", null);
		StyleConstants.setForeground(style2, Color.BLACK); // 分隔符號黑色
		
		Style style3 = style.addStyle("style3", null);
		StyleConstants.setForeground(style3, Color.BLUE);  // 結果藍色
		
		try {
			// 插入彩色字串到 log 區域
			style.insertString(style.getLength(), inputText, style1);
			style.insertString(style.getLength(), " => ", style2);
			style.insertString(style.getLength(), result + "\n", style3);
		}catch(Exception e) {
			// 忽略例外（正常不會發生）
		}
		
		input.setText("");  // 清空輸入欄位
		
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null,"WINNER");  // 猜中
		}else if (i == 3) {
			JOptionPane.showMessageDialog(null,"LOSER:" + answer);  // 猜三次失敗
		}
	}
	
	// 初始化遊戲：產生答案與重設猜測次數
	private void initGame() {
		answer = createAnswer(3);  // 產生 3 位數不重複的答案
		i = 0;                     // 重設猜測次數
		System.out.println(answer); // 顯示答案（測試用）
	}
	
	// 檢查幾A幾B的邏輯
	private String checkAB(String g) {
		int A = 0, B = 0;
		for (int i=0; i<answer.length(); i++) {
			if (answer.charAt(i) == g.charAt(i)) {
				A++;  // 數字與位置都正確
			}else if(answer.indexOf(g.charAt(i)) != -1) {
				B++;  // 數字正確但位置錯誤
			}
		}
		return String.format("%dA%dB", A,B);  // 回傳結果
	}
	
	// 產生不重複的亂數數字（類似洗牌）
	private static String createAnswer(int d) {
		int nums = 10;
		int[] poker = new int[nums];
		for (int i=0; i<poker.length; i++) poker[i] = i;  // 初始化陣列 0~9
		
		// Fisher–Yates 洗牌演算法
		for (int i=nums-1; i>0 ;i--) {
			int rindex = (int)(Math.random()*(i+1));
			
			int temp = poker[rindex];
			poker[rindex] = poker[i];
			poker[i] = temp;
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<d; i++)sb.append(poker[i]);  // 選取前 d 位當作答案
		
		return sb.toString();
	}

	// 程式進入點
	public static void main(String[] args) {
		new GuessNumber();  // 建立並顯示遊戲視窗
	}
}
