package tw.shawn.tutor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Shawn68 {
	public static void main(String[] args) {
		// 取得當前日期
		LocalDate date = LocalDate.now();
		// 取得當前時間
		LocalTime time = LocalTime.now();
		// 取得當前日期時間
		LocalDateTime datetime = LocalDateTime.now();
		
		// 印出日期、時間、日期時間
		System.out.println(date);
		System.out.println(time);
		System.out.println(datetime);
		
		// 創建 DateTimeFormatter，指定日期時間格式
		DateTimeFormatter formater = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// 將 LocalDateTime 格式化為字串
		String strDatetime = datetime.format(formater);
		// 印出格式化後的日期時間字串
		System.out.println(strDatetime);
		
		//---------------------
		// 定義一個日期時間字串
		String input = "1999-01-02 10:20:30";
		// 使用 DateTimeFormatter 解析字串為 LocalDateTime
		LocalDateTime dd = LocalDateTime.parse(input, formater);
		// 印出解析後的 LocalDateTime
		System.out.println(dd);
		//--------
		// 在當前日期加上 4 週
		LocalDate nndate = date.plusWeeks(4);
		// 印出計算後的日期
		System.out.println(nndate);
		// 從當前日期減去 6 個月
		LocalDate lmonth = date.minusMonths(6);
		// 印出計算後的日期
		System.out.println(lmonth);
		//------------
		// 定義生日日期
		LocalDate birthday = LocalDate.of(1966, 2, 5);
		// 計算生日到今天的期間
		Period pp = Period.between(birthday, date);
		// 印出年、月、日
		System.out.printf("%d 年 %d 個月又 %d 天",
			pp.getYears(), pp.getMonths(), pp.getDays());
		//-----
		
		
		
		
		
		
		
		
		
	}
}