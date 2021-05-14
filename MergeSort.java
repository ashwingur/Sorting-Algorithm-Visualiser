import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class MergeSort extends Sort {

    private int blockSize;
    private List<Rectangle> temporary;
    private int groupIndex;

    private List<Rectangle> left;
    private List<Rectangle> right;
    private int l;
    private int r;
    private int lSize;
    private int rSize;
    private boolean currentGroupComplete;

    private Rectangle previous = new Rectangle(0,0,0,0);

    @Override
    public void initiate(CentrePanel centrePanel) {
        this.centrePanel = centrePanel;
        this.rectangles = new ArrayList<Rectangle>(centrePanel.rectangleList);
        blockSize = 1;
        groupIndex = 0;
        BottomPanel.initiated = true;
        currentGroupComplete = true;
        l = 0;
        r = 0;
        temporary = new ArrayList<Rectangle>();
        timer.start();
    }

    @Override
    public void sort() {
        previous.setBackground(Color.BLACK);
        // Do this if current pair of blocks is not yet sorted
        if (!currentGroupComplete){
            // If neither left and right have been sorted
            if (l < lSize && r < rSize){
                if (left.get(l).value() <= right.get(r).value()){
                    previous = left.get(l);
                    temporary.add(left.get(l));
                    l++;
                } else {
                    previous = right.get(r);
                    temporary.add(right.get(r));
                    r++;
                }
            } else if (l < lSize){
                previous = left.get(l);
                temporary.add(left.get(l));
                l++; 
            } else if (r < rSize){
                previous = right.get(r);
                temporary.add(right.get(r));
                r++;
            } else {
                // They have been sorted, move onto the next group
                currentGroupComplete = true;
                groupIndex += 2;
            }

            // Update the rectangle list to the more sorted state, and also update rectangle positions for display
            List<Rectangle> toDisplay = new ArrayList<Rectangle>(temporary);
            toDisplay.addAll(new ArrayList<>(rectangles.subList(temporary.size(), rectangles.size())));
            rectangles = toDisplay;
            centrePanel.updatePositions(rectangles);


        } else {
            // Sorting finished
            if (blockSize * 2 >= rectangles.size()){
                timer.stop();
                BottomPanel.initiated = false;
                return;
            }

            // Current block size has finished, double the block size and go back to the start
            if (temporary.size() == rectangles.size()){
                blockSize *= 2;
                groupIndex = 0;
                temporary = new ArrayList<Rectangle>();
            }

            // If the next left block has run out of elements
            // If the next right block has run out of elements
            // Otherwise, the next left and right blocks are the normal block size
            if (blockSize * (groupIndex + 1) > rectangles.size()){
                left = rectangles.subList(groupIndex * blockSize, rectangles.size());
                right = new ArrayList<Rectangle>();
            } else if (blockSize * (groupIndex + 2) > rectangles.size()){
                left = rectangles.subList(groupIndex * blockSize, groupIndex * blockSize + blockSize);
                right = rectangles.subList(groupIndex * blockSize + blockSize, rectangles.size());
            } else {
                left = new ArrayList<>(rectangles.subList(groupIndex * blockSize, groupIndex * blockSize + blockSize));
                right = new ArrayList<>(rectangles.subList(groupIndex * blockSize + blockSize, groupIndex * blockSize + 2 * blockSize));
            }
            l = 0;
            r = 0;
            lSize = left.size();
            rSize = right.size();
            currentGroupComplete = false;
        }
        previous.setBackground(Color.GREEN);
    }    
}
