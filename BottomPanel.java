import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BottomPanel extends JPanel {

    private JSlider arraySizeSlider;
    private JSlider speedSlider;
    private JSlider timerDelaySlider;
    public CentrePanel centrePanel;
    private JButton randomiseButton;
    private JComboBox<String> algChooser;
    private JComboBox<Integer> speedMultiplier;
    private JComboBox<Integer> sizeMultiplier;
    private String[] algs;
    private Map<String, Sort> algorithm;

    private Sort currentlyActive;

    public static boolean initiated = false;
    public static int speed = 1;
    public static final int initialArraySize = 50;

    public BottomPanel() {
        this.setBackground(new Color(255, 243, 224));
        this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new FlowLayout());

        JButton sortButton = new JButton("Sort");
        sortButton.setPreferredSize(new Dimension(100, 50));
        sortButton.setFocusable(false);
        sortButton.addActionListener(e -> {if (!initiated){
            currentlyActive.cancel();
            Sort s = algorithm.get(algChooser.getSelectedItem());
            s.initiate(centrePanel);
            currentlyActive = s;};
        });        

        randomiseButton = new JButton("Randomize");
        randomiseButton.setPreferredSize(new Dimension(100, 50));
        randomiseButton.setFocusable(false);
        randomiseButton.addActionListener(e -> {centrePanel.updateBarParameters(getArraySize());
                                                centrePanel.generateRandomArray(getArraySize());
                                                initiated = false;});


        arraySizeSlider = new JSlider(5, 105, initialArraySize);
        arraySizeSlider.setPreferredSize(new Dimension(400, 40));
        arraySizeSlider.setOpaque(false);
        arraySizeSlider.setPaintTicks(true);
        arraySizeSlider.setMinorTickSpacing(10);
        arraySizeSlider.setPaintTrack(true);
        arraySizeSlider.setMajorTickSpacing(10);
        arraySizeSlider.setPaintLabels(true);

        speedSlider = new JSlider(0, 50, 1);
        speedSlider.setPreferredSize(new Dimension(400, 40));
        speedSlider.setOpaque(false);
        speedSlider.setPaintTicks(true);
        speedSlider.setMinorTickSpacing(5);
        speedSlider.setPaintTrack(true);
        speedSlider.setMajorTickSpacing(5);
        speedSlider.setPaintLabels(true);

        timerDelaySlider = new JSlider(10, 160, 10);
        timerDelaySlider.setPreferredSize(new Dimension(400, 40));
        timerDelaySlider.setOpaque(false);
        timerDelaySlider.setPaintTicks(true);
        timerDelaySlider.setMinorTickSpacing(25);
        timerDelaySlider.setPaintTrack(true);
        timerDelaySlider.setMajorTickSpacing(25);
        timerDelaySlider.setPaintLabels(true);

        algs = new String[] {"BubbleSort", "InsertionSort", "MergeSort"};
        algorithm = new HashMap<String, Sort>();
        algorithm.put("BubbleSort", new BubbleSort());
        algorithm.put("InsertionSort", new InsertionSort());
        algorithm.put("MergeSort", new MergeSort());

        algChooser = new JComboBox<String>(algs);
        algChooser.setPreferredSize(new Dimension(200, 50));
        currentlyActive = algorithm.get(algChooser.getSelectedItem());

        Integer[] speeds = new Integer[] {1, 2, 5, 10, 20, 50, 100};
        speedMultiplier = new JComboBox<Integer>(speeds);

        Integer[] sizes = new Integer[] {1, 2, 5, 10, 20, 50, 100};
        sizeMultiplier = new JComboBox<Integer>(sizes);
        
        arraySizeSlider.addChangeListener(e -> updateArraySize());
        sizeMultiplier.addActionListener(e -> updateArraySize());

        speedSlider.addChangeListener(ce -> updateSpeed());
        speedMultiplier.addActionListener(e -> updateSpeed());

        timerDelaySlider.addChangeListener(e -> algorithm.get(algChooser.getSelectedItem()).updateTimerDelay(timerDelaySlider.getValue()));

        algChooser.addActionListener(e -> {initiated = false;
            });

        this.add(arraySizeSlider);
        this.add(sizeMultiplier);
        this.add(speedSlider);
        this.add(speedMultiplier);
        this.add(timerDelaySlider);
        this.add(algChooser);
        this.add(sortButton);
        this.add(randomiseButton);
    }


    public int getArraySize(){
        return arraySizeSlider.getValue() * (int) sizeMultiplier.getSelectedItem();
    }

    public int updateSpeed(){
        speed = speedSlider.getValue() * (int) speedMultiplier.getSelectedItem();
        return speedSlider.getValue() * (int) speedMultiplier.getSelectedItem();
    }

    public void updateArraySize(){
        centrePanel.updateBarParameters(getArraySize());
        centrePanel.generateRandomArray(getArraySize());
        initiated = false;
    }
}


