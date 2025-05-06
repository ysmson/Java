package tw.shawn.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class MyDrwaer2 extends JPanel {

    // 儲存線條的集合，每條線是由 HashMap 存儲座標組成的
    private ArrayList<Line2> lines, recycle;
    
    // 設定預設的顏色
    private Color defaultColor;

    // 建構子：初始化顏色、線條集合、撤銷線條集合、並註冊鼠標事件監聽器
    public MyDrwaer2() {
        setBackground(Color.YELLOW);  // 設定背景顏色為黃色

        defaultColor = Color.BLUE;  // 設定預設顏色為藍色
        lines = new ArrayList<>();  // 初始化線條集合
        recycle = new ArrayList<>();  // 初始化撤銷線條集合

        MyListener myListener = new MyListener();  // 建立自定義的鼠標事件監聽器
        addMouseListener(myListener);  // 添加鼠標按下事件
        addMouseMotionListener(myListener);  // 添加鼠標拖動事件
    }

    // 自定義的 MouseListener，用來監聽鼠標事件
    private class MyListener extends MouseAdapter {

        // 當鼠標按下時觸發的事件
        @Override
        public void mousePressed(MouseEvent e) {
            Line2 line = new Line2(defaultColor);  // 創建一條新的線條，設置顏色
            line.addPoint(e.getX(), e.getY());  // 添加按下時的點
            lines.add(line);  // 把新線條加入到線條集合中
            recycle.clear();  // 清空撤銷堆疊
        }

        // 當鼠標拖動時觸發的事件
        @Override
        public void mouseDragged(MouseEvent e) {
            lines.get(lines.size() - 1).addPoint(e.getX(), e.getY());  // 向當前線條添加拖動過程中的點
            repaint();  // 重繪面板
        }
    }

    // 覆寫 paintComponent 方法來繪製線條
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // 先執行父類的 paintComponent

        Graphics2D g2d = (Graphics2D) g;  // 轉換為 2D 繪圖對象
        g2d.setStroke(new BasicStroke(4));  // 設定線條粗細

        // 遍歷每條線，繪製每條線
        for (Line2 line : lines) {
            g2d.setColor(line.getColor());  // 設定當前線條的顏色
            // 遍歷線條上的每個點，繪製連接點
            for (int i = 1; i < line.length(); i++) {
                // 獲取每兩個相鄰的點
                HashMap<String, Integer> p1 = line.getPoint(i - 1);
                HashMap<String, Integer> p2 = line.getPoint(i);
                g2d.drawLine(p1.get("x"), p1.get("y"), p2.get("x"), p2.get("y"));  // 繪製點與點之間的線段
            }
        }
    }

    // 清除所有繪製的線條
    public void clear() {
        lines.clear();  // 清空線條集合
        recycle.clear();  // 清空撤銷堆疊
        repaint();  // 重繪面板
    }

    // 撤銷最後繪製的線條
    public void undo() {
        if (lines.size() > 0) {
            recycle.add(lines.remove(lines.size() - 1));  // 把最後一條線移到撤銷堆疊中
            repaint();  // 重繪面板
        }
    }

    // 重做撤銷的線條
    public void redo() {
        if (recycle.size() > 0) {
            lines.add(recycle.remove(recycle.size() - 1));  // 把撤銷堆疊中的線條加回線條集合
            repaint();  // 重繪面板
        }
    }

    // 獲取預設顏色
    public Color getDefaultColor() {
        return defaultColor;
    }

    // 設定預設顏色
    public void setDefaultColor(Color newColor) {
        defaultColor = newColor;
    }
}
