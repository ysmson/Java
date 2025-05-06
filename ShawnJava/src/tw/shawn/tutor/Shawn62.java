package tw.shawn.tutor;

public class Shawn62 {
	public static void main(String[] args) {
		System.out.println("main start");
		Shawn621 obj1 = new Shawn621("A");
		Shawn621 obj2 = new Shawn621("B");
		Shawn622 obj3 = new Shawn622("C");
		Thread mt1 = new Thread(obj3);
		obj1.start();
		obj2.start();
		mt1.start();
		System.out.println("main finish");
	}
}

class Shawn621 extends Thread {
	private String name;
	Shawn621(String name){this.name = name;}
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
	public void m1() {
		System.out.println("Shawn621:m1()");
	}
}

class Shawn622 implements Runnable {
	private String name;
	Shawn622(String name){this.name = name;}
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
	public void m1() {
		System.out.println("Shawn621:m1()");
	}
	
}
