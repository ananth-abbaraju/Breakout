import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Brick {

    private Breakout breakout;
    private int xPos, yPos;
    private int width, height;

    public Brick(int x, int y, Breakout out) {
        xPos = x;
        yPos = y;
        width = 40;
        height = 25;

        breakout = out;
    }

    public void paint(Graphics g) {
        
        if (yPos == 3){
            g.setColor(new Color(0, 255, 255));
        } else if (yPos == 28) {
            g.setColor(new Color(0, 255, 0));
        } else if (yPos == 53){
            g.setColor(new Color(255, 20, 147));
        }
        
        g.fillRect(xPos, yPos, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(xPos, yPos, width, height);
        
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, width, height);
    }

    public boolean collision() {
        return breakout.getBall().getBounds().intersects(getBounds());
    }

}
