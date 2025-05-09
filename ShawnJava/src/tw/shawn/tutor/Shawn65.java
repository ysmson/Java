package tw.shawn.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Shawn65 {
	public static void main(String[] args) {
		// 創建一個 Timer 物件
		Timer timer = new Timer();
		// 使用 Timer 排程 Shawn651 這個 TimerTask，從 0 毫秒後開始執行，每 1 秒執行一次
		timer.schedule(new Shawn651(), 0, 1*1000);
		// 使用 Timer 排程 StopTask 這個 TimerTask，在 10 秒後執行一次
		timer.schedule(new StopTask(timer), 10*1000);
		System.out.println("main finish");
	}
}
// 定義一個繼承自 TimerTask 的類別 Shawn651
class Shawn651 extends TimerTask {
	private int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}
// 定義一個繼承自 TimerTask 的類別 StopTask
class StopTask extends TimerTask {
	private Timer timer;
	public StopTask(Timer timer) {
		this.timer = timer;
	}
	@Override
	public void run() {
		// 取消 Timer 的所有排程任務
		timer.cancel();
		// 從 Timer 的任務佇列中移除所有已取消的任務
		timer.purge();
		// 將 Timer 物件設為 null，幫助垃圾回收
		timer = null;
	}
}