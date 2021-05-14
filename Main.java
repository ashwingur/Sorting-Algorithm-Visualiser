import java.awt.BorderLayout;

public class Main {
    
    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
        UpperPanel upperPanel = new UpperPanel();
        CentrePanel centrePanel = new CentrePanel();
        BottomPanel bottomPanel = new BottomPanel();
        bottomPanel.centrePanel = centrePanel;
        centrePanel.mainFrame = mainFrame;
        mainFrame.add(upperPanel, BorderLayout.NORTH);
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);
        mainFrame.add(centrePanel, BorderLayout.CENTER);
        
        mainFrame.setVisible(true);
        centrePanel.panelWidth = centrePanel.getWidth();
        centrePanel.panelHeight = centrePanel.getHeight();
        centrePanel.updateBarParameters(50);
        centrePanel.generateRandomArray(50);
    
        
    }
}
