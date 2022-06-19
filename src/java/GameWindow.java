import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// import javax.swing.JPanel;
public class GameWindow extends JFrame {

    private int width, height;
    private static String title;

    public GameWindow(String t, int w, int h) throws InterruptedException {

        title = t;
        width = w;
        height = h;

        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setLayout(null); 
        setResizable(false);

        Breakout out = new Breakout(406, 500);
        Score scoreLabel = new Score(out);
        add(scoreLabel);
        add(out);
        setVisible(true);

        while (true) {
            
            out.move();
            
            if (out.getSpeed() != 0){
                out.repaint();
            }
            
            scoreLabel.repaint();
            Thread.sleep(10);
            
        }
    }
}
