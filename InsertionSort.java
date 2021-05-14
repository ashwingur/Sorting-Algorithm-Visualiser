import java.awt.Color;

public class InsertionSort extends Sort{

    private int i = 1;
    private int compareIndex = 0;

    private Rectangle prev1;
    private Rectangle prev2;


    @Override
    public void initiate(CentrePanel centrePanel) {
        this.centrePanel = centrePanel;
        this.rectangles = centrePanel.rectangleList;
        i = 1;
        compareIndex = 1;
        timer.start();
        BottomPanel.initiated = true;
    }

    @Override
    public void sort() {
        if (prev1 != null){
            prev1.setBackground(Color.BLACK);
            prev2.setBackground(Color.BLACK);
        }
        // Once i reaches array size, the sort is over, if compare index becomes negative
        // then reset compareIndex and increment i.
        if (i == rectangles.size()){
            timer.stop();
            BottomPanel.initiated = false;
            rectangles.get(i - 1).setBackground(Color.BLACK);
            return;
        } else if (compareIndex < 0){
            compareIndex = i;
            i++;
        }
        Rectangle r1 = rectangles.get(compareIndex);
        Rectangle r2 = rectangles.get(compareIndex + 1);
        r1.setBackground(Color.RED);
        r2.setBackground(Color.RED);
        rectangles.get(i).setBackground(Color.GREEN);
        prev1 = r1;
        prev2 = r2;
        // Swap the right element with the left if right is smaller, if not, then current i has been sorted
        // so increment and move onto next i.
        if (r2.value() < r1.value()){
            double temp = r1.value();
            r1.setValue(r2.value());
            r2.setValue(temp);
            compareIndex--;
            
        } else {
            compareIndex = i;
            i++; 
        }
    }

    
}
