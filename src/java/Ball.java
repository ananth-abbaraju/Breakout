import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.font.*;
public class Ball {

    private int xPos, yPos, diameter;
    private int xa;
    private int ya;
    private Breakout breakout;

    // public void paintLost(Graphics g){
    //     // super.paint(g);
    //     g.setFont(new java.awt.Font("Arial", 2, 38));
    //     g.setColor(Color.MAGENTA);
    //     g.drawString("YOU LOST!", 105, 225);
    //     xa = 0;
    //     ya = 0;
    // }
 
    public Ball(int x, int y, Breakout out) { 

        xPos = x;
        yPos = y;
        diameter = 10;
        breakout = out;
        xa = breakout.getSpeed();
        ya = breakout.getSpeed();
        
    }

    public void paint(Graphics g) {
        g.fillOval(xPos, yPos, diameter, diameter);
    }
    
    public void moveBall() {
        
        if (xPos + xa < 0) {
            
           xa = breakout.getSpeed(); 
            
        } else if(xPos + xa > breakout.getWidth() - diameter) {
            
            xa = -breakout.getSpeed();
            
        } else if (yPos + ya < 0) {
            
            ya = breakout.getSpeed(); 
            
        } else if(yPos + ya > breakout.getHeight() - diameter) {
            
            ya = -breakout.getSpeed();
            System.out.println("You lost!");
            breakout.gameLost = true;
            
        } else if(collision()) {
            
            ya = -breakout.getSpeed();
            
        } 

        xPos = xPos + xa;
        yPos = yPos + ya;
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, diameter, diameter);
    }

    public boolean collision() {
        return breakout.getPaddle().getBounds().intersects(getBounds());
    }

    public void setYA(int newValue) {
        ya = newValue;
    }
    public void setXA(int newValue) {
        xa = newValue;
    }
}
