import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// import javax.swing.JPanel;
public class GameWindow extends JFrame {
    // Declartion of instance variables/objects
    private int width, height;
    private static String title;
    // constructor is first thing called when a new Paddle is created
    // the constructor is where any instance variables are given values
    // initializes instance variables
    public GameWindow(String t, int w, int h) throws InterruptedException {
        
        // initialize instance variables
        title = t;
        width = w;
        height = h;

        //methods to make a JFrame/window
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ends the program when you x the window 
        setLocationRelativeTo(null); // places the window in the center
        setLayout(null); // gives absolute positioning; allows you to put things where you want them
        setResizable(false);

        // Construct a Breakout panel
        Breakout out = new Breakout(406, 500);
        Score scoreLabel = new Score(out);
        add(scoreLabel);
        add(out);
        setVisible(true);
        // this while loop will be the game loop that will run
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
