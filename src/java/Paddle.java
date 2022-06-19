import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
   
    private Breakout breakout;
    private int xPos, yPos, xa;
    private int width, height;
    private int speed;

    public Paddle(int x, int y, Breakout out) {
        xPos = x;
        yPos = y;
        width = 140;
        height = 15;
        xa = 0;
        speed = 5;
        breakout = out;
    }

    public void paint(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(xPos, yPos, width, height);
    }

    public void movePaddle() {
        if (xPos + xa > 0 && xPos + xa < breakout.getWidth() - width) {
            xPos = xPos + xa;
        }
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
   
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = speed;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -speed;
        }
        
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, width, height);
    }

    public int getPaddleTop() {
        return yPos;
    }

    public void setSpeed(int newValue) {
        speed = newValue;
    }
}
