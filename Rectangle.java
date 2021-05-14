import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Rectangle extends JPanel{
    
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setBounds(x, y, width, height);
        this.setBackground(Color.BLACK);
    }

	@Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
    }

    public String toString(){
        // return x + "|" + y + "|" + width + "|" + height + ", ";
        return Integer.toString((int) height);
    }

    public double value(){
        return this.height;
    }

    public void setValue(double val){
        this.height = val;
        this.setBounds((int) x, (int) y, (int) width, (int) height);
    }

    public void setX(double x){
        this.x = x;
    }

    public void setBounds(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        super.setBounds((int) x, (int) y, (int) width, (int) height);
    }

    public void setBounds(double x, double height) {
        this.x = x;
        this.height = height;
        super.setBounds((int) x, (int) y, (int) width, (int) height);
    }

    public void setBounds(double x) {
        this.x = x;
        super.setBounds((int) x, (int) y, (int) width, (int) height);
    }
}
