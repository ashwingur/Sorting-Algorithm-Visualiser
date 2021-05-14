import java.util.*;
import javax.swing.Timer;
import java.awt.Color;

public class BubbleSort extends Sort{
    

    private int i = 0;
    private boolean sorted = false;
    private int sizeToSort;

    public void initiate(CentrePanel centrePanel){
        this.centrePanel = centrePanel;
        this.rectangles = centrePanel.rectangleList;
        i = 0;
        sorted = false;
        sizeToSort = rectangles.size();
        timer.start();
        BottomPanel.initiated = true;
        
    }

    public void sort(){
        if (i == 0){
            if (sorted){
                timer.stop();
                BottomPanel.initiated = false;
            }
            sorted = true;
        }
        Rectangle r1 = rectangles.get(i);
        Rectangle r2 = rectangles.get(i + 1);
        if (rectangles.get(i).value() > rectangles.get(i + 1).value()){
            sorted = false;
            double temp = r2.value();
            
            r2.setValue(r1.value());
            r1.setValue(temp);
            r1.setBackground(Color.RED);
            r2.setBackground(Color.RED);
        }
        if (i < sizeToSort - 2){
            i++;
        } else {
            i = 0;
            r2.setBackground(Color.BLACK);
            // For optimisation, since we know after each cycle, the next last element is sorted.
            sizeToSort--;
        }
        centrePanel.repaint();
        r1.setBackground(Color.BLACK);
    }

}
