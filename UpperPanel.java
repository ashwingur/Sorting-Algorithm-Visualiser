import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;


public class UpperPanel extends JPanel{
    

    public UpperPanel(){

        // BG colour for test purposes
        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension(100, 100));

        JLabel title = new JLabel("Sorting Algorithm Visualiser");
        title.setFont(new Font("Serif", Font.BOLD, 60));
        this.add(title, BorderLayout.CENTER);
    }
}
