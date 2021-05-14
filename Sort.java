import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;


public abstract class Sort {
    protected List<Rectangle> rectangles;
    protected CentrePanel centrePanel;
    protected Timer timer;

    public Sort(){
        timer = new Timer(25, e -> {for (int j = 0; j < BottomPanel.speed; j++){this.sort();}});

    }

    public abstract void initiate(CentrePanel centrePanel);
    public abstract void sort();

    public void updateTimerDelay(int delay){
        timer.setDelay(delay);
    }

    public void cancel(){
        timer.stop();
        BottomPanel.initiated = false;
    }
}
