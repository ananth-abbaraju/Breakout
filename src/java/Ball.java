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
    // Declartion of instance variables/objects
    // 3 instance variables, one for xPos, one for Ypos, diameter
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
    // constructor is first thing called when a new Paddle is created
    // the constructor is where any instance variables are given values
    // initializes instance variables
    public Ball(int x, int y, Breakout out) { // declare int x, int y
        // initialize your instance variables
        xPos = x;
        yPos = y;
        diameter = 10;
        breakout = out; // ties the two objects together
        xa = breakout.getSpeed();
        ya = breakout.getSpeed();
    }

    public void paint(Graphics g) {
        // in the Graphics class there is a method called fillOval()
        // java api graphics
        g.fillOval(xPos, yPos, diameter, diameter);
    }
    
    // method when called will have the code that will move the ball
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

    /* -------------------- How to check collision ---------------------- */
    /**
     * To have some type of collusion, the brick needs to have bounds In the class
     * Rectangle, there is a getBounds method
     *
     * @return rectangle's outer most values
     */
    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, diameter, diameter);
    }

    /**
     * There also needs to be collision between the brick and the ball the following
     * method will take care of the collision
     * 
     * @return true if the ball intersects the brick
     */
    public boolean collision() {
        return breakout.getPaddle().getBounds().intersects(getBounds());
    }

    /* ------------------- Getters and Setters -------------------- */
    public void setYA(int newValue) {
        ya = newValue;
    }
    public void setXA(int newValue) {
        xa = newValue;
    }
}
