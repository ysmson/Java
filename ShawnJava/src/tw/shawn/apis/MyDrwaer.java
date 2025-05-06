package tw.shawn.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyDrwaer extends JPanel {
    
    // 用來儲存繪製的線條和被撤銷的線條
    private ArrayList<Line> lines, recycle;
    
    // 設定預設的顏色
    private Color defaultColor;
    
    // 建構子：初始化顏色、線條集合、撤銷線條集合、並註冊鼠標事件監聽器
    public MyDrwaer() {
        setBackground(Color.YELLOW);  // 設定背景顏色為黃色
        
        defaultColor = Color.BLUE;  // 設定預設顏色為藍色
        lines = new ArrayList<Line>();  // 初始化線條集合
        recycle = new ArrayList<Line>();  // 初始化撤銷線條集合
        
        MyListener myListener = new MyListener();  // 建立自定義的鼠標事件監聽器
        addMouseListener(myListener);  // 添加鼠標按下事件
        addMouseMotionListener(myListener);  // 添加鼠標拖動事件
    }
    
    // 自定義的 MouseListener，用來監聽鼠標事件
    private class MyListener extends MouseAdapter {
        
        // 當鼠標按下時觸發的事件
        @Override
        public void mousePressed(MouseEvent e) {
            Line line = new Line(defaultColor);  // 創建一條新的線條，設置顏色
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
        for (Line line : lines) {
            g2d.setColor(line.getColor());  // 設定當前線條的顏色
            // 遍歷線條上的每個點，繪製連接點
            for (int i = 1; i < line.length(); i++) {
                Point p1 = line.getPoint(i - 1);
                Point p2 = line.getPoint(i);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);  // 繪製點與點之間的線段
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
    
    // 保存線條到文件
    public void saveObj(File saveFile) throws Exception {
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(saveFile));
        oout.writeObject(lines);  // 保存線條集合到文件
        oout.flush();  // 刷新流
        oout.close();  // 關閉流
    }
    
    // 從文件加載線條
    public void loadObj(File loadFile) throws Exception {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(loadFile));
        lines = (ArrayList<Line>) oin.readObject();  // 從文件讀取線條集合
        oin.close();  // 關閉流
        
        recycle.clear();  // 清空撤銷堆疊
        repaint();  // 重繪面板
    }
    
    // 保存畫布為 JPEG 圖像
    public boolean saveJPEG() throws Exception {
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        paint(g2d);  // 把當前畫布繪製到圖片中
        
        try {
            return ImageIO.write(img, "jpg", new File("dir2/brad.jpg"));  // 保存為 JPEG 文件
        } catch (IOException e) {
            throw new Exception();  // 捕獲並重新拋出異常
        }
    }
}
