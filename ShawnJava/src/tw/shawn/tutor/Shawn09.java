package tw.shawn.tutor;

import java.util.Scanner;

public class Shawn09 {
    
	// 判斷是否為閏年
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 讓使用者輸入年份
        System.out.print("請輸入年份：");
        int year = scanner.nextInt();
        boolean isLeap = false;  // 初始設定為非閏年
        
        // 判斷閏年的規則
        if (year % 4 == 0) {  // 必須能被4整除
			if (year % 100 == 0) {  // 如果能被100整除
				if (year % 400 == 0) {  // 如果能被400整除
					isLeap = true;  // 為閏年
				}
			} else {  // 如果不能被100整除
				isLeap = true;  // 為閏年
			}
		}
        
        // 輸出是否閏年
        System.out.printf("%d 年是%s年", year, isLeap ? "潤" : "平");
        
        scanner.close();  // 關閉 Scanner
    }
}
