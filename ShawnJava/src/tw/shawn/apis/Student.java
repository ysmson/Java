package tw.shawn.apis;

import java.io.Serializable;

public class Student implements Serializable {
    // 定義學生的屬性：姓名、三科成績和一輛自行車
    private String name;
    private int ch, eng, math;  // 中文、英文和數學成績
    private Bike bike;  // 學生擁有一輛自行車

    // 建構子：初始化學生的姓名和成績，同時創建一輛新的 Bike 物件
    public Student(String name, int ch, int eng, int math) {
        this.name = name;
        this.ch = ch;
        this.eng = eng;
        this.math = math;
        bike = new Bike();  // 創建一個新的 Bike 物件
    }

    // 計算學生的總分
    public int score() {
        return ch + eng + math;  // 返回中文、英文和數學三科成績的總和
    }

    // 計算學生的平均分
    public double avg() {
        return score() / 3.0;  // 返回總分除以 3，獲得平均分
    }

    // 獲取學生的姓名
    public String getName() {
        return name;
    }

    // 獲取學生的自行車物件
    public Bike getBike() {
        return bike;
    }
}
