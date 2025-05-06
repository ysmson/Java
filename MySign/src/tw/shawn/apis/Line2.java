package tw.shawn.apis;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

public class Line2 {
    
    // 存儲線段上的點，每個點是一個包含 "x" 和 "y" 座標的 HashMap
    private ArrayList<HashMap<String, Integer>> points;
    
    // 這條線段的顏色
    private Color color;
    
    // 以顏色初始化的建構子
    public Line2(Color color) {
        points = new ArrayList<>();  // 初始化存儲點的集合
        this.color = color;  // 設置線段顏色
    }
    
    // 添加一個點到線段，點的座標以 x 和 y 形式存儲
    public void addPoint(int x, int y) {
        HashMap<String, Integer> p = new HashMap<>();  // 創建一個新的 HashMap 用來存儲點的座標
        p.put("x", x);  // 存儲 x 座標
        p.put("y", y);  // 存儲 y 座標
        points.add(p);  // 將這個點加入到線段的點集合中
    }
    
    // 根據索引獲取線段上的某一個點
    public HashMap<String, Integer> getPoint(int index) {
        return points.get(index);  // 返回對應索引的點（以 HashMap 形式）
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
