import java.util.*;
import java.awt.Color;

import javax.swing.*;

public class CentrePanel extends JPanel{
    
    public List<Integer> intList;
    public List<Rectangle> rectangleList;

    public double panelWidth;
    public double panelHeight;

    private int barSpacer = 0;
    private int barSpacing = 0;
    private double barInterval;
    private double heightMultiplier;
    public int currentSize;

    public MainFrame mainFrame;

    public CentrePanel(){
        this.setBackground(new Color(255, 219, 217));
        this.setLayout(null);
        rectangleList = new ArrayList<Rectangle>();
    }


    public void generateRandomArray(int size){
        this.removeAll();
        rectangleList = new ArrayList<>();
        // Create ordered list from 1 to size
        intList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++){
            intList.add(i + 1);
        }

        Collections.shuffle(intList);
        
        for (int i = 0; i < size; i++){
            Rectangle r = new Rectangle(barInterval*i + barSpacing*i, 0 , barInterval + 1, intList.get(i) * heightMultiplier);
            this.add(r);
            rectangleList.add(r);
        }
        this.repaint();
    }

    public void updateBarParameters(int s){
        currentSize = s;
        barInterval = (panelWidth - barSpacer) / currentSize;
        heightMultiplier = panelHeight / currentSize;
    }

    public void updatePositions(List<Rectangle> rectangles){
        for (int i = 0; i < currentSize; i++){
            rectangles.get(i).setBounds(i * (barInterval + barSpacing));
        }
        rectangleList = rectangles;
    }
}
