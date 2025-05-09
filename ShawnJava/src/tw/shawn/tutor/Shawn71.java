package tw.shawn.tutor;

import tw.shawn.apis.BCrypt;

public class Shawn71 {
	public static void main(String[] args) {
		// 定義原始密碼
		String passwd = "123456";
		// 使用 BCrypt.hashpw() 方法對密碼進行雜湊處理，並生成 salt
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		// 印出雜湊後的密碼
		System.out.println(hashPasswd);
		
		// 定義要驗證的輸入密碼
		String input = "123456";
		// 使用 BCrypt.checkpw() 方法驗證輸入密碼是否與雜湊後的密碼匹配
		if (BCrypt.checkpw(input, hashPasswd)) {
			// 如果匹配，印出 "OK"
			System.out.println("OK");
		}else {
			// 如果不匹配，印出 "XX"
			System.out.println("XX");
		}
		
		
	}
}