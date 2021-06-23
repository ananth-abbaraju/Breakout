import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.font.*;

public class Score extends JPanel {
    private Breakout breakout;
    private int width, height;
    public Score(Breakout panel) {
        width = 160;
        height = 35;
        setSize(width, height);
        setLocation(30, 25); // x = 200, y = 50
        setLayout(null);
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
        breakout = panel;
    }


    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new java.awt.Font("Arial", 2, 24));
        g.setColor(Color.MAGENTA);
        g.drawString("SCORE: " + breakout.getScore(), 5, 30);

    }
}
