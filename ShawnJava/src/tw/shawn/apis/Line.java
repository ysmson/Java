package tw.shawn.apis;

import java.awt.Color;
import java.util.ArrayList;

public class Line {
    
    // 存儲線段上的點的集合
    private ArrayList<Point> points;
    
    // 這條線段的顏色
    private Color color;
    
    // 以顏色初始化的建構子
    public Line(Color color) {
        points = new ArrayList<Point>();  // 初始化存儲點的集合
        this.color = color;  // 設置線段顏色
    }
    
    // 添加一個點到線段
    public void addPoint(int x, int y) {
        Point p = new Point(x, y);  // 創建一個新的點
        points.add(p);  // 將點加入線段的點集合
    }
    
    // 根據索引獲取線段上的某一個點
    public Point getPoint(int index) {
        return points.get(index);  // 返回對應索引的點
    }
    
    // 返回線段上的點的數量（即線段的長度）
    public int length() {
        return points.size();  // 返回點集合的大小，即線段的長度
    }
    
    // 獲取線段的顏色
    public Color getColor() {
        return color;  // 返回線段的顏色
    }
    
}
